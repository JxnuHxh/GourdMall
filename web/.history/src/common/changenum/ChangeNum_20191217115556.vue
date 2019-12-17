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
    add: function () {
      this.mini = false
      console.log(this.nextNum)

      if (this.nextNum >= 10) {
        this.max = true
      } else if (this.nextNum === 9) {
        this.max = true
        this.items.splice(0, 0, ++this.nextNum)
        this.items.splice(1, 1)
      } else {
        this.items.splice(0, 0, ++this.nextNum)
        this.items.splice(1, 1)
      }
      // this.nextNum++
    },
    remove: function () {
      // this.items.splice(0, 1)
      console.log(this.nextNum)
      this.max = false
      if (this.nextNum <= 1) {
        this.mini = true
      } else if (this.nextNum === 2) {
        this.mini = true
        this.items.splice(0, 1, --this.nextNum)
      } else {
        this.items.splice(0, 1, --this.nextNum)
      }
    }
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

.del-btn {
  height: 26px;
  border-radius: 13px;
  width: 26px;
  /* background: red; */
  background: white;
  border: 0px;
  margin-top: -2px;
  /* border: 1px #7d7d7d solid; */
  box-shadow: 0px 0px 10px#7d7d7d;
  /* margin-right: 4px; */
}
.del-btn:focus {
  border: 0px;
  outline:none;

}

.del-btn:hover {
  cursor: pointer;
  background: #e2e2e2
}

.add-btn {
  margin-left: 35px;
  height: 26px;
  border-radius: 13px;
  width: 26px;
  /* background: red; */
  background: white;
  border: 0px;
  margin-top: -2px;
  /* border: 1px #7d7d7d solid; */
  box-shadow: 0px 0px 10px#7d7d7d;
}
.add-btn:focus {
  border: 0px;
  outline:none;
}

.add-btn:hover {
  /* cursor: pointer; */
  cursor: pointer;
  background: #e2e2e2
}

.add-btn-not {
  margin-left: 35px;
  height: 26px;
  border-radius: 13px;
  width: 26px;
  /* background: red; */
  background: #e2e2e2;
  border: 0px;
  margin-top: -2px;
  /* border: 1px #7d7d7d solid; */
  box-shadow: 0px 0px 10px#7d7d7d;
}
.add-btn-not:focus {
  border: 0px;
  outline:none;
}
.add-btn-not:hover {
  /* cursor: pointer; */
  cursor: not-allowed;
  /* background: #e2e2e2 */
}

.del-btn-not {
  background: #e2e2e2;
  height: 26px;
  border-radius: 13px;
  width: 26px;
  /* background: red; */
  border: 0px;
  margin-top: -2px;
  /* border: 1px #7d7d7d solid; */
  box-shadow: 0px 0px 10px#7d7d7d;
  /* margin-right: 4px; */
}
.del-btn-not:focus {
  border: 0px;
  outline:none;
}

.del-btn-not:hover {
  /* cursor: pointer; */
  cursor: not-allowed;
  /* background: #e2e2e2 */
}
</style>
