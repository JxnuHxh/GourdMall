<template>
  <transition :enter-active-class='In' :leave-active-class='Out'>
    <slot></slot>
  </transition>
</template>
<script>
export default {
  name: 'FadeAnimation',
  props: ['In', 'Out'],
  data () {
    return {

    }
  }
}
</script>

<style lang="stylus" scoped>

</style>
