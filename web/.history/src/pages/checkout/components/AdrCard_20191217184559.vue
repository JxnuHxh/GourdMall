<template>
  <el-card   :shadow="checked ?  'never' : 'hover'" class="adr-card" :body-style="{ padding: '0px' }" :class="checked ? 'checked' : ''">
      <div @click="check()">
        <div class="card-header"  >
          <span>收件人： </span><span> {{this.adr.name}} </span> <span v-if="checked" style="font-size: 12px; color: #ff0000">(默认地址)</span>
        </div>
        <div class="card-container">
          <span>收货地址： </span><span> {{this.adr.address}} </span>
        </div>
        <div class="card-header">
          <span>收件人电话： </span><span> {{this.adr.phone}}</span>
        </div>
      </div>
    <!-- card body -->
  </el-card>

</template>

<script>
export default {
  name: 'AdrCard',
  components: {},
  props: ['checked', 'adr', 'index'],
  data () {
    return {
    }
  },
  computed: {},
  watch: {},
  methods: {
    check () {
      console.log('选择该地址')
      let name = this.adr.name
      console.log(name)
    }
  },
  created () {
  },
  mounted () {
  }
}
</script>
<style scoped>

.adr-card {
  width: 100%;
  height: 150px;
  background: #ffffff;
  text-align: center;
  /* line-height: 150px; */
  border: 2px #dbdbdb solid;
  border-radius: 10px;
}

.checked {
    background: #f2f2f2;
    border: 2px #333333 dashed
}

.card-header {
  background: #dbdbdb;
  height: 40px;
  line-height: 40px;
  padding-left: 20px;
  text-align: left;
  padding-right: 10px
}

.card-container {
  text-align: left;
  padding-left: 20px;
  padding-right: 10px;
  word-wrap: break-word;
  height: 70px;
}
</style>
