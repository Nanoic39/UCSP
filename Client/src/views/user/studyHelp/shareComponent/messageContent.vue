<script setup>
import { ref, onMounted } from 'vue'
import '@/assets/font/font.css'
import '@/assets/svg/helpeach/eyes/iconfont.css'
import '@/assets/svg/helpeach/agree/iconfont.css'
import '@/assets/svg/helpeach/share/iconfont.css'
import '@/assets/svg/helpeach/collect/iconfont.css'
import { poststudys } from '@/api/poststudy';

const userid = JSON.parse(localStorage.getItem('user-data')).uuid

const contents = ref({
  title: '高等数学A2定积分学习分享经验',
  content: '滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事， 谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，。',
  author_id: userid,
  tag: '高等数学',
  intro: 'a',
  post_cover: 'b',
})
// console.log(contents.value)

const posts = async () => {
  const res = await poststudys(contents.value)
}
// posts()

const statics = ref([
  {
    id: 1,
    url: 'iconfont icon-fenxiang',
    names: '分享'
  },
  {
    id: 2,
    url: 'iconfont icon-damuzhi',
    names: '点赞'
  },
  {
    id: 3,
    url: 'iconfont icon-shoucang',
    names: '收藏'
  }
])

const getClass = (items) => {
  return items
}

const iconfonts = ref(null)
const iconState = ref(null)

onMounted(() => {
  iconState.value = iconfonts['_rawValue']
  const iconfont = document.querySelectorAll('.contain .iconfont')

  iconfont.forEach((element, index) => {
    element.addEventListener('click', () => changeState(index))
  })
})

const changeState = (index) => {
  if (index == 0) {
    if (iconState.value[index].style.color != 'skyblue') {
      iconState.value[index].style.color = 'skyblue'
    } else {
      iconState.value[index].style.color = 'black'
    }
  } else if (index == 1) {
    if (iconState.value[index].style.color != 'red') {
      iconState.value[index].style.color = 'red'
    } else {
      iconState.value[index].style.color = 'black'
    }
  } else if (index == 2) {
    if (iconState.value[index].style.color != 'orange') {
      iconState.value[index].style.color = 'orange'
    } else {
      iconState.value[index].style.color = 'black'
    }
  }
}

</script>

<template>
  <div class="messageContent">
    <div class="body">
      <div class="top">
        <div class="messageTitle">高等数学A2定积分学习分享经验</div>
        <div class="introduce">
          <div class="author">褚亦菲</div>
          <div class="time">2024-4-10</div>
          <div class="eyes">
            <div class="iconfont icon-xiaoyanjing"></div>
            <div class="amount">750</div>
          </div>
        </div>
      </div>
      <div class="bottom">
        <div class="message">
          滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，
          谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，惯看秋月春风。一壶浊酒喜相逢，古今多少事，都付笑谈中。滚滚长江东逝水，浪花淘尽英雄。是非成败转头空，青山依旧在，几度夕阳红。白发渔樵江渚上，。
        </div>
      </div>
      <div class="tag">
        <div class="tagName">标签：</div>
        <div class="tags">高等数学</div>
      </div>
    </div>
    <div class="foot">
      <div class="data" v-for="item in statics" :key="item">
        <div class="contain">
          <div ref="iconfonts" class="iconfont" :class="getClass(item.url)"></div>
          <div class="text">{{ item.names }}</div>
        </div>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.messageContent {
  width: 749px;
  min-height: 600px;
  background-color: #ffffff;
  display: flex;
  flex-wrap: wrap;
  padding-top: 24px;

  .body {
    width: 675px;
    min-height: 560px;
    margin-left: 36px;
    display: flex;
    flex-wrap: wrap;
    padding-bottom: 10px;

    .top {
      width: 100%;
      height: 68px;
      position: relative;

      .messageTitle {
        min-width: 340px;
        max-width: 700px;
        height: 33px;
        font-size: 24px;
        font-weight: 700;
        color: #3d3d3d;
        line-height: 33px;
        font-family: 'Alibaba-PuHuiTi-B';
      }

      .introduce {
        min-width: 160px;
        max-width: 200px;
        height: 16px;
        position: absolute;
        top: 35px;
        display: flex;
        gap: 15px;

        .author {
          min-width: 36px;
          max-width: 75px;
          height: 16px;
          font-size: 12px;
          color: #717171;
          line-height: 16px;
          font-family: 'Alibaba-PuHuiTi-B';
        }

        .time {
          min-width: 50px;
          max-width: 68px;
          height: 16px;
          font-size: 12px;
          color: #717171;
          line-height: 16px;
          font-family: 'Alibaba-PuHuiTi-B';
        }

        .eyes {
          min-width: 43px;
          max-width: 55px;
          height: 16px;
          display: flex;

          .iconfont {
            width: 16px;
            height: 13px;
            font-size: 12px;
            padding-top: 3px;
          }

          .amount {
            min-width: 27px;
            max-width: 39px;
            height: 16px;
            font-size: 12px;
            color: #717171;
            line-height: 16px;
            font-family: 'Alibaba-PuHuiTi-B';
          }
        }
      }
    }

    .bottom {
      width: 100%;
      position: relative;
      min-height: 460px;
      padding-bottom: 20px;

      .message {
        width: 100%;
        min-height: 460px;
        font-size: 12px;
        color: #3d3d3d;
        font-family: 'Alibaba-PuHuiTi-B';
      }
    }

    .tag {
      width: 80px;
      height: 17px;
      display: flex;
      position: relative;

      .tagName {
        width: 30px;
        height: 17px;
        font-size: 10px;
        color: #717171;
        line-height: 17px;
        font-family: 'Alibaba-PuHuiTi-B';
      }

      .tags {
        width: 49px;
        height: 17px;
        background-color: #f6f9ff;
        text-align: center;
        line-height: 17px;
        font-size: 9px;
        color: #3e84fe;
        font-family: 'Alibaba-PuHuiTi-B';
        border-radius: 3px;
      }
    }
  }

  .foot {
    width: 100%;
    height: 40px;
    border-top: 1px solid #bab7b7;
    display: flex;
    justify-content: space-between;

    .data {
      width: 120px;
      height: 40px;
      position: relative;

      .contain {
        width: 42px;
        height: 16px;
        margin: auto;
        position: absolute;
        top: 16px;
        left: 36px;
        gap: 3px;
        display: flex;

        .iconfont {
          width: 16px;
          height: 16px;
          margin-top: -1px;
        }

        .icon-fenxiang {
          margin-top: -2px;
        }

        .text {
          width: 24px;
          height: 16px;
          font-size: 10px;
          color: #717171;
          line-height: 16px;
          font-family: 'Alibaba-PuHuiTi-B';
        }
      }
    }
  }
}
</style>
