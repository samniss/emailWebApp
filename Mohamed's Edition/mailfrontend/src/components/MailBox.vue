<template>
  <div class="MailBox">
    <div class="page">
      <div class="optionsColumn">
        <button id="sendOption">Send Email ✏️</button>
        <div pageOptionDiv>
          <button @click="pageOption = 'Inbox Mail ✉️'" class="pageOption">
            Inbox 📫
          </button>
        </div>
        <div pageOptionDiv>
          <button @click="pageOption = 'Trash Box🗑️'" class="pageOption">
            Trash 🗑️
          </button>
        </div>
        <div pageOptionDiv><button class="pageOption">Drafts 📋</button></div>
        <div pageOptionDiv>
          <button class="pageOption">Sent 📧</button>
        </div>
        <div pageOptionDiv><button class="pageOption">Contacts 📔</button></div>
        <div pageOptionDiv><button class="pageOption">Folders 📁</button></div>
      </div>
      <div class="displayColumn">
        <div>
          <h1 id="theInboxTitle">{{ pageOption }}</h1>
          <ul class="emailsOperationDiv">
            <li class="emailsOperationButton">
              Filter
              <div class="subMenu-2">
                <ul>
                  <button
                    class="menuElement"
                    @click="Filter('subject', 'filterText')"
                  >
                    Subject
                  </button>
                  <input type="text" id="filterSearchText" value="" />

                  <br />
                  <button
                    class="menuElement"
                    @click="Filter('sender', 'filterText')"
                  >
                    Sender
                  </button>
                  <input type="text" id="filterSearchText" value="" />
                </ul>
              </div>
            </li>
            <li class="emailsOperationButton">
              Sort
              <div class="subMenu-1">
                <ul>
                  <button class="menuElement">Priority</button>
                  <button class="menuElement">Date</button>
                  <button class="menuElement">Type</button>
                </ul>
              </div>
            </li>
            <button
              class="emailsOperationButton"
              @click="Seacrh(this.document.text.value)"
            >
              Search<input type="text" id="searchText" value="" />
            </button>
          </ul>
          <div id="pageNumberOptionsDiv">
            <h2>1 2 3 4</h2>
            <input
              type="radio"
              id="pageNumberOneOption"
              name="radioButtonPageNumberOption"
              value="true"
              @click="pageNumber = 1"
            />
            <input
              type="radio"
              id="pageNumberTwoOption"
              name="radioButtonPageNumberOption"
              value="false"
              @click="pageNumber = 2"
            />
            <input
              type="radio"
              id="pageNumbeThreerOption"
              name="radioButtonPageNumberOption"
              value="false"
              @click="pageNumber = 3"
            />
            <input
              type="radio"
              id="pageNumberFourOption"
              name="radioButtonPageNumberOption"
              value="false"
              @click="pageNumber = 4"
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
            <td>Type</td>
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
            <td class="rOption">{{ type[0] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[1] }}</td>
            <td class="rOption">{{ subject[1] }}</td>
            <td class="rOption">{{ priority[1] }}</td>
            <td class="rOption">{{ date[1] }}</td>
            <td class="rOption">{{ type[1] }}</td>
          </tr>
          <tr class="row">
            <td><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[2] }}</td>
            <td class="rOption">{{ subject[2] }}</td>
            <td class="rOption">{{ priority[2] }}</td>
            <td class="rOption">{{ date[2] }}</td>
            <td class="rOption">{{ type[2] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[3] }}</td>
            <td class="rOption">{{ subject[3] }}</td>
            <td class="rOption">{{ priority[3] }}</td>
            <td class="rOption">{{ date[3] }}</td>
            <td class="rOption">{{ type[3] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[4] }}</td>
            <td class="rOption">{{ subject[4] }}</td>
            <td class="rOption">{{ priority[4] }}</td>
            <td class="rOption">{{ date[4] }}</td>
            <td class="rOption">{{ type[4] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[5] }}</td>
            <td class="rOption">{{ subject[5] }}</td>
            <td class="rOption">{{ priority[5] }}</td>
            <td class="rOption">{{ date[5] }}</td>
            <td class="rOption">{{ type[5] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>

            <td class="rOption">{{ sender[6] }}</td>
            <td class="rOption">{{ subject[6] }}</td>
            <td class="rOption">{{ priority[6] }}</td>
            <td class="rOption">{{ date[6] }}</td>
            <td class="rOption">{{ type[6] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[7] }}</td>
            <td class="rOption">{{ subject[7] }}</td>
            <td class="rOption">{{ priority[7] }}</td>
            <td class="rOption">{{ date[7] }}</td>
            <td class="rOption">{{ type[7] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[8] }}</td>
            <td class="rOption">{{ subject[8] }}</td>
            <td class="rOption">{{ priority[8] }}</td>
            <td class="rOption">{{ date[8] }}</td>
            <td class="rOption">{{ type[8] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[9] }}</td>
            <td class="rOption">{{ subject[9] }}</td>
            <td class="rOption">{{ priority[9] }}</td>
            <td class="rOption">{{ date[9] }}</td>
            <td class="rOption">{{ type[9] }}</td>
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
      pageOption: "Inbox Mail ✉️",
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
    Filter: function (filterKey, filterText) {
      this.filterText = filterText;
      if (filterKey === "subject") {
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
          .post("http://localhost:8081/filter", "subject")
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

#sendOption {
  margin-top: 150px;
  border-radius: 20px;
  border: solid;
  color: green;
  background: white;
  font-size: 40px;
  font-weight: bold;
  margin-bottom: 30px;
  margin-top: 20px;
}

#sendOption:hover {
  background: rgb(108, 225, 240);
}

.pageOption {
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
  color: rgb(243, 45, 184);
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
  margin-top: 95px;
  border-radius: 25px;
  margin-left: 40%;
  width: 100px;
  color: rgb(29, 201, 6);
  border: solid;
}

.emailsOperationDiv {
  display: inline-flex;
  float: left;
  margin-top: 20px;
  width: 100%px;
  color: rgb(226, 40, 211);
  border: solid;
  border-radius: 40px;
  background: blueviolet;
  height: 10%px;
}
.emailsOperationButton {
  margin-right: 150px;
  line-height: 30px;
  float: left;
  width: 120px;
  color: rgb(255, 255, 255);
  border: solid;
  border-color: brown;
  border-radius: 20px;
  background: rgb(235, 74, 74);
  height: 30px;
}

.emailsOperationButton:hover {
  background: rgb(50, 230, 74);
}

.subMenu-1 {
  display: none;
  border-bottom: solid;
  border-color: brown;
  border-radius: 20px;
  background: rgb(235, 74, 74);
}

.menuElement {
  float: left;
  padding-left: 5px;
  margin-left: 10px;
  margin-right: 20px;
  background: cyan;
  color: black;
  border: solid;
  border-radius: 20px;
  height: 30px;
}

.menuElement:hover {
  background: rgb(9, 194, 194);
}

.emailsOperationButton:hover .subMenu-1 {
  text-align: left;
  margin-top: 0px;
  display: block;
  position: absolute;
  border-radius: 20px;
  border: solid;
  border-color: brown;
  background: rgb(241, 103, 103);
  height: 30px;
}

#searchText {
  margin-top: 10%;
  height: 30px;
  font-size: 20px;
  background: whitesmoke;
}

#filterSearchText {
  background: whitesmoke;
  border-radius: 10px;
}

.subMenu-2 {
  display: none;
  float: left;
  border: solid;
  border-radius: 20px;
  border-color: brown;
  background: rgb(241, 103, 103);
  width: 220px;
}

.emailsOperationButton:hover .subMenu-2 {
  text-align: left;
  margin-top: 0px;
  display: block;
  position: absolute;
  float: left;
  border: solid;
  border-radius: 20px;
  border-color: brown;
  background: rgb(241, 103, 103);
  width: 220px;
}
</style>