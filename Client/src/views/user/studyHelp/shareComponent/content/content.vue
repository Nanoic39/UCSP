<script setup>
import '@/assets/font/font.css'
import '@/assets/svg/helpeach/agree/iconfont.css'
import '@/assets/svg/helpeach/review/iconfont.css'
import { ArrowDown } from '@element-plus/icons-vue'
import { ref, onMounted, nextTick } from 'vue'
import { timing } from '@/stores/time'

const statics = ref(null)

import { readreview, postreview, morereview } from '@/api/review'

const mustread = ref({
  post_id: '',
  num: 0
})

mustread.value.post_id = JSON.parse(localStorage.getItem('postid'))


const lengths = ref(null)

const addstate = ref([])
const readall = async () => {
  const res = await readreview(mustread.value)
  // console.log(res.data)
  statics.value = res.data.data
  lengths.value = res.data.data.length
  console.log(statics.value)

  for (let i = 0; i < statics.value.length; i++) {
    statics.value[i].create_time = timing(res.data.data[i].create_time)
    stations.value[i] = true;
    addstate.value[i] = 0
    for (let a = 0; a < statics.value[i].comments.length; a++) {
      statics.value[i].comments[a].create_time = timing(res.data.data[i].comments[a].create_time)
    }
  }
}

readall()

const review = ref(null)

const publish = ref('')
const states = ref(null)

const replyword = ref('评论')

const word = ref("平等交流，友善表达")

const changestates = (index, names) => {
  word.value = '回复' + `${names}`
  if (states.value !== index) {
    states.value = index
    station.value = null
    replyword.value = '取消评论'
  } else {
    states.value = null
    replyword.value = '评论'
  }
}


const words = ref("平等交流，友善表达")

const station = ref(null)
const replywords = ref('回复')
const changestation = (indexs, name) => {
  words.value = '回复' + `${name}`
  if (station.value !== indexs) {
    station.value = indexs
    states.value = null
    replywords.value = '取消回复'
  } else {
    station.value = null
    replywords.value = '回复'
  }
}

const loves = ref(null)

const muststatic = ref({
  content: '',
  post_id: '',
  comments_id: ''
})
muststatic.value.post_id = JSON.parse(localStorage.getItem('postid'))

const postson = async (index) => {
  muststatic.value.comments_id = index
  // console.log(muststatic.value)
  const res = await postreview(muststatic.value)
  muststatic.value.content = ''
  states.value = null
  console.log(res)
}

const muststatics = ref({
  content: '',
  post_id: '',
  comments_id: '',
  reply_id: ''
})

muststatics.value.post_id = JSON.parse(localStorage.getItem('postid'))

const postsonreview = async (index, indexs) => {
  muststatics.value.comments_id = index
  muststatics.value.reply_id = indexs
  // console.log(muststatic.value)
  const res = await postreview(muststatics.value)
  station.value = null
  muststatics.value.content = ''
  console.log(res)
}



const morestatic = ref({
  post_id: '',
  num: ''
})

const arr = ref()
const stations = ref([])

const add = async (index, indexs, indexes, content) => {
  morestatic.value.post_id = indexes
  morestatic.value.num = addstate.value[index]
  const res = await morereview(morestatic.value)
  console.log(res.data.data, 1)
  arr.value = res.data.data
  // console.log(content, 1)

  if (arr.value.length < 5) {
    stations.value[index] = false;
    morestatic.value.num = 0
  }
  for (let i = 0; i < arr.value.length; i++) {
    arr.value[i].create_time = timing(arr.value[i].create_time)
    content.push(arr.value[i])
  }
  addstate.value[index] += 1
}

const changelove = (firsts, indexss) => {
  if (indexss == 0) {
    statics.value[firsts].thumbsUp = 1;
  } else {
    statics.value[firsts].thumbsUp = 0;
  }

}

const changeloves = (first, second, indexs) => {
  if (indexs == null) {
    statics.value[first].comments[second].thumbsUp = 1;
  } else {
    statics.value[first].comments[second].thumbsUp = null;
  }
  // console.log(indexs)
}

const readstatic = ref({
  post_id: '',
  num: 0
})
readstatic.value.post_id = JSON.parse(localStorage.getItem('postid'))

const arrr = ref(null)
const morestate = ref(true)
const moresss = ref(2)
const readmore = async () => {
  readstatic.value.num += 1
  const res = await readreview(readstatic.value)
  console.log(res.data)
  console.log(res.data.data)
  arrr.value = res.data.data
  if (arrr.value.length < 5) {
    morestate.value = false;
  }
  for (let i = 0; i < arrr.value.length; i++) {
    arrr.value[i].create_time = timing(arrr.value[i].create_time)
    for (let a = 0; a < arrr.value[i].comments.length; a++) {
      arrr.value[i].comments[a].create_time = timing(arrr.value[i].comments[a].create_time)
    }
    statics.value.push(arrr.value[i])
  }

  for (let b = moresss.value; b < arrr.value.length + moresss.value; b++) {
    stations.value[b] = true;
    addstate.value[b] = 0
  }

  moresss.value += 5
}

</script>

<template>
  <div class="content" ref="review" v-for="(item, index) in statics" :key="item.id">
    <div class="headimg"></div>
    <div class="main">
      <div class="name">{{ item.user_name }}</div>
      <div class="message">
        {{ item.content }}
      </div>
      <div class="bottom">
        <div class="static">
          <div class="time">{{ item.create_time }}</div>
          <div class="agree">
            <div @click="changelove(index, item.thumbsUp)" v-if="item.thumbsUp == 0" class="iconfont icon-damuzhi"
              style="color: black;">
            </div>
            <div @click="changelove(index)" v-if="item.thumbsUp == 1" class="iconfont icon-damuzhi" style="color: red;">
            </div>
            <div class="word">点赞</div>
          </div>
          <div class="comment" :class="{ Colors: item.id === states }" @click="changestates(item.id, item.user_name)">
            <div class="iconfont icon-pinglun"></div>
            <div class="word" :class="{ Colors: item.id === states }">{{ item.id ===
              states ? '取消回复' : '回复' }}</div>
          </div>
        </div>
      </div>
    </div>
    <div class="reply" v-if="states == item.id">
      <el-input class="cn" type="textarea" :placeholder=word v-model="muststatic.content" maxlength="1000"
        show-word-limit></el-input>
      <el-button class="btn" @click="postson(item.id)">发送</el-button>
    </div>
    <div class="contents" v-for="(items, indexs) in item.comments" :key="indexs">
      <div class="headimg"></div>
      <div class="main">
        <div class="name">{{ items.user_name && items.reply_name ? items.user_name + ' 回复 ' + items.reply_name :
          items.user_name }}</div>
        <div class="message">
          {{ items.content }}
        </div>
        <div class="bottom">
          <div class="static">
            <div class="time">{{ items.create_time }}</div>
            <div class="agree">
              <div @click="changeloves(index, indexs, items.thumbsUp)" v-if="items.thumbsUp == null"
                class="iconfont icon-damuzhi" style="color: black;">
              </div>
              <div @click="changeloves(index, indexs, items.thumbsUp)" v-if="items.thumbsUp == 1"
                class="iconfont icon-damuzhi" style="color: red;">
              </div>
              <div class="word">点赞</div>
            </div>
            <div class="comment" :class="{ Colors: items.id === station }"
              @click="changestation(items.id, items.user_name)">
              <div class="iconfont icon-pinglun"></div>
              <div class="word" :class="{ Colors: items.id === station }">{{ items.id === station ? '取消回复' : '回复' }}
              </div>
            </div>
          </div>
        </div>
        <div class="replys" v-if="station == items.id">
          <el-input class="cn" type="textarea" :placeholder=words v-model="muststatics.content" maxlength="1000"
            show-word-limit></el-input>
          <el-button class="btn" @click="postsonreview(item.id, items.id)">发送</el-button>
        </div>
      </div>
    </div>
    <div class="more" v-if="stations[index]">
      <div class="word" @click="add(index, indexs, item.id, item.comments)">查看更多评论</div>
      <el-icon class="icon">
        <ArrowDown />
      </el-icon>
    </div>
  </div>
  <div class="last" v-if="morestate" @click="readmore()">查看更多评论</div>

</template>
<style scoped lang="scss">
.Colors {
  color: #3e84fe !important;
  // cursor: pointer !important;
}

.Color {
  color: red !important;
  cursor: pointer !important;
}

.contentss {
  width: 100%;
  height: auto;
}

.content {
  width: 100%;
  height: auto;
  display: flex;
  flex-wrap: wrap;
  gap: 12px;

  .headimg {
    width: 38px;
    height: 38px;
    border-radius: 50%;
    background-image: url('@/assets/layout/211540yrmp8w0prt8opzm0.jpg');
    background-repeat: no-repeat;
    background-size: cover;
  }

  .main {
    width: 460px;
    min-height: 76px;

    .name {
      min-width: 33px;
      height: 16px;
      margin-top: 3px;
      font-size: 12px;
      color: #717171;
      line-height: 16px;
      font-family: 'Alibaba-PuHuiTi-B';
    }

    .message {
      width: 456px;
      min-height: 32px;
      max-height: 64px;
      margin-top: 7px;
      font-size: 12px;
      color: #3d3d3d;
      font-family: 'Alibaba-PuHuiTi-B';
      line-height: 16px;
    }

    .bottom {
      width: 100%;
      height: 14px;
      display: flex;
      gap: 470px;

      .static {
        min-width: 140px;
        height: 14px;
        margin-top: 4px;
        display: flex;
        gap: 11px;

        .time {
          min-width: 42px;
          height: 14px;
          color: #717171;
          font-size: 10px;
          line-height: 14px;
          font-family: 'Alibaba-PuHuiTi-B';
        }

        .iconfont {
          width: 14px;
          height: 14px;
        }

        .word {
          width: 20px;
          height: 14px;
          font-size: 10px;
          line-height: 14px;
          font-family: 'Alibaba-PuHuiTi-B';
          color: #717171;
        }

        .agree {
          width: 37px;
          height: 14px;
          display: flex;
          gap: 3px;

          .iconfont {
            font-size: 14px;
          }
        }

        .comment {
          width: 38px;
          height: 14px;
          display: flex;
          gap: 3px;
          cursor: pointer;

          .iconfont:hover {
            color: #3e84fe;
          }

          .word {
            min-width: 45px;
            height: 14px;
          }
        }
      }

      .more {
        width: 16px;
        height: 16px;
      }
    }
  }

  .reply {
    width: 620px;
    height: 88px;
    position: relative;
    left: 50px;

    ::v-deep(.cn) {
      .el-textarea__inner {
        resize: none;
        height: 88px;
        background-color: #efefef;
      }

      .el-input__count {
        right: 90px;
        background-color: #efefef;
        bottom: 10px;
      }
    }

    .btn {
      width: 60px;
      height: 29px;
      font-size: 14px;
      color: #ffffff;
      line-height: 29px;
      font-family: 'Alibaba-PuHuiTi-B';
      position: absolute;
      right: 12px;
      bottom: 5px;
      background-color: #3e84fe;
    }
  }
}

.contents {
  width: 627px;
  margin-left: 50px;
  min-height: 76px;
  display: flex;
  gap: 12px;

  .headimg {
    width: 38px;
    height: 38px;
    border-radius: 50%;
    background-image: url('@/assets/layout/211540yrmp8w0prt8opzm0.jpg');
    background-repeat: no-repeat;
    background-size: cover;
  }

  .main {
    width: 460px;
    min-height: 76px;

    .name {
      min-width: 33px;
      height: 16px;
      margin-top: 3px;
      font-size: 12px;
      color: #717171;
      line-height: 16px;
      font-family: 'Alibaba-PuHuiTi-B';
    }

    .message {
      width: 456px;
      min-height: 32px;
      max-height: 64px;
      margin-top: 7px;
      font-size: 12px;
      color: #3d3d3d;
      font-family: 'Alibaba-PuHuiTi-B';
      line-height: 16px;
    }

    .bottom {
      width: 100%;
      height: 14px;
      display: flex;
      gap: 470px;

      .static {
        min-width: 140px;
        height: 14px;
        margin-top: 4px;
        display: flex;
        gap: 11px;

        .time {
          min-width: 42px;
          height: 14px;
          color: #717171;
          font-size: 10px;
          line-height: 14px;
          font-family: 'Alibaba-PuHuiTi-B';
        }

        .iconfont {
          width: 14px;
          height: 14px;
        }

        .word {
          width: 20px;
          height: 14px;
          font-size: 10px;
          line-height: 14px;
          font-family: 'Alibaba-PuHuiTi-B';
          color: #717171;
        }

        .agree {
          width: 37px;
          height: 14px;
          display: flex;
          gap: 3px;

          .iconfont {
            font-size: 14px;
          }
        }

        .comment {
          width: 38px;
          height: 14px;
          display: flex;
          gap: 3px;
          cursor: pointer;

          .iconfont:hover {
            color: #3e84fe;
          }
        }
      }
    }

    .replys {
      width: 570px;
      height: 88px;
      position: relative;
      top: 10px;
      // left: 50px;

      ::v-deep(.cn) {
        .el-textarea__inner {
          resize: none;
          height: 88px;
          background-color: #efefef;
        }

        .el-input__count {
          right: 90px;
          background-color: #efefef;
          bottom: 10px;
        }
      }

      .btn {
        width: 60px;
        height: 29px;
        font-size: 14px;
        color: #ffffff;
        line-height: 29px;
        font-family: 'Alibaba-PuHuiTi-B';
        position: absolute;
        right: 12px;
        bottom: 5px;
        background-color: #3e84fe;
      }
    }
  }
}

.more {
  width: 150px;
  margin-left: 100px;
  height: 20px;
  display: flex;
  gap: 3px;
  font-size: 12px;
  color: #717171;
  line-height: 16px;
  line-height: 20px;
  cursor: pointer;

  .icon {
    width: 15px;
    height: 15px;
    margin-top: 3px;
  }
}

.last {
  margin-top: 16px;
  width: 100%;
  height: 40px;
  text-align: center;
  font-size: 12px;
  color: #717171;
  line-height: 40px;
  font-family: 'Alibaba-PuHuiTi-B';
  background-color: #efefef;
  cursor: pointer;
}
</style>
