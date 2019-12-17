<template>
  <el-card :shadow="checked ?  'never' : 'hover'" class="adr-card" :body-style="{ padding: '0px' }" :class="checked ? 'checked' : ''">
      <div class="card-header">
        <span>收件人： </span><span> 周鹏武 </span> <span v-if="checked" style="font-size: 12px; color: #ff0000">(默认地址)</span>
      </div>
      <div class="card-container">
        <span>收货地址： </span><span> 江西省南昌市紫阳大道99号江西师范大学（瑶湖校区） </span>
      </div>

    <!-- card body -->
  </el-card>

</template>

<script>
export default {
  name: 'AdrCard',
  components: {},
  props: ['checked'],
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
  text-align: left
}

.card-container {
  text-align: left;
  padding-left: 20px;
}
</style>
