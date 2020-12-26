import VueRouter from 'vue-router'
import Vue from 'vue'
import App from './App.vue'
import MailBox from "./components/MailBox";
import LogIn from "./components/Login";
import SignUp from "./components/signUp";
import Contacts from "./components/Contacts";
import NewContact from "./components/newContact";
import Folders from "./components/Folders";
import compose from "./components/compose";
import email from "./components/viewMail"
Vue.use(VueRouter);
const routes = [
  {
    path: "/mailbox",
    component: MailBox
  },
  {
    path: "/signIn",
    component: LogIn
  },
  {
    path: "/signUp",
    component: SignUp
  },
  {
    path: "/NewContact",
    component: NewContact
  },
  {
    path: "/",
    component: LogIn
  },
  {
    path: "/Contacts",
    component: Contacts
  }
  ,
  {
    path: "/Folders",
    component: Folders
  },
  {
    path: "/SendEmail",
    component: compose
  },
  {
    path: "/email",
    component: email
  }
];
export const router = new VueRouter({
  routes: routes,
  mode: 'history'
});
new Vue({
  router: router,
  render: h => h(App),
}).$mount('#app')
