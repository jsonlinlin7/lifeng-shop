import Vue from 'vue'
import App from './App.vue'
import router from './router/router'
import store from './store/vuex'
import './plugins/element.js'
import mock from '../mock/index'
import axios from "./plugins/axios";
Vue.use(mock)
Vue.use(axios)
Vue.config.productionTip = false

new Vue({
  mock,
  router,
  store,
  axios,
  render: h => h(App)
}).$mount('#app')
