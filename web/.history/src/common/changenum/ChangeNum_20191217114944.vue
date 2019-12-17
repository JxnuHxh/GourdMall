<template>
  <div id="list-demo" class="num-change">
    <span style="margin-right: 15px; margin-left: -10px">数量</span>
    <button v-on:click="remove" :class="this.mini ? 'del-btn-not' : 'del-btn'"  >-</button>
    <transition-group name="list" tag="span">
      <span v-for="item in items"  v-bind:key="item" class="list-item">
        {{ item }}
      </span>
    </transition-group>
    <button v-on:click="add"  :class="this.max ? 'add-btn-not' : 'add-btn'" >+</button>
  </div>
</template>

<script>
export default {
  name: 'ChangeNum',
  components: {},
  data () {
    return {
      items: [0],
      nextNum: 1,
      max: false,
      mini: true
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
.list-item {
  display: inline-block;
  margin-right: 10px;
  /* background: red; */
  position: absolute;
  line-height: 26px;
  width: 30px;
  text-align: center;
  font-size: 16px
}
.list-enter-active, .list-leave-active {
  transition: all 1s;
}
.list-leave-to
/* .list-leave-active for below version 2.1.8 */ {
  opacity: 0;
  transform: translateY(10px);
}
.list-enter {
  opacity: 0;
  transform: translateY(-10px);
}

.add-shop-cart {
  background: #5c84e3;
}

.add-shop-cart:hover {
  background: #6080ce
}

.buy-now {
  background: #f2f2f2
}

.buy-now:hover {
  background: #ededed
}

.el-input-number {
  margin-left: 20px;
  width: 100px;
}

.num-change {
  /* background: gray; */
  width: 200px;
  height: 20px;
  padding: 10px
}
</style>
