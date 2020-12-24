<template>
  <div id="app">
    <MailBox
      @FilterEmit="chooseFilter"
      @Sort="chooseSort"
      @Search="chooseSearch"
      id="options"
    />
  </div>
</template>


<script>
import MailBox from "./components/MailBox.vue";
import "./filter.js";
import "./router.js";
//const axios = require("axios").default;
export default {
  name: "App",
  data: function () {
    return {
      counter: 0,
      pageOption: "Inbox Mail ✉️",
      contacts: [null],
      sender: ["f", "f", "f", "f", "f", "f", "f", "f", "f", "f"],
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
    chooseFilter: function (sender, subject, priortity, date, type) {
      this.sender = sender;
      this.subject = subject;
      this.priortity = priortity;
      this.date = date;
      this.type = type;
      console.log(this.sender);
      console.log("we are here");
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
