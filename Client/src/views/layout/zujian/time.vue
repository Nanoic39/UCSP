<script setup>
import timeleft from './time/timeleft.vue'
import timeright from './time/timeright.vue'
</script>

<template>
  <div class="timer">
    <timeleft>
      <template #first>73</template>
      <template #second>13</template>
      <template #third>09</template>
      <template #fourth>54</template>
    </timeleft>
    <timeright>
      <template #first>73</template>
      <template #second>13</template>
      <template #third>09</template>
      <template #fourth>54</template>
    </timeright>
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
