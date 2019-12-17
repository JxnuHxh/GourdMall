<template>
  <el-card shadow="hover" class="adr-card" :body-style="{ padding: '0px' }" :class="checked ? 'checked' : ''">
    <div slot="header">
      <span>收件人： </span> 周鹏武
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
  border-radius: 10px
}

.checked {
  background: red
}

.el-card__header {
  height: 20px;
}
</style>
