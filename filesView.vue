<template>
  <div id="container1">
    <div class="filesssss">
      <div
        v-for="file in fileNames"
        :key="file"
        class="file-input__file"
      >
        
        <a href="javascript:downloadThisFile(file)" > {{ file }} </a>
      </div>
    </div>
  </div>
</template>
<script>
const axios = require("axios").default;
export default {
  name: "fileInput",
  props: ['from','date','fileNames'],
  data() {
    return {
      files: [],
    };
  },
  methods: {
    downloadThisFile(file){
        var dateName = this.date + this.from;
        axios.get("http://localhost:8080//downloadAttachment",{
            params:{
            fileName:file,
            emailName:dateName,
            },
            responseType:'blob'
        }).then(function (response){
            console.log(response.data);
        const blob=new Blob([response.data],{type:response.data.type})
        const url = window.URL.createObjectURL(blob);
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download',file);
        link.click();
        link.remove();
        window.URL.revokeObjectURL(url);
        }).catch(function(err){
            console.log(err)
        })

    }
  },
};
</script>
<style scoped>
.filesssss {
  width: 100%;
  font-size: 0.9em;
  height: 50px;
  box-sizing: border-box;
  padding: 0 10px;
  background: rgb(120, 236, 159);
}
.file-input__file {
  height: 30px;
  float: left;
  margin-right: 10px;
  background-color: #eee;
  margin-top: 10px;
  line-height: 30px;
  padding: 0 5px;
  border-radius: 5px;
}
.file-input__file > span {
  cursor: pointer;
  opacity: 0.75;
}
.file-input__files {
  border: none;
  outline: none;
  font-size: 0.9em;
  line-height: 50px;
  background: none;
}
.zorar-container {
  margin-top: 10px;
  margin-bottom: 10px;
  background: rgb(120, 236, 159);
}
.file-label {
  border-radius: 10px;
  border: solid;
  height: ;
  color: rgb(255, 255, 255);
}
#container1 {
  border-radius: 20px;
  background: rgb(120, 236, 159);
}
.field {
  background: rgb(120, 236, 159);
}
.file-is-primary {
  background: rgb(120, 236, 159);
}
.file-input {
  margin-left: -2px;
  background: rgb(120, 236, 159);
}
</style>