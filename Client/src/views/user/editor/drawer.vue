<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-18 13:17:31
 * @LastEditTime: 2024-05-24 17:22:40
 * @FilePath: \Client\src\views\user\editor\drawer.vue
 * @Describe: 
-->
<script lang="ts" setup>
import { ref } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import type { DrawerProps } from 'element-plus'

const drawer = ref(false)
const direction = ref<DrawerProps['direction']>('rtl')
const handleClose = (done: () => void) => {
  ElMessageBox.confirm('你确认关闭文章简介编辑', '提醒', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  })
    .then(() => {
      done()
    })
    .catch(() => {
      ElMessage({
        type: 'success',
        message: '取消成功'
      })
    })
}

const options = ref([
  {
    value: '1',
    label: '全部'
  },
  {
    value: '2',
    label: '前端'
  },
  {
    value: '3',
    label: 'javaScript'
  },
  {
    value: '4',
    label: 'Vue.js'
  },
  {
    value: '5',
    label: 'React.js'
  },
  {
    value: '6',
    label: '面试'
  },

  {
    value: '7',
    label: 'css'
  },
  {
    value: '8',
    label: 'java'
  },
  {
    value: '9',
    label: 'python'
  }
])

const formodel = ref({
  title: '',
  kind: '',
  introduce: ''
})

const rules = {
  title: [{ required: true, message: '请输入文章标题', trigger: 'blur' }],
  kind: [{ required: true, message: '请填写文章分类', trigger: 'blur' }],
  introduce: [{ required: true, message: '请输入文章简介', trigger: 'blur' }]
}
const limit = ref(1)
const easyintroduc = ref(null)

import { Plus } from '@element-plus/icons-vue'

import type { UploadProps, UploadUserFile } from 'element-plus'

const fileList = ref<UploadUserFile[]>([])

const limits = ref(1)

const dialogImageUrl = ref('')
const dialogVisible = ref(false)

const handleRemove: UploadProps['onRemove'] = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
}

const handlePictureCardPreview: UploadProps['onPreview'] = (uploadFile) => {
  dialogImageUrl.value = uploadFile.url!
  dialogVisible.value = true
}

const userInfo = ref({
  uuid: JSON.parse(localStorage.getItem('user-data'))?.id,
  token: JSON.parse(localStorage.getItem('user-data'))?.token
})

const { post_content } = defineProps(['post_content']);

const post_value = ref({
  title: "",//标题
  intro: '',//简介
  content: "",//文章内容
  post_cover: '',//文章封面
  tag: '',//标签
})

const save_draft = () => {
  post_value.value.title = formodel.value.title;//标题
  post_value.value.intro = formodel.value.introduce;//简介
  post_value.value.tag = formodel.value.kind;//标签
  post_value.value.post_cover = dialogImageUrl.value;
  post_value.value.content = post_content;

  localStorage.set("user_post_edit", post_value);
}
  
</script>
<template>
  <el-button class="introduce" type="primary" style="margin-left: 16px" @click="drawer = true">
    文章简介编写
  </el-button>

  <el-drawer v-model="drawer" title="文章介绍" :direction="direction" :before-close="handleClose">
    <el-form class="contain" :model="formodel" :rules="rules">
      <el-form-item label="文章标题" prop="title">
        <el-input v-model="formodel.title" placeholder="请输入标题"></el-input>
      </el-form-item>
      <el-form-item label="文章分类" prop="kind">
        <el-select-v2
          v-model="formodel.kind"
          filterable
          :options="options"
          placeholder="全部"
          style="width: 100%; height: 25px"
          :multiple-limit="limit"
        />
      </el-form-item>
      <el-form-item label="文章简介" prop="introduce">
        <el-input
          class="cn"
          type="textarea"
          placeholder="分享简介"
          maxlength="150"
          show-word-limit
          v-model="formodel.introduce"
        ></el-input>
      </el-form-item>
      <el-form-item label="图片上传">
        <el-upload
          v-model:file-list="fileList"
          action="http://146.56.193.5:4514/upload/image"
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          name="file"
          :limit="1"
          :headers="userInfo"
        >
          <el-icon><Plus /></el-icon>
        </el-upload>

        <el-dialog v-model="dialogVisible">
          <img w-full :src="dialogImageUrl" alt="" />
        </el-dialog>
      </el-form-item>
      <el-form-item label="提交文章" prop="submit">
        
        <el-button @click="save_draft">保存草稿</el-button>
        <el-button type="primary">上传文章</el-button>
      </el-form-item>
    </el-form>
  </el-drawer>
</template>

<style scoped lang="scss">
.introduce {
  position: absolute;
  top: 75px;
  right: 40px;
  z-index: 100;
}

.contain {
  height: auto;
  width: 100%;
}

::v-deep(.cn) {
  .el-textarea__inner {
    resize: none;
    height: 120px;
  }
}
</style>
