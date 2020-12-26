<template>
  <div class="main-container">
    <form>
      <div class="box-container">
        <h2 class="heading">New contact</h2>
        <div class="form-fields">
          <input
            id="contactName"
            name="contactName"
            type="text"
            placeholder="the new contact name"
          />
        </div>
        <div class="wrongInput" id="noContact" style="display: none">
          <span class="somethingWrongSentence"
            >❗️ You should enter a contact Name</span
          >
        </div>
        <div class="form-fields">
          <input
            id="email"
            name="email"
            type="text"
            placeholder="EmailAddress@MAJ.com"
          />
        </div>
        <div class="wrongInput" id="noEmailAddress" style="display: none">
          <span class="somethingWrongSentence"
            >❗️ You should enter an Email Address</span
          >
        </div>
        <div class="wrongInput" id="notValidEmailAddress" style="display: none">
          <span class="somethingWrongSentence"
            >❗️ NOT a valid Email Address</span
          >
        </div>
        <button class="signIn" type="button" v-on:click="newcontact()">
          Add
        </button>

        <!--<div class="wrongInput" id="wrongInput" style="display: none">
          <span class="somethingWrongSentence"
            >❗️ Wrong email address or password</span
          >
        </div>-->

        <p class="center">
          Don't wnat to add contact?
          <a id="createOne" href="/mailbox">go home</a>.
        </p>
      </div>
    </form>
  </div>
</template>

<script>
const axios = require("axios").default;
export default {
  name: "login",
  components: {},
  data: function () {
    return {
      contact: {
        name: "",
        emailAddresses: [],
      },
    };
  },
  methods: {
    newcontact: function () {
      // Selecting the input mail element and get its value
      this.contact.emailAddresses.push(document.getElementById("email").value);
      this.contact.name = document.getElementById("contactName").value;
      document.getElementById("noEmailAddress").style = "display: none;";
      document.getElementById("noContact").style = "display: none;";
      var wrong = 0;
      if (this.contact.address == "") {
        document.getElementById("noEmailAddress").style.display = "block";
        wrong = 1;
      }
      if (this.contact.username == "") {
        document.getElementById("noContact").style.display = "block";
        wrong = 1;
      }
      if (wrong == 0) {
        axios
          .get("http://localhost:8080/checkValidAddress", {
            params: { email: document.getElementById("email").value },
          })
          .then((response) => {
            console.log(response.data);
            if (response.data == false) {
              document.getElementById("notValidEmailAddress").style.display =
                "block";
              return;
            } else {
              document.getElementById("notValidEmailAddress").style =
                "display: none;";
              console.log(this.contact);
              axios
                .post("http://localhost:8080/addContact", this.contact)
                .then((response) => {
                  console.log(response.data);
                  if (response.data == false) {
                    //document.getElementById("wrongInput").style.display ="block";
                  } else {
                    //document.getElementById("wrongInput").style ="display: none;";
                    //go to the main interface of the website
                    
                    window.location.href = "/Contacts";
                  }
                })
                .catch((e) => {
                  console.log(e);
                });
            }
          })
          .catch((e) => {
            console.log(e);
          });
      }
    },
  },
};
</script>

<style>
.display {
  color: #a3a3a3;
  border-bottom: 1px solid #e1e1e1;
  margin-bottom: 15px;
  overflow: hidden;
  text-overflow: clip;
}
body {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 14px;
}
/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}
/* Style the buttons inside the tab */
.tab a {
  background-color: inherit;
  float: right;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
  text-decoration: none;
  border: 1px solid;
}
/* Change background color of buttons on hover */
.tab a:hover {
  background-color: #ddd;
}
/* Create an active/current tablink class */
.tab a.active {
  background-color: #ccc;
}
/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
.loginsuccess-container {
  padding: 20px;
  margin: 0 auto;
  width: 80%;
  box-shadow: beige;
  border: 1px solid #ccc;
  border-radius: 5px;
  background: #fff;
  word-break: break-all;
}
.main-container {
  margin-top: 6%;
}
.box-container {
  padding: 20px;
  border-radius: 20px;
  border: solid;
  margin: 0 auto;
  width: 400px;
  box-shadow: beige;
  border: 1px solid #ccc;
  background: rgb(245, 54, 235);
}
.heading {
  text-align: center;
  font-weight: 300;
  color: #444;
  background: rgb(33, 226, 136);
  margin: 0 auto 45px;
  font-size: 35px;
  line-height: 38px;
  text-transform: none;
  letter-spacing: 0;
  border: solid #15cd72;
  border-radius: 15px;
}
.form-fields,
.form-fields button {
  width: 100%;
  margin: 5px 0;
  line-height: 28px;
  border-radius: 5px;
}
.form-fields input {
  width: 100%;
  line-height: 40px;
  border-radius: 5px;
  border-radius: 5px;
  border: 1px solid #f1f1f1;
  background: #fff;
  padding: 0 5px;
  font-size: 14px;
}
.signIn {
  padding: 10px 32px;
  color: white;
  font-size: 25px;
  font-weight: 400;
  background: #e62626;
  text-align: center;
  cursor: pointer;
  height: auto;
  border: solid;
  border-radius: 20px;
  border: brown;
  -webkit-appearance: none;
}
button {
  width: 100%;
  margin: 5px 0;
  line-height: 28px;
  border-radius: 5px;
}
.createaccount {
  padding: 15px;
  background-color: #0069ff;
  border: none;
  color: #fff;
  font-size: 16px;
  font-weight: 400;
  height: 48px;
  line-height: 48px;
  padding: 0 32px;
  text-align: center;
  border-radius: 5px;
}
.center {
  height: 30px;
  line-height: 30px;
  border: solid;
  border-radius: 10px;
  text-align: center;
  background: #ff5e00;
  font: 20px;
  color: black;
}
.login-choice span {
  color: #5b6987;
  display: -ms-grid;
  display: grid;
  font-size: 16px;
  width: 100%;
  line-height: 40px;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  text-align: center;
  -ms-grid-columns: minmax(20px, 1fr) auto minmax(20px, 1fr);
  grid-template-columns: minmax(20px, 1fr) auto minmax(20px, 1fr);
  grid-gap: 19px;
}
.login-choice span:after,
.login-choice span:before {
  content: "";
  border-top: 1px solid #e5e8ed;
}
.wrongInput {
  color: #ffffff;
  display: -ms-grid;
  background: rgb(245, 54, 235);

  font-size: 16px;
  width: 100%;
  line-height: 40px;
  -ms-grid-columns: minmax(20px, 1fr) auto minmax(20px, 1fr);
  grid-template-columns: minmax(20px, 1fr) auto minmax(20px, 1fr);
  grid-gap: 19px;
}
.signup-buttons {
  margin-top: 15px;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: justify;
  -ms-flex-pack: justify;
  justify-content: space-between;
  position: relative;
}
.facebook-signup,
.google-signup {
  color: #031b4e;
  background: #f2f8ff;
  border: 1px solid rgba(0, 105, 255, 0.2);
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  border-radius: 3px;
  display: inline-block;
  margin-top: 0;
  width: 47.5%;
  padding: 15px;
  text-align: center;
  position: inherit;
}
.signup-buttons a {
  vertical-align: middle;
  text-decoration: none;
}
.signup-buttons svg {
  left: 16px;
  position: absolute;
  top: 50%;
  -webkit-transform: translateY(-50%);
  transform: translateY(-50%);
}
.footer,
.footer a {
  text-align: center;
  color: #fff;
}

.somethingWrongSentence {
  background: rgb(245, 54, 235);
}

#createOne {
  margin-left: 2px;
  background: #ff5e00;
  color: #ffffffda;
}
</style>
