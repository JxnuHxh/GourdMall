<template>
  <div class="adr-card">

  </div>
  <el-card :body-style="{ padding: '0px' }">
    <div slot="header">
      <span><!-- card title --></span>
    </div>
    <!-- card body -->
  </el-card>

</template>

<script>
export default {
  name: 'AdrCard',
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
.adr-card {
  width: 100%;
  height: 150px;
  background: #f2f2f2;
  text-align: center;
  line-height: 150px;
  border: 2px #dbdbdb solid;
  border-radius: 10px
}
</style>
