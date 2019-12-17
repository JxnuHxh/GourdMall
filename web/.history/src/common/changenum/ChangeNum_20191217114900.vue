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
</style>
