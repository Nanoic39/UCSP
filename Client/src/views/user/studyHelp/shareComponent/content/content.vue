<script setup>
import '@/assets/font/font.css'
import '@/assets/svg/helpeach/agree/iconfont.css'
import '@/assets/svg/helpeach/review/iconfont.css'
import { ArrowDown } from '@element-plus/icons-vue'
import { ref } from 'vue'

const statics = ref([
  {
    id: 1, name: '关益辰', message: '1小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！', time: '22小时前', agreestate: 1, son: [{
      id: 1, name: '关益辰', message: '1小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！', time: '22小时前', agreestate: 2,
    },
    {
      id: 2, name: '关益辰', message: '2小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！', time: '22小时前', agreestate: 3,
    }]
  },
  {
    id: 2, name: '关益辰', message: '2小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！', time: '22小时前', agreestate: 4, son: [{
      id: 1, name: '关益辰', message: '1小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！', time: '22小时前', agreestate: 5,
    },
    {
      id: 2, name: '关益辰', message: '2小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！', time: '22小时前', agreestate: 6,
    }]
  },
])

// watch(amount, (newvalue, oldvalue) => {
//   console.log(newvalue)
//   if (newvalue - oldvalue == 5) {
//     for (let i = amount.value - 5; i < amount.value; i++) {
//       staticss.value[i] = arr.value[i - oldvalue]
//     }
//     console.log(staticss.value)
//   } else {
//     for (let i = oldvalue; i < newvalue; i++) {
//       staticss.value[i] = arr.value[i - oldvalue]
//     }
//   }
//   console.log(newvalue, oldvalue)

// })
const arr = ref(null)
arr.value = [
  {
    id: 1, name: '关益辰', message: '1小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！', time: '22小时前', agreestate: 7,
  },
  {
    id: 2, name: '关益辰', message: '2小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！', time: '22小时前', agreestate: 8,
  },
  {
    id: 3, name: '关益辰', message: '3小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！', time: '22小时前', agreestate: 9,
  },
  {
    id: 4, name: '关益辰', message: '4小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！', time: '22小时前', agreestate: 10,
  },
  {
    id: 5, name: '关益辰', message: '5小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！', time: '22小时前', agreestate: 11,
  }
]

const lengths = ref(arr.value.length)

const add = (index) => {
  console.log(statics.value[index].son)
  for (let i = 0; i < lengths.value; i++) {
    statics.value[index].son.push(arr.value[i])
  }
}

// console.log(arr.value)

const review = ref(null)

const activeIndex = ref(null)

const changeindex = (index) => {
  if (activeIndex.value !== index) {
    activeIndex.value = index
  } else {
    activeIndex.value = null
  }

}

const publish = ref('')
const states = ref(null)

const replyword = ref('评论')
const changestates = (index) => {
  if (states.value !== index) {
    states.value = index
    station.value = null
    replyword.value = '取消评论'
  } else {
    states.value = null
    replyword.value = '评论'
  }
}

const station = ref(null)
const replywords = ref('回复')
const changestation = (indexs) => {
  if (station.value !== indexs) {
    station.value = indexs
    states.value = null
    replywords.value = '取消回复'
  } else {
    station.value = null
    replywords.value = '回复'
  }
}
</script>

<template>
  <div class="content" ref="review" v-for="(item, index) in statics" :key="item.id">
    <div class="headimg"></div>
    <div class="main">
      <div class="name">{{ item.name }}</div>
      <div class="message">
        {{ item.message }}
      </div>
      <div class="bottom">
        <div class="static">
          <div class="time">{{ item.time }}</div>
          <div class="agree">
            <div class="iconfont icon-damuzhi" @click="changeindex(item.agreestate)"
              :class="{ Color: item.agreestate === activeIndex }">
            </div>
            <div class="word">点赞</div>
          </div>
          <div class="comment" :class="{ Colors: index === states }" @click="changestates(index)">
            <div class="iconfont icon-pinglun"></div>
            <div class="word" :class="{ Colors: index === states }">{{ replyword }}</div>
          </div>
        </div>
      </div>
    </div>
    <div class="reply" v-if="states == index">
      <el-input class="cn" type="textarea" placeholder="平等交流，友善表达" v-model="publish" maxlength="1000"
        show-word-limit></el-input>
      <el-button class="btn">发送</el-button>
    </div>
    <div class="contents" v-for="(items, indexs) in item.son" :key="indexs">
      <div class="headimg"></div>
      <div class="main">
        <div class="name">{{ items.name }}</div>
        <div class="message">
          {{ items.message }}
        </div>
        <div class="bottom">
          <div class="static">
            <div class="time">{{ items.time }}</div>
            <div class="agree">
              <div class="iconfont icon-damuzhi" @click="changeindex(items.agreestate)"
                :class="{ Color: items.agreestate === activeIndex }"></div>
              <div class="word">点赞</div>
            </div>
            <div class="comment" :class="{ Colors: index === station }" @click="changestation(indexs)">
              <div class="iconfont icon-pinglun"></div>
              <div class="word" :class="{ Colors: index === station }">{{ replywords }}</div>
            </div>
          </div>
        </div>
        <div class="replys" v-if="station == indexs">
          <el-input class="cn" type="textarea" placeholder="平等交流，友善表达" v-model="publish" maxlength="1000"
            show-word-limit></el-input>
          <el-button class="btn">发送</el-button>
        </div>
      </div>
    </div>
    <div class="more">
      <div class="word" @click="add(index)">查看全部56条评论</div>
      <el-icon class="icon">
        <ArrowDown />
      </el-icon>
    </div>
  </div>


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
      max-width: 75px;
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
        width: 140px;
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
      max-width: 75px;
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
        width: 140px;
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
</style>
