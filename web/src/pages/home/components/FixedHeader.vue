<template>
    <el-header :style="headerStyle">
      <transition enter-active-class="animated bounceInDown">
        <div>
          <div style="display: flex; height: 100px;">
            <transition  enter-active-class="animated bounceInDown">
              <div v-show="show2" class="transition-box">.el-zoom-in-center</div>
            </transition>
          </div>
          <el-button @click="show2 = !show2">Click Me</el-button>
        </div>
      </transition>
    </el-header>
</template>

<script>
export default {
  name: 'FixedHeader',
  components: {},
  data () {
    return {
      show2: true,
      headerStyle: {
        boxShadow: '2px 2px 10px #888888',
        height: '700px',
        width: '100%',
        padding: '0px'
      }
    }
  },
  computed: {},
  watch: {},
  methods: {
  },
  created () {
  }

}
</script>
<style scoped>
.transition-box {
    margin-bottom: 10px;
    width: 100%;
    height: 100px;
    border-radius: 4px;
    background-color: #409EFF;
    text-align: center;
    color: #fff;
    padding: 40px 20px;
    box-sizing: border-box;
  }
</style>
