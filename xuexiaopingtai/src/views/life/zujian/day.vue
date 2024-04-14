<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="item item-li">
    <slot></slot>
    你已入站10天
  </div>
</template>

<script setup></script>

<style lang="scss" scoped>
.item {
  position: relative;
  z-index: 0;
  width: 250px;
  height: 150px;
  border-radius: 10px;
  overflow: hidden;
  font-size: 60px;
  text-align: center;
  line-height: 150px;
  color: rgb(59, 180, 211);
}
.item::before {
  content: '';
  position: absolute;
  z-index: -2;
  left: -50%;
  top: -50%;
  width: 200%;
  height: 200%;
  background-color: #0d79cc;
  background-repeat: no-repeat;
  background-position: 0 0;
  background-image: conic-gradient(
    transparent,
    rgba(168, 239, 255, 1),
    transparent 30%
  );
  animation: rotate 6s linear infinite;
}

.item::after {
  content: '';
  position: absolute;
  z-index: -1;
  left: 6px;
  top: 6px;
  width: 238px;
  height: 138px;
  background: #032e5e;
  border-radius: 5px;
}

.item:hover::before {
  animation-play-state: paused;
}

.item-li::after {
  animation: change 4s infinite linear;
}

@keyframes rotate {
  100% {
    transform: rotate(1turn);
  }
}

@keyframes change {
  50% {
    opacity: 0.5;
  }
  100% {
    opacity: 1;
  }
}
</style>
