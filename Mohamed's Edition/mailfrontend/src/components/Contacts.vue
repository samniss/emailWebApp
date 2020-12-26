<template>
  <div class="MailBox">
    <div class="page">
      <div class="displayColumn">
        <div>
          <h1 id="theContactsTitle">Contacts 📔</h1>
          <button
            class="ContactOperationButton"
            onclick="window.location.href='/NewContact';"
          >
            New Contact ➕
          </button>
          <button class="ContactOperationButton">Delete Contact ➖</button>
          <div id="pageNumberOptionsDiv">
            <h2>1 2 3 4</h2>
            <input
              type="radio"
              id="pageNumberOneOption"
              name="radioButtonPageNumberOption"
              value="true"
              @click="(pageNumber = 1), Show()"
            />
            <input
              type="radio"
              id="pageNumberTwoOption"
              name="radioButtonPageNumberOption"
              value="false"
              @click="(pageNumber = 2), Show()"
            />
            <input
              type="radio"
              id="pageNumbeThreerOption"
              name="radioButtonPageNumberOption"
              value="false"
              @click="(pageNumber = 3), Show()"
            />
            <input
              type="radio"
              id="pageNumberFourOption"
              name="radioButtonPageNumberOption"
              value="false"
              @click="(pageNumber = 4), Show()"
            />
          </div>
          <br />
        </div>
        <table class="table">
          <tr id="titleRow">
            <td class="checkBoxClass">&nbsp;</td>
            <td style="color: blue">Name</td>
            <td style="color: blue">Addresses</td>
          </tr>
          <tr class="row">
            <td class="rOption">
              <input type="checkbox" value="0" @click="checkMark[0] = 1" />
            </td>
            <td class="rOption">
              {{ name[0] }}
            </td>
            <td class="rOption">{{ addresses[0] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ name[1] }}</td>
            <td class="rOption">{{ addresses[1] }}</td>
          </tr>
          <tr class="row">
            <td><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ name[2] }}</td>
            <td class="rOption">{{ addresses[2] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ name[3] }}</td>
            <td class="rOption">{{ addresses[3] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ name[4] }}</td>
            <td class="rOption">{{ addresses[4] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ name[5] }}</td>
            <td class="rOption">{{ addresses[5] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>

            <td class="rOption">{{ name[6] }}</td>
            <td class="rOption">{{ addresses[6] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ name[7] }}</td>
            <td class="rOption">{{ addresses[7] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ name[8] }}</td>
            <td class="rOption">{{ addresses[8] }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ name[9] }}</td>
            <td class="rOption">{{ addresses[9] }}</td>
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
      name: [].fill(null),
      addresses: [].fill(null),

      checkMark: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      pageNumber: 1,
    };
  },

  methods: {
    Show: function () {
      axios
        .get("http://localhost:8080/loadContacts") //just to test the axios functionality
        .then((response) => {
          console.log(response.data);
          for (var i = 0; i < response.data.length; i++) {
            this.$set(this.name, i, response.data[i].name);
            this.$set(this.addresses, i, response.data[i].emailAddresses);
          }
          console.log(
            "from  : " +
              (this.pageNumber - 1) * 10 +
              "  to : " +
              this.pageNumber * 10
          );
          console.log("pageNumber is " + this.pageNumber);
        });
      console.log("subject");
    },
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

#theContactsTitle {
  text-align: left;
  float: left;
  line-height: 70px;
  width: 50%;
  margin-bottom: 50px;
  font-size: 50px;
  color: rgb(36, 47, 196);
  margin: auto;
  margin-top: -8%;
  padding-left: 10px;
  height: 90px;
  border: solid;
  border-radius: 20px;
  border-color: rgb(255, 41, 41);
  background: linear-gradient(-45deg, rgb(238, 189, 30), rgb(255, 238, 0));
}

.displayColumn {
  float: left;
  margin-left: 1%;
  width: 90%;
  padding: 10px;
  height: 1000px;
}

#sendOption {
  height: 120px;
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

.ContactOperationButton {
  float: left;
  width: 23%;
  height: 70px;
  border-radius: 20px;
  border: solid;
  color: rgb(36, 148, 192);
  background: white;
  font-size: 30px;
  font-weight: bold;
  margin-bottom: 10px;
  margin-right: 1%;
}

.ContactOperationButton :hover {
  background: rgb(238, 121, 121);
}

.pageOption:hover {
  background: rgb(129, 241, 148);
}

.table {
  margin: auto;
  margin-top: 3%;
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
  margin-top: 10%;
  border-radius: 25px;
  margin-left: 40%;
  width: 100px;
  color: rgb(29, 201, 6);
  border: solid;
  margin-left: 50%;
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
</style>