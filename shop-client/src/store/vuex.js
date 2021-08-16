import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const user = {
  state: {
    //很多需要被共享的数据
    user: {
      username: "Jeremy",
      password: "123456"
    },
    userExtand: {

    }
  },
  //为了数据安全,应该使用getters获取数据
  getters: {
    //getters方法必须在形参中协写上state, 这是vuex已经定义好的, 我们再通过state.XXX取出来
    // user() {
    //   return this.state.user
    // },
    user: (state) => {
      return state.user
    },

  },
  //mutations里面写定义好的方法, 并且方法名应该用大写(表示常量), mutation 必须是同步方法
  mutations: {
    //第一个参数是Vuex定义好的,必须写state, 其他参数就是commit该方法时,传递的实参
    SET_USERNAME (state, newUsername) {
      state.user.username = newUsername
    },
    SET_PASSWORD (state, newPassword) {
      state.user.password = newPassword
    }
  },
  // actions用来调用多个mutations, 是专门用来处理异步操作的
  actions: {
    // 官方写法 context
    // setUser(context, user) {
    //   context.commit('SET_USERNAME',user.username)
    //   context.commit('SET_PASSWORD',user.password)
    // }
    // 简写 {commit}
    setUser({commit}, user) {
      return new Promise((resolve) => {
        console.log("假装发送异步请求, loading......")
        console.log("response success!")
        commit('SET_USERNAME',user.username)
        commit('SET_PASSWORD',user.password)
        resolve();
      })
    }
  },
}

export default new Vuex.Store({
  modules: {
    user
  }
})
