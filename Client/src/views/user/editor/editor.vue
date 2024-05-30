<script setup>
import tinys from '@/views/commonalityElement/TinymceEditor/tiny.vue'
import drawers from './drawer.vue'
import { upload } from '@/api/upload'
import { onMounted, ref, provide, watch, inject } from 'vue'
import request from '@/utils/request'

const post_value = ref({
  content: '' //内容
})

const handleUpdate = (item) => {
  post_value.value.content = item
  console.log(item)
}

const childCounters = ref(null);
const historystatess = ref(null)

const handleCounterUpdates = (newValue) => {
  childCounters.value = newValue;
  // console.log(childCounters.value)
};
provide('childCounters', childCounters);

</script>

<template>
  <div class="editors">
    <tinys @handleAdd="handleUpdate" @update:Values="handleCounterUpdates"></tinys>
  </div>
  <drawers>
  </drawers>
</template>
<style lang="scss" scoped>
.editors {
  width: 645px;
  margin: auto;
}
</style>
