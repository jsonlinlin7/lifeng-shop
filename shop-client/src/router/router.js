import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [{
    path: '/',
    redirect: "/index"
  },
  {
    path: '/index',
    name: '首页',
    component: () => import("@/pages/Index"),
    children: [{
      path: '',
      name: 'toIndex',
      component: () => import("@/views/IndexMain")
    }]
  },
  {
    path: '/category',
    redirect: "/category/index",
    name: '商品分类',
    component: () => import("@/pages/Category"),
    children: [{
        path: "index",
        component: () => import("@/views/CategoryMain")
      },
      {
        path: ":goodsName",
        component: () => import("@/views/CategoryMain"),
        props: true,
        children: [{
          path: ":goodsBrand",
          component: () => import("@/views/CategoryMain"),
          props: true
        }]
      },
      {
        path: "search",
        component: () => import("@/views/CategoryMain")
      },
    ]
  },
  {
    path: '/search',
    name: 'Search',
    component: () => import("@/pages/Search")
  },
  {
    path: '/categorySearchContent',
    name: 'CategorySearchContent',
    component: () => import("@/pages/CategorySearchContent")
  },
  {
    path: '/history',
    name: "History",
    component: () => import("@/pages/history")
  },
  {
    path: '/collection',
    name: "collection",
    component: () => import("@/views/Collection")
  },
  {
    path: '/Order',
    name: '我的订单',
    component: () => import("@/components/Order.vue"),
  },
  {
    path: '/goodsDetail/:id',
    name: '商品详情页',
    component: () => import("@/components/GoodsDetail.vue"),
  },
  {
    path: '/cart',
    // redirect: "/cart/index",
    name: '购物车',
    component: () => import("@/pages/Cart"),
    children: [{
        path: "",
        component: () => import("@/views/ShoppingCart")
      }

    ]
  },


  {
    path: '/login',
    name: '登录页面',
    component: () => import("@/views/login.vue"),
  },
  {
    path: '/register',
    name: '注册页面',
    component: () => import("@/views/register.vue"),
  },
  {
    path: '/OrderDetails',
    name: '订单详情页面',
    component:() => import("@/components/OrderDetails.vue"),
  },


]

const router = new VueRouter({
  routes,
  mode: "history"
})

export default router