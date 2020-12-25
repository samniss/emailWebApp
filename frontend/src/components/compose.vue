<template>
    <div id="compose-pane">
        <div id="compose-boxes">
            <!-- <textarea id="from"></textarea> -->
            current time: {{date}}
            <br>
            <br>
            <tag-input v-on:addReceiver="setReceivers"/>
            <input id="subject" v-model="subject" placeholder="Subject:">
            <textarea id="content" v-model="content" placeholder="Type your message here.."></textarea>
            <file-input v-on:addFiles="setFiles" />
            <button class="draftButton" @click="draft()">Save to drafts</button>
            <button @click="send()">Send</button>
        </div>
     </div>
</template>
<script>
import tagInput from './tagInput.vue';
import fileInput from './fileInput.vue';
export default {
  components: { tagInput, fileInput },
    name: 'compose',
    data:   function() {
                return {
                    from : "this.current-user",
                    subject : '',
                    content : '',
                    date : new Date().toLocaleString(),
                    recievers: [],
                    files :[],
                    fileNames : [],
                    actualTime : 0,
                };
            },
    methods:{
        send(){

        },
        draft(){

        },
        time() {
            this.date = new Date().toLocaleString()
        },
        setFiles(sentFiles,sentFileNames){
            this.files = sentFiles
            this.fileNames = sentFileNames
        },
        setReceivers(sentReceivers){
            this.recievers = sentReceivers
        }
    },
    mounted() {
        this.interval = setInterval(this.time, 1000)
     },
    beforeDestroy() {
        clearInterval(this.interval)
    }
}
</script>
<style scoped>
#compose-pane {
    position: -webkit-sticky;
    position: sticky;
    top: 20px;
    z-index: 1;
    border: 1px solid black;
    width: 500px;
}
#compose-boxes {
    flex-direction: column;
    justify-content: space-around;
    background-color: #f8b7b7a8;
    border: 1px solid rgb(0, 0, 0);
    padding: 20px;
    display: inline-flex;
    border-radius: 5px;
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
}
#content {
    border-radius: 3px;
    margin-bottom: 10px;
}
.draftButton{
    margin-bottom: 3px;
}
</style>
