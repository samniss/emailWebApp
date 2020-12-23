<template>
  <div id="app">
    <MailBox
      @Filter="chooseFilter"
      @Sort="chooseSort"
      @Search="chooseSearch"
      id="options"
    />
  </div>
</template>


<script>
import MailBox from "./components/MailBox.vue";
//const axios = require("axios").default;
export default {
  name: "App",
  data: function () {
    return {
      counter: 0,
      pageOption: "Inbox Mail ✉️",
      contacts: [null],
      sender: ["d", "d", "d", "d", "d", "d", "d", "d", "d", "d"],
      subject: ["d", "d", "d", "d", "d", "d", "d", "d", "d", "d"],
      priortity: ["d", "d", "d", "d"],
      date: ["d", "d", "d", "d", "d", "d", "d", "d", "d", "d"],
      type: ["d", "d", "d", "d", "d", "d", "d", "d", "d", "d"],
      checkMark: ["d", "d", "d", "d", "d", "d", "d", "d", "d", "d"],
      sortKey: "null",
      searchKey: "null",
    };
  },
  components: {
    MailBox,
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
