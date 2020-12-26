<template>
  <div class="tag-input">
    <div v-for="receiver in receivers" :key="receiver" class="tag-input__tag">
      
      {{ receiver }}
    </div>
  </div>
</template>
<script>
export default {
  name: "tagInput",
  props: ["receivers"],
  data() {
    return {
    };
  },
  methods: {
    
  },
};
</script>
<style scoped>
.tag-input {
  width: 100%;
  border: 1px solid #eee;
  font-size: 0.9em;
  height: 50px;
  box-sizing: border-box;
  padding: 0 10px;
  border-radius: 5px;
}
.tag-input__tag {
  height: 30px;
  float: left;
  margin-right: 10px;
  background-color: #eee;
  margin-top: 10px;
  line-height: 30px;
  padding: 0 5px;
  border-radius: 5px;
}
.tag-input__tag > span {
  cursor: pointer;
  opacity: 0.75;
}
.tag-input__text {
  border: none;
  outline: none;
  font-size: 0.9em;
  line-height: 50px;
  background: none;
}
</style>