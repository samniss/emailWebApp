import birthDatepicker from 'vue-birth-datepicker';
<template>
    <div class="main-container">
        <form>
            <div class="box-container">
                <h2 class="heading">
                Create Your Account
                </h2>
                <div class="form-fields">
                <input id="userName" name="userName" type="text" placeholder="Full name">
                </div>
                <div class="wrongInput" id="noFullName" style="display: none;"><span>you should enter your Full name</span></div>
                <div class="form-fields">
                <input id="email" name="email" type="text" placeholder="Email Address">
                </div>
                <div class="wrongInput" id="noEmailAddress" style="display: none;"><span>you should enter Email Address</span></div>
                <div class="form-fields">
                <input id="password" name="password" type="text" placeholder="Password">
                </div>
                <div class="wrongInput" id="noPassword" style="display: none;"><span>you should enter password</span></div>
                <div class="form-fields">
                <input id="year" name="year" type="text" placeholder="year">
                <div class="wrongInput" id="noYear" style="display: none;"><span>you should enter year</span></div>
                <input id="month" name="month" type="text" placeholder="month">
                <div class="wrongInput" id="noMonth" style="display: none;"><span>you should enter month</span></div>
                <input id="day" name="day" type="text" placeholder="day">
                <div class="wrongInput" id="noDay" style="display: none;"><span>you should enter day</span></div>
                </div>
                <div>
                <br>
                <ejs-dropdownlist id='dropdownlist' popupHeight="200px" popupWidth="100%" :dataSource='genders' placeholder='Select your gender'></ejs-dropdownlist>
                </div>
                <div class="wrongInput" id="nogender" style="display: none;"><span>you should select your gender</span></div>
                <div class="login-choice"><span>....</span></div>
                <div class="form-fields">
                <button class="createaccount" type="button" v-on:click="signUp()">
                    Create your account
                </button>
                </div>
                <div class="wrongInput" id="usedAddress" style="display: none;"><span>that emai is used before</span></div>
                <div>
                    <p class="center">
                        Already have an account?
                        <a href="/login"> Sign In</a>.
                    </p>
                </div>
            </div>
        </form>
    </div>
</template>

<script>
import Vue from 'vue';
//import SocialSignUp from './components/SocialLogin'
import { DropDownListPlugin } from '@syncfusion/ej2-vue-dropdowns';
Vue.use(DropDownListPlugin);
const axios = require("axios").default;
export default {
  name: 'signup',
  components: {
    //SocialSignUp
  },
  data: function () {
    return {
       genders: ['Male', 'Female'],
      mail:{
        username:"",
        address: "",
        password: "",
        birthDate:"",
        gender:"",
        contacts:[],
        folders:[]
      }
    };
  },
  methods: {
    signUp: function () {
      // Selecting the input mail element and get its value 
      this.mail.username ="";
      this.mail.address ="";
      this.mail.password ="";
      this.mail.birthDate = "";
      this.mail.gender ="";
      this.mail.username = document.getElementById("userName").value;
      this.mail.address = document.getElementById("email").value;
      this.mail.password = document.getElementById("password").value;
      this.mail.birthDate = "".concat(document.getElementById("year").value,'-',document.getElementById("month").value,'-',document.getElementById("day").value);
      this.mail.gender = document.getElementById("dropdownlist").value;
      document.getElementById('noFullName').style="display: none;";
      document.getElementById('noEmailAddress').style="display: none;";
      document.getElementById('noPassword').style="display: none;";
      document.getElementById('noYear').style="display: none;";
      document.getElementById('noMonth').style="display: none;";
      document.getElementById('noDay').style="display: none;";
      document.getElementById('nogender').style="display: none;";
      var wrong =0;
      if(this.mail.username==""){
          document.getElementById('noFullName').style.display = 'block';
          wrong=1;
      }
      if(this.mail.address==""){
          document.getElementById('noEmailAddress').style.display = 'block';
          wrong=1;
      }
      if(this.mail.password==""){
          document.getElementById('noPassword').style.display = 'block';
          wrong=1;
      }
      if(document.getElementById("year").value==""){
          document.getElementById('noYear').style.display = 'block';
          wrong=1;
      }
      if(document.getElementById("month").value==""){
          document.getElementById('noMonth').style.display = 'block';
          wrong=1;
      }
      if(document.getElementById("day").value==""){
          document.getElementById('noDay').style.display = 'block';
          wrong=1;
      }
      if(this.mail.gender==""){
          document.getElementById('nogender').style.display = 'block';
          wrong=1;
      }
      if(wrong==0){
          axios
          .post("http://localhost:8080/signUp", this.mail)
          .then((response) => {
              console.log(response.data);
              if(response.data==false){
                  document.getElementById('usedAddress').style.display = 'block';
              }
              else{
                  document.getElementById('usedAddress').style="display: none;";
                  //go to the main interface of the website
              }
          })
          .catch((e) => {
              console.log(e);
          });
      }
    },
  }
}

</script>

<style>
@import '../node_modules/@syncfusion/ej2-base/styles/material.css';
@import '../node_modules/@syncfusion/ej2-buttons/styles/material.css';
@import '../node_modules/@syncfusion/ej2-popups/styles/material.css';
@import '../node_modules/@syncfusion/ej2-splitbuttons/styles/material.css';
body {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 14px;
    background: #0069ff;
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
    margin-top: 10%;
}
.box-container {
    padding: 20px;
    margin: 0 auto;
    width: 400px;
    box-shadow: beige;
    border: 1px solid #ccc;
    border-radius: 5px;
    background: #fff;
}
.heading {
    text-align: center;
    font-weight: 300;
    color: #444;
    margin: 0 auto 45px;
    font-size: 35px;
    line-height: 38px;
    text-transform: none;
    letter-spacing: 0;
}
.form-fields, .form-fields button {
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
    background: #15CD72;
    text-align: center;
    cursor: pointer;
    height: auto;
    -webkit-appearance: none;
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
    text-align: center
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
    -ms-grid-columns: minmax(20px,1fr) auto minmax(20px,1fr);
    grid-template-columns: minmax(20px,1fr) auto minmax(20px,1fr);
    grid-gap: 19px;
}
.login-choice span:after, .login-choice span:before {
    content: "";
    border-top: 1px solid #e5e8ed;
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
    -ms-grid-columns: minmax(20px,1fr) auto minmax(20px,1fr);
    grid-template-columns: minmax(20px,1fr) auto minmax(20px,1fr);
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
.facebook-signup, .google-signup {
    color: #031b4e;
    background: #f2f8ff;
    border: 1px solid rgba(0,105,255,.2);
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
.footer, .footer a {
    text-align: center;
    color: #fff
}

</style>
