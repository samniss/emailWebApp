<template>
  <div class="mailBox">
    <div class="page">
      <div class="optionsColumn">
        <button id="sendOption">Send Email ✏️</button>
        <div pageOptionDiv><button class="pageOption">Inbox 📫</button></div>
        <div pageOptionDiv><button class="pageOption">Trash 🗑️</button></div>
        <div pageOptionDiv><button class="pageOption">Drafts 📋</button></div>
        <div pageOptionDiv><button class="pageOption">Contacts 📔</button></div>
        <div pageOptionDiv><button class="pageOption">Folders 📁</button></div>
      </div>
      <div class="displayColumn">
        <div><h1 id="theInboxTitle">Inbox Mail ✉️</h1></div>
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
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender[0] }}</td>
            <td class="rOption">{{ subject }}</td>
            <td class="rOption">{{ priority }}</td>
            <td class="rOption">{{ date }}</td>
            <td class="rOption">{{ type }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender }}</td>
            <td class="rOption">{{ subject }}</td>
            <td class="rOption">{{ priority }}</td>
            <td class="rOption">{{ date }}</td>
            <td class="rOption">{{ type }}</td>
          </tr>
          <tr class="row">
            <td><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender }}</td>
            <td class="rOption">{{ subject }}</td>
            <td class="rOption">{{ priority }}</td>
            <td class="rOption">{{ date }}</td>
            <td class="rOption">{{ type }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender }}</td>
            <td class="rOption">{{ subject }}</td>
            <td class="rOption">{{ priority }}</td>
            <td class="rOption">{{ date }}</td>
            <td class="rOption">{{ type }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender }}</td>
            <td class="rOption">{{ subject }}</td>
            <td class="rOption">{{ priority }}</td>
            <td class="rOption">{{ date }}</td>
            <td class="rOption">{{ type }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender }}</td>
            <td class="rOption">{{ subject }}</td>
            <td class="rOption">{{ priority }}</td>
            <td class="rOption">{{ date }}</td>
            <td class="rOption">{{ type }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>

            <td class="rOption">{{ sender }}</td>
            <td class="rOption">{{ subject }}</td>
            <td class="rOption">{{ priority }}</td>
            <td class="rOption">{{ date }}</td>
            <td class="rOption">{{ type }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender }}</td>
            <td class="rOption">{{ subject }}</td>
            <td class="rOption">{{ priority }}</td>
            <td class="rOption">{{ date }}</td>
            <td class="rOption">{{ type }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender }}</td>
            <td class="rOption">{{ subject }}</td>
            <td class="rOption">{{ priority }}</td>
            <td class="rOption">{{ date }}</td>
            <td class="rOption">{{ type }}</td>
          </tr>
          <tr class="row">
            <td class="rOption"><input type="checkbox" value="0" /></td>
            <td class="rOption">{{ sender }}</td>
            <td class="rOption">{{ subject }}</td>
            <td class="rOption">{{ priority }}</td>
            <td class="rOption">{{ date }}</td>
            <td class="rOption">{{ type }}</td>
          </tr>
        </table>
      </div>
    </div>
    <!-- -->
  </div>
</template>

<script>
export default {
  name: "mailBox",
  data: function () {
    return {
      contacts: [null],
      sender: ["d", "d", "d", "d", "d", "d", "d", "d", "d", "d"],
      subject: ["d", "d", "d", "d", "d", "d", "d", "d", "d", "d"],
      priortity: ["d", "d", "d", "d", "d", "d", "d", "d", "d", "d"],
      date: ["d", "d", "d", "d", "d", "d", "d", "d", "d", "d"],
      type: ["d", "d", "d", "d", "d", "d", "d", "d", "d", "d"],
      checkMark: ["d", "d", "d", "d", "d", "d", "d", "d", "d", "d"],
      sortKey: "null",
      searchKey: "null",
    };
  },
  methods: {
    Filter() {
      this.$emit(this.priortity);
    },
    Sort() {
      this.$emit(this.sortKey);
    },
    Search() {
      this.$emit(this.searchKey);
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
</style>