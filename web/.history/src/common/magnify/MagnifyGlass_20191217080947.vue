<template>
  <div class="magnify">
    <div class="preview-box" @mousemove="move($event)" @mouseenter="enter"  @mouseout="out" ref="previewBox">
      <img width="100%" height="100%" :src="previewImg" alt="">
      <div class="hover-box" v-show="true" ref="hoverBox"></div>
    </div>
    <div class="zoom-box" v-show="zoomVisiable" ref="zoomBox">
      <img :src="zoomImg" alt="" ref="bigImg">
    </div>
  </div>
</template>

<script>
function offset (el) {
  let top = el.offsetTop
  let left = el.offsetLeft
  while (el.offsetParent) {
    el = el.offsetParent
    top += el.offsetTop
    left += el.offsetLeft
  }
  return {
    left: left,
    top: top
  }
}
export default {
  name: 'MagnifyGlass',
  props: {
    previewImg: {
      type: String,
      default: ''
    },
    zoomImg: {
      type: String,
      default: ''
    }
  },
  data () {
    return {
      zoomVisiable: false,
      hoverVisiable: false,
      hoverShow: false
    }
  },
  methods: {
    enter () {
      this.hoverShow = true
    },
    out () {
      this.zoomVisiable = false
      this.hoverShow = false
    },
    move (ev) {
      this.init()
      // 鼠标距离屏幕距离
      let moveX = ev.clientX
      let moveY = ev.clientY
      // 大盒子距离顶部的距离
      let offsetLeft = offset(this.oPreviewBox).left

      let offsetTop = offset(this.oPreviewBox).top
      let left = moveX - offsetLeft - this.houverWidth / 2
      let top
      if (this.scroll > 0) {
        top = moveY - offsetTop + this.scroll - this.houverHeight / 2
      } else {
        top = moveY - offsetTop - this.houverHeight / 2
      }
      let maxWidth = this.pWidth - this.houverWidth
      let maxHeight = this.pWidth - this.houverHeight
      left = left < 0 ? 0 : left > maxWidth ? maxWidth : left
      top = top < 0 ? 0 : top > maxHeight ? maxHeight : top
      let percentX = left / (maxWidth)
      let percentY = top / (maxHeight)
      this.oHoverBox.style.left = left + 'px'
      this.oHoverBox.style.top = top + 'px'
      this.oBigImg.style.left = percentX * (this.bWidth - this.imgWidth) + 'px'
      this.oBigImg.style.top = percentY * (this.bHeight - this.imgHeight) + 'px'
      this.$emit('move', ev)
      this.zoomVisiable = true
    },
    init () {
      this.oHoverBox = this.$refs.hoverBox
      this.oPreviewBox = this.$refs.previewBox
      this.oBigImg = this.$refs.bigImg
      this.imgBox = this.$refs.zoomBox
      this.houverWidth = this.oHoverBox.offsetWidth
      this.houverHeight = this.oHoverBox.offsetHeight
      this.pWidth = this.oPreviewBox.offsetWidth
      this.pHeight = this.oPreviewBox.offsetHeight
      this.imgWidth = this.oBigImg.offsetWidth
      this.imgHeight = this.oBigImg.offsetHeight
      this.bWidth = this.imgBox.offsetWidth
      this.bHeight = this.imgBox.offsetHeight
      this.scroll = document.documentElement.scrollTop || document.body.scrollTop
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.magnify {
    position: relative;
    /* width: 00px; */
}
.magnify .hover-box {
  position: absolute;
  display: block;
  left: 0;
  top: 0;
  width: 100px;
  height: 100px;
  /* border: 1px solid #545454; */
  background: url('https://img-tmdetail.alicdn.com/tps/i4/T12pdtXaldXXXXXXXX-2-2.png') repeat 0 0;
  cursor: move;
  user-select: none;
}
.magnify .preview-box {
  width: 300px;
  height: 300px;
  border: 1px solid #dededd;
  position: relative;
}
.magnify .preview-box :hover {
  display: block;
}
.zoom-box {
  width: 300px;
  height: 300px;
  overflow: hidden;
  position: absolute;
  left: 320px;
  /* border: 1px solid #dc7a7a; */
  top: 0;
  z-index: 30
}
.zoom-box img {
  position: absolute;
  top: 0;
  left: 0;
}
</style>
