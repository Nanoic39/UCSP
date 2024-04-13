<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="dna">
    <span data-txt="n" style="--i: 0"></span>
    <span data-txt="i" style="--i: 1"></span>
    <span data-txt="c" style="--i: 2"></span>
    <span data-txt="e" style="--i: 3"></span>
    <span data-txt="," style="--i: 4"></span>
    <span data-txt="t" style="--i: 5"></span>
    <span data-txt="o" style="--i: 6"></span>
    <span data-txt="," style="--i: 7"></span>
    <span data-txt="m" style="--i: 8"></span>
    <span data-txt="e" style="--i: 9"></span>
    <span data-txt="e" style="--i: 10"></span>
    <span data-txt="t" style="--i: 11"></span>
    <span data-txt="," style="--i: 12"></span>
    <span data-txt="y" style="--i: 13"></span>
    <span data-txt="o" style="--i: 14"></span>
    <span data-txt="u" style="--i: 15"></span>
    <span data-txt="!" style="--i: 16"></span>
  </div>
</template>

<script setup></script>

<style lang="scss" scoped>
.dna {
  width: 450px;
  perspective: 400px;
  transform-style: preserve-3d;
}

span {
  position: relative;
  color: rgb(22, 22, 244);
  width: 10px;
  height: 120px;
  float: left;
  margin: 0 8px;
  transform: rotateX(-360deg);
  animation: run 3.5s linear infinite;
  animation-delay: calc(0.15s * var(--i));
  font-weight: 800;
}

span:before,
span:after {
  position: absolute;
  content: attr(data-txt);
  font-family: 'Poppins';
  font-size: 24px;
  left: 50%;
  transform: translateX(-50%);
}

span:before {
  top: -2px;
}

span:after {
  bottom: -2px;
}

@keyframes run {
  to {
    transform: none;
  }
}
</style>
