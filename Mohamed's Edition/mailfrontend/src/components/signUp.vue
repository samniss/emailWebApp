
<template>
  <div class="main-container">
    <form>
      <div class="box-container">
        <h2 class="heading">Create Account</h2>
        <div class="form-fields">
          <input
            id="userName"
            name="userName"
            type="text"
            placeholder="Full name"
          />
        </div>
        <div class="wrongInput" id="noFullName" style="display: none">
          <span>you should enter your Full name</span>
        </div>
        <div class="form-fields">
          <input
            id="email"
            name="email"
            type="text"
            placeholder="Email Address"
          />
        </div>
        <div class="wrongInput" id="noEmailAddress" style="display: none">
          <span>you should enter Email Address</span>
        </div>
        <div class="form-fields">
          <input
            id="password"
            name="password"
            type="text"
            placeholder="🔒 Password"
          />
        </div>
        <div class="wrongInput" id="noPassword" style="display: none">
          <span>you should enter password</span>
        </div>
        <div class="form-fields">
          <input id="year" name="year" type="text" placeholder="Year" />
          <div class="wrongInput" id="noYear" style="display: none">
            <span>you should enter year</span>
          </div>
          <input id="month" name="month" type="text" placeholder="Month" />
          <div class="wrongInput" id="noMonth" style="display: none">
            <span>you should enter month</span>
          </div>
          <input id="day" name="day" type="text" placeholder="Day" />
          <div class="wrongInput" id="noDay" style="display: none">
            <span>you should enter day</span>
          </div>
        </div>

        <button
          class="button"
          type="button"
          :class="{ disabledButton: grnderMale }"
          v-on:click="male()"
        >
          Male
        </button>
        <button
          class="button"
          type="button"
          :class="{ disabledButton: grnderfemale }"
          v-on:click="female()"
        >
          Female
        </button>

        <div class="wrongInput" id="nogender" style="display: none">
          <span>you should select your gender</span>
        </div>
        <button class="createaccount" type="button" v-on:click="signUp()">
          Submit
        </button>
        <div class="wrongInput" id="usedAddress" style="display: none">
          <span>that emai is used before</span>
        </div>
        <p class="center">
          Already have an account?
          <a id="signInButton" href="/signIn"> Sign In</a>
        </p>
      </div>
    </form>
  </div>
</template>

<script>
const axios = require("axios").default;
export default {
  name: "signup",
  components: {},
  data: function () {
    return {
      genders: ["Male", "Female"],
      mail: {
        username: "",
        address: "",
        password: "",
        birthDate: "",
        gender: "",
        contacts: [],
        folders: [],
      },
    };
  },
  methods: {
    male: function () {
      this.mail.gender = "male";
      document.getElementById("nogender").style = "display: none;";
    },
    female: function () {
      this.mail.gender = "female";
      document.getElementById("nogender").style = "display: none;";
    },
    signUp: function () {
      // Selecting the input mail element and get its value
      this.mail.username = "";
      this.mail.address = "";
      this.mail.password = "";
      this.mail.birthDate = "";
      this.mail.username = document.getElementById("userName").value;
      this.mail.address = document.getElementById("email").value;
      this.mail.password = document.getElementById("password").value;
      this.mail.birthDate = "".concat(
        document.getElementById("year").value,
        "-",
        document.getElementById("month").value,
        "-",
        document.getElementById("day").value
      );
      document.getElementById("noFullName").style = "display: none;";
      document.getElementById("noEmailAddress").style = "display: none;";
      document.getElementById("noPassword").style = "display: none;";
      document.getElementById("noYear").style = "display: none;";
      document.getElementById("noMonth").style = "display: none;";
      document.getElementById("noDay").style = "display: none;";
      document.getElementById("nogender").style = "display: none;";
      console.log(Number.isInteger(parseFloat(document.getElementById("year").value)));
      var wrong = 0;
      if (this.mail.username == "") {
        document.getElementById("noFullName").style.display = "block";
        wrong = 1;
      }
      if (this.mail.address == "") {
        document.getElementById("noEmailAddress").style.display = "block";
        wrong = 1;
      }
      if (this.mail.password == "") {
        document.getElementById("noPassword").style.display = "block";
        wrong = 1;
      }
      if (document.getElementById("year").value == "") {
        document.getElementById("noYear").style.display = "block";
        wrong = 1;
      }
      if (!Number.isInteger(parseFloat(document.getElementById("year").value))) {
        document.getElementById("noYear").style.display = "block";
        wrong = 1;
      }
      else{
        if(parseFloat(document.getElementById("year").value)<=0){
          document.getElementById("noYear").style.display = "block";
        wrong = 1;
        }
      }
      if (document.getElementById("month").value == "") {
        document.getElementById("noMonth").style.display = "block";
        wrong = 1;
      }
      if (!Number.isInteger(parseFloat(document.getElementById("month").value))) {
        document.getElementById("noMonth").style.display = "block";
        wrong = 1;
      }
      else{
        if(parseFloat(document.getElementById("month").value)<=0||parseFloat(document.getElementById("month").value)>12){
          document.getElementById("noMonth").style.display = "block";
        wrong = 1;
        }
      }
      if (document.getElementById("day").value == "") {
        document.getElementById("noDay").style.display = "block";
        wrong = 1;
      }
      if (!Number.isInteger(parseFloat(document.getElementById("day").value))) {
        document.getElementById("noDay").style.display = "block";
        wrong = 1;
      }
      else{
        if(parseFloat(document.getElementById("day").value)<=0||parseFloat(document.getElementById("day").value)>30){
          document.getElementById("noDay").style.display = "block";
        wrong = 1;
        }
      }
      if (this.mail.gender == "") {
        document.getElementById("nogender").style.display = "block";
        wrong = 1;
      }
      if (wrong == 0) {
        axios
          .post("http://localhost:8080/signUp", this.mail)
          .then((response) => {
            console.log(response.data);
            if (response.data == false) {
              document.getElementById("usedAddress").style.display = "block";
            } else {
              document.getElementById("usedAddress").style = "display: none;";
              //go to the main interface of the website
              window.location.href = "/mailbox";
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
  margin-top: 2%;
}
.box-container {
  border: solid;
  border-radius: 15px;
  border-color: #15cd72;
  padding: 20px;
  margin: 0 auto;
  width: 400px;
  box-shadow: beige;
  background: linear-gradient(rgb(58, 186, 224), rgb(59, 135, 223));
}
.heading {
  text-align: center;
  font-weight: 300;
  font-size: 20px;
  color: #444;
  margin: 0 auto 45px;
  font-size: 35px;
  line-height: 38px;
  text-transform: none;
  letter-spacing: 0;
  border: solid;
  border-radius: 20px;
}
.form-fields,
.form-fields button {
  width: 95%;
  margin: 2px 0;
  line-height: 28px;
  border-radius: 5px;
}
.form-fields input {
  width: 100%;
  line-height: 40px;
  border-radius: 5px;
  border-radius: 10px;
  border: 1px solid #f1f1f1;
  background: #fff;
  padding: 0 5px;
  font-size: 14px;
}

.display {
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
  font-size: 16px;
  font-weight: 400;
  background: #15cd72;
  text-align: center;
  cursor: pointer;
  height: auto;
  -webkit-appearance: none;
}
.createaccount {
  background: #47cc42;
  border: none;
  color: rgb(255, 255, 255);
  font-size: 16px;
  height: 48px;
  line-height: 48px;
  text-align: center;
  font-size: 20px;
  border-radius: 15px;
}
.center {
  text-align: center;
  background: rgb(233, 63, 51);
}
.login-choice {
  margin-top: 110px;
  border: none;
  border-radius: 20px;
  background: linear-gradient(rgb(58, 186, 224), rgb(59, 135, 223));
}

.login-choice span {
  color: #5b6987;
  margin-bottom: 10px;
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
  border-radius: 20px;
  background: linear-gradient(rgb(58, 186, 224), rgb(59, 135, 223));
}
.login-choice span:after,
.login-choice span:before {
  content: "";
  border-top: 1px solid #000000;
}
.wrongInput {
  color: #ff4343;
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
.emailsOperationDiv {
  float: left;
  margin-left: 0px;
  margin-top: 10px;
  margin-bottom: 11%;
  width: 10%px;
  color: rgb(226, 40, 211);
  border: solid;
  border-radius: 40px;
  background: blueviolet;
  height: 10%px;
}
.emailsOperationButton {
  margin-right: 0px;
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
  margin-top: -12px;
  margin-bottom: 2px;
  border-bottom: solid;
  border-color: brown;
  border-radius: 20px;
  background: rgb(235, 74, 74);
}

.emailsOperationButton:hover .subMenu-1 {
  display: block;
}

.AlreadyHaveAnAccountDiv {
  color: #000000;
  border: solid;
  border-radius: 10px;
  background: rgb(233, 63, 51);
}

#signInButton {
  margin-left: 2px;
  color: #ffffff;
  background: rgb(233, 63, 51);
}

.menuElement {
  margin-top: 0px;
  float: left;
  width: 100px;
  background: cyan;
  border-radius: 20px;
  border: solid;
}
.emailsOperationButton :hover {
  background: rgb(44, 149, 156);
}

#subMenuDiv {
  color: #15cd72;
  background: #15cd72;
}
</style>
