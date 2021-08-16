import axios from "axios";
import VueAxios from 'vue-axios';

import Vue from 'vue'
Vue.use(VueAxios, axios);

//默认超时时间
axios.defaults.timeout = 10000;
//返回其他状态码
axios.defaults.validateStatus = function (status) {
  return status >= 200 && status <= 500;
};
//跨域请求，允许保存cookie
axios.defaults.withCredentials = true;

//http request拦截
axios.interceptors.request.use(config => {

  return config
}, error => {
  return Promise.reject(error)
});
//http response 拦截
axios.interceptors.response.use(res => {

  return res;
}, error => {
  return Promise.reject(new Error(error));
});

export default axios;
