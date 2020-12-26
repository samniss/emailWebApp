<template>
  <div id="compose-pane">
    <div id="compose-boxes">
      <!-- <textarea id="from"></textarea> -->
      <div id="timeDiv">current time: {{ date }}</div>
      <br />
      <br />
      <select v-model="selected" disabled>
        <option disabled value="">Please select one</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
      </select>
      <receivers-views id="enterEmail"  v-bind:receivers="receivers"/>
      <input id="subject" v-model="subject" readonly/>
      <textarea
        id="content"
        v-model="content"
        placeholder="Type your message here.."
        readonly
      ></textarea>
      <files-view v-bind:date="date" v-bind:from="from" v-bind:fileNames="fileNames"/>
    </div>
  </div>
</template>
<script>
import filesView from './filesView.vue'
const axios = require("axios").default;
import ReceiversViews from './receiversViews.vue';

export default {
  components: { filesView, ReceiversViews },
  name: "compose",
  data: function () {
    return {
      from: "this.current-user",
      subject: "",
      content: "",
      date: '',
      receivers: [],
      files: [],
      fileNames: [],
      actualTime: 0,
      selected: 0,
    };
  },
  methods: {
    getUnits: function() {
      axios
          .get("http://localhost:8080/getCurrentEmailName",{param:{}})
          .then((response) => {
            console.log(response.data);
            if(response.data){
              this.subject=response.data.subject;
              this.content=response.data.content;
              this.date=response.data.date;
              this.receivers=response.data.reciever;
              this.selected=response.data.priority;
              this.fileNames=response.data.attachments;
            }
          })
          .catch((e) => {
            console.log(e);
          });
    }
  },
  beforeMount : function (){
    console.log("momen");
    this.getUnits()
 },
};
</script>
<style scoped>
#compose-pane {
  border: solid;
  margin-left: 35%;
  border-radius: 20px;
  position: -webkit-sticky;
  position: sticky;
  margin-top: 5%;
  border: 1px solid black;
  width: 30%;
  height: 50%;
  margin-bottom: 10%;
  background: rgb(56, 140, 236);
}
#compose-boxes {
  flex-direction: column;
  justify-content: space-around;
  background-color: #f8b7b7a8;
  padding: 20px;
  display: inline-flex;
  border-radius: 5px;
  background: rgb(56, 140, 236);
}
#from {
  margin-bottom: 10px;
}
#to {
  margin-bottom: 10px;
}
#subject {
  border-radius: 5px;
  margin-top: 10px;
  margin-bottom: 10px;
  background: cyan;
  height: 30px;
  border: solid;
  border-radius: 10px;
}
#content {
  border-radius: 15px;
  border: solid;
  margin-bottom: 10px;
  background: rgb(255, 255, 255);
  min-width: 400px;
  max-width: 400px;
  min-height: 100px;
  max-height: 100px;
  line-height: 20px;
}

#enterEmail {
  color: black;
  background: rgb(205, 255, 123);
  width: 200px;
  border: solid;
  border-radius: 25px;
  margin: auto;
  font-size: 100%;
}

.buttonElement {
  border-radius: 20px;
  border: solid;
  background: rgb(30, 255, 0);
}

#timeDiv {
  height: 25px;
  line-height: 25px;
  border: solid;
  border-radius: 30px;
  border-color: aliceblue;
  background: #e943e9a8;
}
</style>