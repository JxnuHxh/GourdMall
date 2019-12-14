<template>
  <transition :enter-active-class='fadeIn' :leave-active-class='fadeOut'>
    <slot></slot>
  </transition>
</template>
<script>
export default {
  name: 'FadeAnimation',
  props: ['fadeIn', 'fadeOut'],
  data () {
    return {

    }
  }
}
</script>

<style lang="stylus" scoped>

</style>
