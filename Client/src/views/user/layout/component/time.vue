<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-26 17:34:53
 * @LastEditTime: 2024-04-26 21:38:31
 * @FilePath: \Client\src\views\user\layout\component\time.vue
 * @Describe: 
-->
<script setup>
import timer from './time/time.vue'
</script>

<template>
  <div class="timer">
    <timer>
      <template #holidayName>暑假</template>
      <template #day>73</template>
      <template #hour>13</template>
      <template #minute>09</template>
      <template #second>54</template>
    </timer>
    <timer>
      <template #holidayName>五一</template>
      <template #day>11</template>
      <template #hour>45</template>
      <template #minute>14</template>
      <template #second>19</template>
    </timer>
  </div>
</template>
<style lang="scss" scoped>
.timer {
  width: 940px;
  height: 329px;
  background: #ffffff;
  position: relative;
  left: 250px;
  top: -202px;
  padding-top: 11px;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
}
</style>
