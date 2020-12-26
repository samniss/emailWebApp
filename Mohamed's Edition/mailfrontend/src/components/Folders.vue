<template>
  <div class="MailBox">
    <div class="page">
      <div class="optionsColumn">
        <button id="RenameFolderOption" @click="MakeFolder()">
          Make Folder
        </button>
        <input id="FolderText" type="text" placeholder="Folder Name" />
        <div pageOptionDiv>
          <button
            id="inboxBtn"
            @click="ChangePage(), (pageNumber = 1), (folderName = 'folder1')"
            class="pageOption"
          >
            {{ this.FolderNamesArray[0] }}
          </button>
          <button
            id="inboxBtn"
            @click="
              //SetButtonColorInbox(),
              ChangePage(), (pageNumber = 1), (folderName = 'folder2')
            "
            class="pageOption"
          >
            {{ this.FolderNamesArray[1] }}
          </button>
        </div>
        <div pageOptionDiv>
          <button
            @click="
              // SetButtonColorTrash(),
              (pageNumber = 1), ChangePage(), (folderName = 'folder3')
            "
            class="pageOption"
          >
            {{ this.FolderNamesArray[2] }}
          </button>
        </div>
        <div pageOptionDiv>
          <button
            class="pageOption"
            @click="(pageNumber = 1), ChangePage(), (folderName = 'folder4')"
          >
            {{ this.FolderNamesArray[3] }}
          </button>
        </div>
        <div pageOptionDiv>
          <button
            class="pageOption"
            @click="(pageNumber = 1), ChangePage(), (folderName = 'folder5')"
          >
            {{ this.FolderNamesArray[4] }}
          </button>
        </div>
        <div pageOptionDiv>
          <button
            class="pageOption"
            @click="(pageNumber = 1), ChangePage(), (folderName = 'folder6')"
          >
            {{ this.FolderNamesArray[5] }}
          </button>
        </div>
        <div pageOptionDiv>
          <button
            class="pageOption"
            @click="(pageNumber = 1), ChangePage(), (folderName = 'folder7')"
          >
            {{ this.FolderNamesArray[6] }}
          </button>
        </div>
        <div pageOptionDiv>
          <button
            class="pageOption"
            @click="(pageNumber = 1), ChangePage(), (folderName = 'folder8')"
          >
            {{ this.FolderNamesArray[7] }}
          </button>
        </div>
        <div pageOptionDiv>
          <button
            class="pageOption"
            @click="(pageNumber = 1), ChangePage(), (folderName = 'folder9')"
          >
            {{ this.FolderNamesArray[8] }}</button
          >ta
        </div>
        <div pageOptionDiv>
          <button
            class="pageOption"
            @click="(pageNumber = 1), ChangePage(), (folderName = 'folder10')"
          >
            {{ this.FolderNamesArray[9] }}
          </button>
        </div>
      </div>
      <div class="displayColumn">
        <div>
          <h1 id="theInboxTitle">Folders 📁</h1>

          <div id="pageNumberOptionsDiv">
            <h2>1 2 3 4</h2>
            <input
              type="radio"
              id="pageNumberOneOption"
              name="radioButtonPageNumberOption"
              value="false"
              checked="false"
              @click="(pageNumber = 1), ChangePage()"
            />
            <input
              type="radio"
              id="pageNumberTwoOption"
              name="radioButtonPageNumberOption"
              value="false"
              @click="(pageNumber = 2), ChangePage()"
            />
            <input
              type="radio"
              id="pageNumbeThreerOption"
              name="radioButtonPageNumberOption"
              value="false"
              @click="(pageNumber = 3), ChangePage()"
            />
            <input
              type="radio"
              id="pageNumberFourOption"
              name="radioButtonPageNumberOption"
              value="false"
              @click="(pageNumber = 4), ChangePage()"
            />
          </div>
          <br />
        </div>
        <table class="table">
          <tr id="titleRow">
            <td class="checkBoxClass">&nbsp;</td>
            <td>Sender</td>
            <td>Subject</td>
            <td>Priority</td>
            <td>Date</td>
          </tr>
          <tr class="row">
            <td class="rOption">
              <input type="radio" name="FolderOption" value="false" />
            </td>
            <td class="rOption">
              {{ sender[0] }}
            </td>
            <td class="rOption">{{ subject[0] }}</td>
            <td class="rOption">{{ priority[0] }}</td>
            <td class="rOption">{{ date[0] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption">
              <input type="radio" name="FolderOption" value="false" />
            </td>
            <td class="rOption">{{ sender[1] }}</td>
            <td class="rOption">{{ subject[1] }}</td>
            <td class="rOption">{{ priority[1] }}</td>
            <td class="rOption">{{ date[1] }}</td>
          </tr>
          <tr class="row">
            <td><input type="radio" name="FolderOption" value="false" /></td>
            <td class="rOption">{{ sender[2] }}</td>
            <td class="rOption">{{ subject[2] }}</td>
            <td class="rOption">{{ priority[2] }}</td>
            <td class="rOption">{{ date[2] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption">
              <input type="radio" name="FolderOption" value="false" />
            </td>
            <td class="rOption">{{ sender[3] }}</td>
            <td class="rOption">{{ subject[3] }}</td>
            <td class="rOption">{{ priority[3] }}</td>
            <td class="rOption">{{ date[3] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption">
              <input type="radio" name="FolderOption" value="false" />
            </td>
            <td class="rOption">{{ sender[4] }}</td>
            <td class="rOption">{{ subject[4] }}</td>
            <td class="rOption">{{ priority[4] }}</td>
            <td class="rOption">{{ date[4] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption">
              <input type="radio" name="FolderOption" value="false" />
            </td>
            <td class="rOption">{{ sender[5] }}</td>
            <td class="rOption">{{ subject[5] }}</td>
            <td class="rOption">{{ priority[5] }}</td>
            <td class="rOption">{{ date[5] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption">
              <input type="radio" name="FolderOption" value="false" />
            </td>

            <td class="rOption">{{ sender[6] }}</td>
            <td class="rOption">{{ subject[6] }}</td>
            <td class="rOption">{{ priority[6] }}</td>
            <td class="rOption">{{ date[6] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption">
              <input type="radio" name="FolderOption" value="false" />
            </td>
            <td class="rOption">{{ sender[7] }}</td>
            <td class="rOption">{{ subject[7] }}</td>
            <td class="rOption">{{ priority[7] }}</td>
            <td class="rOption">{{ date[7] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption">
              <input type="radio" name="FolderOption" value="false" />
            </td>
            <td class="rOption">{{ sender[8] }}</td>
            <td class="rOption">{{ subject[8] }}</td>
            <td class="rOption">{{ priority[8] }}</td>
            <td class="rOption">{{ date[8] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption">
              <input type="radio" name="FolderOption" value="false" />
            </td>
            <td class="rOption">{{ sender[9] }}</td>
            <td class="rOption">{{ subject[9] }}</td>
            <td class="rOption">{{ priority[9] }}</td>
            <td class="rOption">{{ date[9] }}</td>
          </tr>
        </table>
      </div>
    </div>
    <!-- -->
  </div>
</template>

<script>
import "../filter.js";
const axios = require("axios").default;
export default {
  name: "MailBox",
  data: function () {
    return {
      sender: [].fill(null),
      subject: [].fill(null),
      priority: [].fill(null),
      date: [].fill(null),
      checkMark: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      folderName: "Empty",
      FolderNamesArray: [
        "Empty",
        "Empty",
        "Empty",
        "Empty",
        "Empty",
        "Empty",
        "Empty",
        "Empty",
        "Empty",
        "Empty",
      ],
      FolderPointer: 0,
    };
  },
  methods: {
    //loadong whenevrer the user login immediately
    MakeFolder: function () {
      if (this.FolderPointer < 11) {
        //build folders
        if (document.getElementById("FolderText").value.length > 0) {
          this.$set(
            this.FolderNamesArray,
            this.FolderPointer,
            document.getElementById("FolderText").value
          );
          this.FolderPointer++;
          console.log(this.FolderNamesArray[this.FolderPointer]);
          axios
            .get("http://localhost:8080/addFolders", {
              params: { folderName: "Empty" },
            })
            .then((response) => {
              console.log(response.data);
              if (response.data === true) {
                var v = new FormData();
                v.append("oldName", "Empty");
                v.append(
                  "newName",
                  document.getElementById("FolderText").value
                );
                axios
                  .put("http://localhost:8080/updateFolderName", v)
                  .then((response) => {
                    console.log(response.data);
                  });
              }
            });
        }
      } else {
        //Rename Folder
        if (document.getElementById("FolderText").value.length > 0) {
          var v = new FormData();
          v.append("oldName", this.FolderNamesArray[this.FolderPointer]);
          v.append("newName", document.getElementById("FolderText").value);
          axios
            .put("http://localhost:8080/updateFolderName", v)
            .then((response) => {
              console.log(response.data);
            });
          this.$set(
            this.FolderNamesArray,
            this.FolderPointer % 10,
            document.getElementById("FolderText").value
          );
          this.FolderPointer++;
          console.log(this.FolderNamesArray[this.FolderPointer]);
        }
      }
    },
    ChangePage: function () {
      //to load the emails
      axios
        .get("http://localhost:8080/Folders", {
          params: { page: this.pageNumber, folderName: this.folderName },
        })
        .then((response) => {
          console.log(response.data);
          var j = 0;
          for (
            var i = (this.pageNumber - 1) * 10;
            i < this.pageNumber * 10;
            i++
          ) {
            console.log(i);
            this.$set(this.sender, j, response.data[i].userId);
            this.$set(this.subject, j, response.data[i].title);
            this.$set(this.priority, j, response.data[i].title);
            this.$set(this.date, j, response.data[i].userId);
            this.$set(this.type, j, response.data[i].userId);
            j++;
          }
          console.log(
            "from  : " +
              (this.pageNumber - 1) * 10 +
              "  to : " +
              this.pageNumber * 10
          );
          console.log("pageNumber is " + this.pageNumber);
        });
    },
  },
};
</script>
<style  scoped>
.ButtonsGroup {
  background-image: linear-gradient(-45deg, rgb(59, 203, 228), magenta);
  border-radius: 20px;
  margin-top: 1px;
  width: 100%;
  height: 5%;
}
.b {
  margin: auto;
  margin-top: 5px;
  margin-bottom: 5px;
  font-size: 20px;
  font-style: oblique;
  width: 10%;
  height: 80%;
  background-color: linear-gradient(
    -100deg,
    rgb(153, 35, 168),
    rgb(213, 233, 31)
  );
  background: linear-gradient(-100deg, rgb(72, 212, 16), rgb(215, 236, 21));
  border-radius: 20px;
}
#theInboxTitle {
  text-align: left;
  line-height: 70px;
  font-size: 50px;
  color: rgb(36, 47, 196);
  margin: auto;
  margin-top: 0px;
  padding-left: 10px;
  height: 90px;
  border: solid;
  border-radius: 20px;
  background: linear-gradient(-45deg, rgb(238, 189, 30), rgb(255, 238, 0));
}
.optionsColumn {
  float: left;
  width: 12%;
  padding: 10px;
  height: 100%px;
  border: solid;
  border-radius: 15px;
  border-color: red;
  margin-top: 10px;
}
.displayColumn {
  float: left;
  margin-left: 2%;
  width: 70%;
  padding: 10px;
  height: 1000px;
}
#RenameFolderOption {
  height: 120px;
  margin-top: 150px;
  border-radius: 20px;
  border: solid;
  color: green;
  background: rgb(236, 139, 139);
  font-size: 40px;
  font-weight: bold;
  margin-top: 20px;
}
#NewFolderOption:hover {
  background: rgb(98, 236, 64);
}
.pageOption {
  width: 150px;
  height: 70px;
  border-radius: 20px;
  border: solid;
  color: green;
  background: white;
  font-size: 30px;
  font-weight: bold;
  margin: auto;
  margin-bottom: 30px;
}
.pageOption:hover {
  background: rgb(129, 241, 148);
}
.pageOptionDiv {
  background-image: black;
  color: aqua;
}
.table {
  margin: auto;
  width: 100%;
  height: 100%;
  border-radius: 20px;
  border: solid;
  border-color: white;
}
#titleRow {
  border-radius: 20px;
  width: 100%;
  height: 10%;
  font-size: 35px;
  font-weight: bolder;
  color: rgb(252, 59, 59);
  margin: auto;
  margin-bottom: 10px;
  border-bottom: solid;
  border-color: cyan;
}
.row {
  border: solid;
  border-radius: 20px;
  border-bottom: black;
  color: black;
  margin: auto;
  margin-bottom: 5px;
  font-size: 20px;
}
.row:hover {
  background: rgb(108, 240, 174);
}
.rOption {
  /* used to make the underline between emails */
  border-top: solid;
  border-bottom: rgb(0, 0, 0);
}
#pageNumberOptionsDiv {
  line-height: 5px;
  padding-bottom: 4px;
  margin-top: 40px;
  border-radius: 25px;
  margin-left: 40%;
  width: 100px;
  color: rgb(29, 201, 6);
  border: solid;
}
#FolderText {
  background: rgb(134, 191, 241);
  border: solid;
  border-radius: 15px;
  margin-top: 5px;
  margin-bottom: 20px;
}
</style>