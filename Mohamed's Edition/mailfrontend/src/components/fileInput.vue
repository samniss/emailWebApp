<template>
  <div id="container1">
    <div class="filesssss">
      <div
        v-for="(file, index) in fileNames"
        :key="file"
        class="file-input__file"
      >
        <span @click="removeFile(index)">x</span>
        {{ file }}
      </div>
    </div>

    <div class="zorar-container">
      <form enctype="multipart/form-data">
        <div class="field">
          <div class="file-is-primary">
            <label class="file-label">
              <input
                class="file-input"
                ref="files"
                type="file"
                name="resume"
                @change="selectFile"
              />
              <span class="file-cta">
                <span class="file-icon">
                  <i class="fas fa-upload"></i>
                </span>
                <span class="file-label"> Add attachments </span>
              </span>
            </label>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
export default {
  name: "fileInput",
  data() {
    return {
      files: [],
      fileNames: ["attach.example"],
    };
  },
  methods: {
    selectFile() {
      if (this.fileNames[0] == "attach.example") {
        this.fileNames.pop();
      }
      this.files.push(this.$refs.files.files[0]);
      this.fileNames.push(this.$refs.files.files[0].name);
      this.$emit("addFiles", this.files, this.fileNames);
    },
    removeFile(index) {
      this.files.splice(index, 1);
      this.fileNames.splice(index, 1);
      this.$emit("addFiles", this.files, this.fileNames);
    },
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