<script setup>
import userVolume from '@/views/console/dashboard/column/userVolume.vue'
import visitedVolume from '@/views/console/dashboard/column/visitedVolume.vue'
import postsVolume from '@/views/console/dashboard/column/postsVolume.vue'
import auditVolume from '@/views/console/dashboard/column/auditVolume.vue'
import activityVolume from '@/views/console/dashboard/column/activityVolume.vue'
import webState from '@/views/console/dashboard/column/webState.vue'
</script>

<template>
    <div id='main'>
        <div class="line1">
            <userVolume></userVolume>
            <visitedVolume></visitedVolume>
            <postsVolume></postsVolume>
            <auditVolume></auditVolume>
            <activityVolume></activityVolume>
        </div>
        <div class="line1">
            <webState></webState>
        </div>
        
    </div>
</template>
<style>
#main {
    display: flex;
    flex-direction:column;
    height: 2000px;
    width: 100%;
}
.line1 {
    display:flex;
    height: 14%;
    background-color: aquamarine;
    flex-direction: row;
    justify-content: space-evenly;
    flex-wrap: wrap;
    align-content: space-around;
}
</style>