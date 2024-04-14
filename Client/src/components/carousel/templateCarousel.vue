<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-05 10:17:43
 * @LastEditTime: 2024-04-12 22:39:22
 * @FilePath: \UCSP\Client\src\components\carousel\templateCarousel.vue
 * @Describe: 
-->
<template>
  <div
    class="carouselBox"
    :style="{
      borderRadius: Radius,
      border: Border,
      width: Width ? Width : '1200px',
      height: Height ? Height : 'var(--height-carousel-base)'
    }"
  >
    <div class="carousel" :style="{ left: carouselLeft, minWidth: Width ? Width : '1200px' }">
      <div class="carouselItems" v-for="item in carouselData" :key="item.id">
        <img
          class="carouselImage"
          :style="{
            width: Width ? Width : '1200px',
            height: Height ? Height : 'var(--height-carousel-base)'
          }"
          :src="item.src"
          alt=""
        />
      </div>
    </div>
    <div
      class="carouselController"
      :style="{
        width: Width ? Width : '1200px',
        height: Height ? Height : 'var(--height-carousel-base)'
      }"
    >
      <div class="carouselIntro">{{ carouselData[carouselIndex].intro }}</div>
      <div
        class="carouselArrows"
        :style="{
          width: Width ? Width : '1200px',
          height: Height ? Height : 'var(--height-carousel-base)'
        }"
      >
        <div class="carouselArrow arrowLeft" @click="carouselChange('former')">&lt;</div>
        <div class="carouselArrow arrowRight" @click="carouselChange('next')">&gt;</div>
      </div>
      <div class="dotListBox">
        <div
          class="dotItemBox"
          :name="item.id"
          v-for="item in carouselData"
          :key="item.id"
          @click="dotChange(null)"
        >
          <div class="dotItem dotActive"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import request from '@/script/request'

export default {
  //圆角、描边、宽度、高度、数据请求地址
  props: ['Radius', 'Border', 'Width', 'Height', 'Src'],
  data() {
    //这里存放数据
    return {
      carouselLeft: '',
      carouselData: [{ id: 0, src: '', intro: '' }],
      carouselIndex: 0,
      nowIntro: ''
    }
  },
  //监听属性 类似于data概念
  computed: {},
  //监控data中的数据变化
  watch: {},
  //方法集合
  methods: {
    carouselChange(type: string | null) {
      if (type == 'next') {
        if (this.carouselIndex == this.carouselData.length - 1) {
          this.carouselIndex = 0
        } else {
          this.carouselIndex++
        }
      } else if (type == 'former') {
        if (this.carouselIndex == 0) {
          this.carouselIndex = this.carouselData.length - 1
        } else {
          this.carouselIndex--
        }
      } else {
        if (type == null) {
          this.carouselLeft = this.Width
            ? -(parseInt((this.Width as string).replace('px', '')) * this.carouselIndex) + 'px'
            : -(1200 * this.carouselIndex) + 'px'
        }
      }
      this.dotChange(this.carouselIndex)
      this.carouselLeft = this.Width
        ? -(parseInt((this.Width as string).replace('px', '')) * this.carouselIndex) + 'px'
        : -(1200 * this.carouselIndex) + 'px'
      
      /* console.log(this.carouselIndex,this.$el.querySelector('.carousel').style) */
    },
    dotChange(index: number | null) {
      this.clearDot()
      /* console.log(index) */
      if (!index && index != 0) {
        let ele = event?.target as HTMLElement
       /*  console.log(ele) */
        if (ele.classList.value == 'dotItem') {
          ele.classList.add('dotActive')
          /* console.log((ele.parentNode as HTMLElement).getAttribute('name')) */
          if ((ele.parentNode as HTMLElement).getAttribute('name')) {
            this.carouselIndex = Number((ele.parentNode as HTMLElement).getAttribute('name')) - 1
            /* console.log(this.carouselIndex) */
            this.carouselChange(null)
            return (ele.parentNode as HTMLElement).getAttribute('name')
          }
        } else if (ele.classList.value == 'dotItemBox') {
          ele.querySelector('.dotItem')?.classList.add('dotActive')
          /* console.log(ele.getAttribute('name')) */
          if (ele.getAttribute('name')) {
            this.carouselIndex = Number(ele.getAttribute('name')) - 1
            /* console.log(this.carouselIndex) */
            this.carouselChange(null)
            return ele.getAttribute('name')
          }
        }
      } else {
        this.$el
          .querySelector('.dotListBox')
          .querySelectorAll('.dotItemBox')
          .forEach((element: Element, ind: number) => {
            /* console.log(ind, element) */
            if (index == ind) {
              /* console.log(ind, ind) */
              element.querySelector('.dotItem')?.classList.add('dotActive')
            }
          })
      }
    },
    clearDot() {
      this.$el
        .querySelector('.dotListBox')
        .querySelectorAll('.dotItemBox')
        .forEach((element: Element, index: number) => {
          /* console.log(index, element) */
          element.querySelector('.dotItem')?.classList.remove('dotActive')
        })
    },
    async initCarousel(path = '/indexCarousel') {
      /* console.log('init') */
      this.clearDot()
      //等待同步，否则dotChange()中获取值会出问题
      await request.get(path).then((res: any) => {
        /* console.log(res) */
        this.$data.carouselData = res.data
      })
      this.dotChange(0)
    }
  },
  //生命周期 - 创建完成（可以访问当前this实例）
  created() {},
  //生命周期 - 挂载完成（可以访问DOM元素）
  mounted() {
    //初始化轮播
    /* 请求数据 */
    /* console.log(this.Src) */
    if (this.Src) {
      this.initCarousel(this.Src)
    } else {
      this.initCarousel()
    }
  },
  //beforeCreate() {}, //生命周期 - 创建之前
  //beforeMount() {}, //生命周期 - 挂载之前
  //beforeUpdate() {}, //生命周期 - 更新之前
  updated() { } //生命周期 - 更新之后
  //beforeDestroy() {}, //生命周期 - 销毁之前
  //destroyed() {}, //生命周期 - 销毁完成
  //activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style scoped>
.carouselBox {
  height: 100%;
  border-radius: 0;

  border: 1px solid black;
  position: relative;
  overflow: hidden;
}

.carousel {
  display: flex;
  height: 100%;
  position: relative;
  left: 0px;
  transition: all 0.6s ease-in-out;
}

.carouselItems {
  height: 100%;
  width: 1200px;
  position: relative;
}

.carouselIntro {
  position: absolute;
  top: 10px;
  right: 10px;
  height: 40px;
  min-width: 50px;
  background-color: var(--color-white-alpha-05);
  backdrop-filter: blur(2px);
  box-shadow: var(--shadow-level-1);
  padding: 0 15px;
  line-height: 40px;
  font-weight: 700;
  font-size: 18px;
}
.carouselController {
  top: 0;
  position: absolute;
  text-align: center;
  opacity: 0;
  transition: opacity 0.3s ease-in-out;
}
.carousel:hover .carouselController,
.carousel:hover .dotListBox {
  opacity: 1;
}
.carouselArrows {
  align-items: center;
  display: flex;
}
.carouselArrow {
  width: 80px;
  height: 150px;
  font-size: 40px;
  font-weight: 800;
  line-height: 150px;
  background-color: var(--color-white-alpha-07);
  position: absolute;
  cursor: pointer;
}
.arrowLeft {
  left: 0;
}
.arrowRight {
  right: 0;
}

.dotListBox {
  position: absolute;
  left: 50%;
  right: 50%;
  transform: translate(-50%, 10px);
  bottom: 15px;
  min-width: 100px;
  width: fit-content;
  height: 32px;
  border-radius: 25px;
  opacity: 0;
  /* background-color: var(--color-white-alpha-07); */
  display: flex;
  justify-content: space-around;
  line-height: 32px;
  transition: all 0.3s ease-in-out;
}
.dotItemBox {
  margin: 0 5px;
  height: 100%;
  display: flex;
  align-items: center;
}
.carousel:hover .dotListBox {
  transform: translate(-50%, 0);
}
.dotItem {
  transition: all 0.2s ease-in-out;
  height: 5px;
  border-radius: 25px;
  width: 25px;
  background-color: var(--color-white-alpha-05);
}

.dotItemBox:hover .dotItem {
  width: 40px;
}

.dotActive {
  width: 40px;
  background-color: white;
}
/*@import url(); 引入公共css类*/
</style>
