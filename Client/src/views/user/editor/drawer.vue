<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-18 13:17:31
 * @LastEditTime: 2024-05-24 17:22:40
 * @FilePath: \Client\src\views\user\editor\drawer.vue
 * @Describe: 
-->
<script lang="ts" setup>
import { ref, inject, Ref, watch, provide } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import type { DrawerProps } from 'element-plus'
import { upload, Deleteimg } from '@/api/upload';
import { poststudys } from '@/api/poststudy'
import { studypostStore } from '@/stores/studypost'
import { useRouter } from 'vue-router'
const router = useRouter()
const study = studypostStore()
const drawer = ref(false)
const direction = ref<DrawerProps['direction']>('rtl')

const content = ref(inject('childCounters'))
const contain = ref(null)

const postvalue = ref({
  title: "",//标题
  intro: '',//简介
  content: "",//文章内容
  post_cover: '',//文章封面
  tag: '',//标签
  author_id: ''
})

watch(content, (newvalue) => {
  contain.value = newvalue as string;
  if (contain.value.poststate == 1) {
    test()
  }
  postvalue.value.content = contain.value.conent
}, { deep: true })



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



const rules = {
  title: [{ required: true, message: '请输入文章标题', trigger: 'blur' }],
  tag: [{ required: true, message: '请填写文章分类', trigger: 'blur' }],
  intro: [{ required: true, message: '请输入文章简介', trigger: 'blur' }]
}
const limit = ref(1)
const easyintroduc = ref(null)

import { Plus } from '@element-plus/icons-vue'

import type { UploadProps, UploadUserFile } from 'element-plus'

const fileList = ref<UploadUserFile[]>([
])

const dialogImageUrl = ref('')
const dialogVisible = ref(false)

const handleRemove: UploadProps['onRemove'] = async (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
  console.log(ress.value)
  if (ress.value) {
    const res = await Deleteimg(ress.value)
  } else {
    const res = await Deleteimg(JSON.parse(localStorage.getItem('user_post_edit')).post_cover)
  }
  postvalue.value.post_cover = ''
  localStorage.setItem("user_post_edit", JSON.stringify(postvalue.value));
}

const handlePictureCardPreview: UploadProps['onPreview'] = (uploadFile) => {
  dialogImageUrl.value = uploadFile.url!
  dialogVisible.value = true
}


const uploads = ref(null)

const ress = ref(null)

const uploadSuccess = (res: { msg: any; }) => {
  console.log(res)
  ress.value = res.msg
  console.log(ress.value)
}
const userInfo = ref({
  uuid: JSON.parse(localStorage.getItem('user-data'))?.id,
  token: JSON.parse(localStorage.getItem('user-data'))?.token
})

const test = () => {
  postvalue.value = study.postvalues
  if (postvalue.value.post_cover) {
    fileList.value.push({
      name: postvalue.value.post_cover,
      url: `http://upload.nanoic.cc/image/${postvalue.value.post_cover}`
    })
  } else {
    fileList.value = []
  }
  console.log(fileList.value)
}

console.log(study.poststate)

function save_draft() {
  postvalue.value.post_cover = ress.value;
  study.setpostvalues(postvalue.value);
  localStorage.setItem("user_post_edit", JSON.stringify(postvalue.value));
  ElMessage({
    type: 'success',
    message: '保存成功',
  })
  router.push('./studyHelp')
}

const form = ref(null)
const studypost = async () => {
  await form.value.validate()
  console.log(postvalue.value.content)
  postvalue.value.post_cover = ress.value;
  const res = await poststudys(postvalue.value)
  localStorage.removeItem('user_post_edit')
  study.removepostvalues()
  router.push('./studyHelp')
  ElMessage({
    type: 'success',
    message: '上传成功',
  })
  console.log(res)
}

</script>
<template>
  <el-button class="introduce" type="primary" style="margin-left: 16px" @click="drawer = true">
    文章简介编写
  </el-button>

  <el-drawer v-model="drawer" title="文章介绍" :direction="direction" :before-close="handleClose">
    <el-form class="contain" ref="form" :model="postvalue" :rules="rules">
      <el-form-item label="文章标题" prop="title">
        <el-input v-model="postvalue.title" placeholder="请输入标题"></el-input>
      </el-form-item>
      <el-form-item label="文章分类" prop="tag">
        <el-input v-model="postvalue.tag" placeholder="请输入文章分类"></el-input>
      </el-form-item>
      <el-form-item label="文章简介" prop="intro">
        <el-input class="cn" type="textarea" placeholder="分享简介" maxlength="150" show-word-limit
          v-model="postvalue.intro"></el-input>
      </el-form-item>
      <el-form-item label="图片上传">
        <el-upload v-model:file-list="fileList" action="http://146.56.193.5:4514/upload/image" list-type="picture-card"
          :on-preview="handlePictureCardPreview" :on-remove="handleRemove" name="file" :limit="1" :headers="userInfo"
          :on-success="uploadSuccess" ref="uploads">
          <el-icon>
            <Plus />
          </el-icon>
        </el-upload>

        <el-dialog v-model="dialogVisible">
          <img w-full :src="dialogImageUrl" alt="" />
        </el-dialog>
      </el-form-item>
      <el-form-item label="提交文章" prop="submit">

        <el-button @click="save_draft">保存草稿</el-button>
        <el-button type="primary" @click="studypost()">上传文章</el-button>
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
  min-width: 100px;
  height: 30px;
  font-size: 12px;
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
