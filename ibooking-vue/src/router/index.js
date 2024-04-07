// router/index.js
import Vue from 'vue';
import Router from 'vue-router';
import Login from '@/views/login.vue'; // 引入登录组件

Vue.use(Router);

export default new Router({
  mode: 'history', // 使用HTML5 History模式
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login, // 将根路径（/）映射到登录组件
    },
    // 其他路由...
  ],
});
