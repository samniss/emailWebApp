<template>
  <div class="MailBox">
    <div class="page">
      <div class="optionsColumn">
        <button id="NewFolderOption">New Folder ➕</button>
        <div pageOptionDiv>
          <button
            id="inboxBtn"
            @click="
              //SetButtonColorInbox(),
              (pageOption = 'Inbox Mail ✉️'),
                ChangePage(),
                (pageNumber = 1),
                (document.getElementById('pageNumberOneOption').value = true),
                (document.getElementById('pageNumberOneOption').checked = true),
                console.log('pageNumber')
            "
            class="pageOption"
          >
            Folder 1
          </button>
          <button
            id="inboxBtn"
            @click="
              //SetButtonColorInbox(),
              (pageOption = 'Inbox Mail ✉️'),
                ChangePage(),
                (pageNumber = 1),
                (document.getElementById('pageNumberOneOption').value = true),
                (document.getElementById('pageNumberOneOption').checked = true),
                console.log('pageNumber')
            "
            class="pageOption"
          >
            Folder 2
          </button>
        </div>
        <div pageOptionDiv>
          <button
            id="trashBtn"
            @click="
              // SetButtonColorTrash(),
              (pageOption = 'Trash Box🗑️'),
                (pageNumber = 1),
                ChangePage(),
                (document.getElementById('pageNumberOneOption').value = true),
                (document.getElementById('pageNumberOneOption').checked = true),
                console.log('pageNumber')
            "
            class="pageOption"
          >
            Folder 3
          </button>
        </div>
        <div pageOptionDiv><button class="pageOption">Folder 4</button></div>
        <div pageOptionDiv>
          <button
            class="pageOption"
            @click="(pageOption = 'Sent 📧'), ChangePage()"
          >
            Folder 5
          </button>
        </div>
        <div pageOptionDiv>
          <button
            class="pageOption"
            onclick="window.location.href='/Contacts';"
          >
            Folder 6
          </button>
        </div>
        <div pageOptionDiv><button class="pageOption">Folder 7</button></div>
        <div pageOptionDiv><button class="pageOption">Folder 8</button></div>
        <div pageOptionDiv><button class="pageOption">Folder 9</button></div>
        <div pageOptionDiv><button class="pageOption">Folder 10</button></div>
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
              <input type="checkbox" value="0" @click="checkMark[0] = 1" />
            </td>
            <td class="rOption">
              {{ sender[0] }}
            </td>
            <td class="rOption">{{ subject[0] }}</td>
            <td class="rOption">{{ priority[0] }}</td>
            <td class="rOption">{{ date[0] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[1] }}</td>
            <td class="rOption">{{ subject[1] }}</td>
            <td class="rOption">{{ priority[1] }}</td>
            <td class="rOption">{{ date[1] }}</td>
          </tr>
          <tr class="row">
            <td><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[2] }}</td>
            <td class="rOption">{{ subject[2] }}</td>
            <td class="rOption">{{ priority[2] }}</td>
            <td class="rOption">{{ date[2] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[3] }}</td>
            <td class="rOption">{{ subject[3] }}</td>
            <td class="rOption">{{ priority[3] }}</td>
            <td class="rOption">{{ date[3] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[4] }}</td>
            <td class="rOption">{{ subject[4] }}</td>
            <td class="rOption">{{ priority[4] }}</td>
            <td class="rOption">{{ date[4] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[5] }}</td>
            <td class="rOption">{{ subject[5] }}</td>
            <td class="rOption">{{ priority[5] }}</td>
            <td class="rOption">{{ date[5] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>

            <td class="rOption">{{ sender[6] }}</td>
            <td class="rOption">{{ subject[6] }}</td>
            <td class="rOption">{{ priority[6] }}</td>
            <td class="rOption">{{ date[6] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[7] }}</td>
            <td class="rOption">{{ subject[7] }}</td>
            <td class="rOption">{{ priority[7] }}</td>
            <td class="rOption">{{ date[7] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[8] }}</td>
            <td class="rOption">{{ subject[8] }}</td>
            <td class="rOption">{{ priority[8] }}</td>
            <td class="rOption">{{ date[8] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
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
      pageOption: "Inbox Mail ✉️", //the folder name
      contacts: [null].fill(null),
      sender: [].fill(null),
      subject: [].fill(null),
      priority: [].fill(null),
      date: [].fill(null),
      type: [].fill(null),
      checkMark: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      filterKey: "null",
      filterText: "ali",
      sortKey: "null",
      searchKey: "null",
      pageNumber: 1,
    };
  },

  methods: {
    //loadong whenevrer the user login immediately
    SetButtonColorInbox: function () {
      var prop = document.getElementById("inboxBtn");
      prop.style.backgroundColor = "#b4b4b4";
      document.getElementById("trashBtn").style.backgroundColor = "#fff";
    },
    SetButtonColorTrash: function () {
      var prop = document.getElementById("trashBtn");
      prop.style.backgroundColor = "#b4b4b4";
      document.getElementById("inoxBtn").style.backgroundColor = "#fff";
    },

    ChangePage: function () {
      //to load the emails
      axios
        .get("http://localhost:8080/loadEmails", {
          params: { page: this.pageNumber, folderName: this.pageOption },
        }) //just to test the axios functionality //"https://jsonplaceholder.typicode.com/posts"
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
    Filter: function (filterKey, filterText) {
      this.filterText = filterText;
      if (filterKey === "subject") {
        axios
          .get("https://jsonplaceholder.typicode.com/posts") //just to test the axios functionality "http://localhost:8080/filter"
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

        /*axios
          .post("http://localhost:8080/filter", "subject")
          .then((response) => {
            console.log(response.data);
          })
          .catch((e) => {
            console.log(e);
          });
          */

        console.log("subject");
      } else if (filterKey === "sender") {
        axios
          .get("https://jsonplaceholder.typicode.com/posts") //just to test the axios functionality
          .then((response) => {
            console.log(response.data);
            var j = 0;
            for (
              var i = (this.pageNumber - 1) * 10;
              i < this.pageNumber * 10;
              i++
            ) {
              this.$set(this.sender, j, response.data[i].userId);
              this.$set(this.subject, j, response.data[i].title);
              this.$set(this.priority, j, response.data[i].userId);
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

        /*
        axios
          .post("http://localhost:8081/filter", "sender")
          .then((response) => {
            console.log(response.data);
          })
          .catch((e) => {
            console.log(e);
          });
          */

        console.log("sender");
      }
    },

    /*
    Sort: function () {
      this.$emit(this.sortKey);
    },

    Search: function () {
      this.$emit(this.searchKey);
    },
    */
  },

  /* computed: {
    showSubject: function () {
      return this.sender[0].userId;
    },
  },
  */
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

#NewFolderOption {
  height: 120px;
  margin-top: 150px;
  border-radius: 20px;
  border: solid;
  color: green;
  background: rgb(236, 139, 139);
  font-size: 40px;
  font-weight: bold;
  margin-bottom: 30px;
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
</style>