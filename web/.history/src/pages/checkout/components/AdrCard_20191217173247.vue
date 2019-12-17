<template>
  <el-card shadow="hover" class="adr-card" :body-style="{ padding: '0px' }" :class="checked ? 'checked' : ''">
      <div class="card-header">
        <span>收件人： </span><span> 周鹏武 </span> <span v-if="checked" style="font-size: 15px;">(默认地址)</span>
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
  background: #f2f2f2;
  text-align: center;
  /* line-height: 150px; */
  border: 2px #dbdbdb solid;
  border-radius: 10px;
}

.checked {
  background: red
}

.card-header {
  background: #dbdbdb;
  height: 40px;
  line-height: 40px;
  padding-left: 20px;
  text-align: left
}
</style>
