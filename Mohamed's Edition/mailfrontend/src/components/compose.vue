<template>
  <div id="compose-pane">
    <div id="compose-boxes">
      <!-- <textarea id="from"></textarea> -->
      <div id="timeDiv">current time: {{ date }}</div>
      <br />
      <br />
      <select v-model="selected">
        <option disabled value="">Please select one</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
      </select>
      <tag-input id="enterEmail" v-on:addReceiver="setReceivers" />
      <input id="subject" v-model="subject" placeholder="Subject:" />
      <textarea
        id="content"
        v-model="content"
        placeholder="Type your message here.."
      ></textarea>
      <file-input v-on:addFiles="setFiles" />
      <button class="buttonElement" @click="draft()">Save to drafts</button>
      <button class="buttonElement" @click="send()">Send</button>
    </div>
  </div>
</template>
<script>
import tagInput from "./tagInput.vue";
import fileInput from "./fileInput.vue";
const axios = require("axios").default;
export default {
  components: { tagInput, fileInput },
  name: "compose",
  data: function () {
    return {
      from: "this.current-user",
      subject: "",
      content: "",
      date: new Date().toLocaleString(),
      recievers: [],
      files: [],
      fileNames: [],
      actualTime: 0,
      selected: 0,
    };
  },
  methods: {
    send() {
      var email = {
        sender: this.from,
        subject: this.subject,
        receiver: null,
        date: new Date().getTime().toString(),
        content: this.content,
        draft: false,
        priority: this.selected,
        check: false,
        attachmentents: this.fileNames,
      };
      var emailAsJSON = JSON.stringify(email);
      var formData = new FormData();
      formData.append("mail", emailAsJSON);
      formData.append("attachments", this.files);
      formData.append("receivers", this.recievers);
      axios
        .post("http://localhost:8080/saveEmail", formData)
        .then((response) => {
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    draft() {
      var email = {
        sender: this.from,
        subject: this.subject,
        receiver: null,
        date: new Date().getTime().toString(),
        content: this.content,
        draft: true,
        priority: this.selected,
        check: false,
        attachmentents: this.fileNames,
      };
      var emailAsJSON = JSON.stringify(email);
      var formData = new FormData();
      formData.append("mail", emailAsJSON);
      formData.append("attachments", this.files);
      formData.append("receivers", this.recievers);
      axios
        .post("http://localhost:8080/saveEmail", formData)
        .then((response) => {
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    time() {
      this.date = new Date().toLocaleString();
    },
    setFiles(sentFiles, sentFileNames) {
      this.files = sentFiles;
      this.fileNames = sentFileNames;
    },
    setReceivers(sentReceivers) {
      this.recievers = sentReceivers;
    },
  },
  mounted() {
    this.interval = setInterval(this.time, 1000);
  },
  beforeDestroy() {
    clearInterval(this.interval);
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
