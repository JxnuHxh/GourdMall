<template>
  <div class="block">
    <el-carousel height="450px">
      <el-carousel-item v-for="item in 4" :key="item">
          <div>
            <img src="https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg" height="450px" width="100%" alt="">
          </div>
      </el-carousel-item>
    </el-carousel>

  </div>
</template>

<script>
export default {
  name: 'Carousel',
  components: {},
  data () {
    return {
    }
  },
  computed: {},
  watch: {},
  methods: {
  },
  created () {
  },
  mounted () {
  }
}
</script>
<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 450px;
  margin: 0 auto;
  text-align: center
}
.el-carousel {
  border-radius: 5px;
}
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}
.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>
