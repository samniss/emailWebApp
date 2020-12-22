<template>
  <div id="app">
    <mailBox
      @Filter="chooseFilter"
      @Sort="chooseSort"
      @Search="chooseSearch"
      id="options"
    />
  </div>
</template>


<script>
import mailBox from "./components/mailBox.vue";
//const axios = require("axios").default;
export default {
  name: "App",
  data: function () {
    return {
      priority: 0, //the default priorrit is 0 , from 1 to 4 for the normal family groups and 5 is for the pormotions emails
      counter: 0,
      sortKey: null, //to make the designer of this function be able to take the string sorting option from the user
      searchKey: null, //to make the designer of this function be able to take the string searching option from the user
    };
  },
  components: {
    mailBox,
  },
  methods: {
    chooseFilter: function (p) {
      //the periority is p
      this.priority = p;
    },
    chooseSort: function (s) {
      //the periority is p
      this.sortKey = s;
    },
    chooseSearch: function (s) {
      //the periority is p
      this.searchKey = s;
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #359aff;
  margin-top: 0%;
}
</style>
