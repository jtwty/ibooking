import { createRouter, createWebHistory } from 'vue-router';
import SignIn from '../views/SignIn.vue'; // 引入SignIn组件

// 定义路由数组
const routes = [
  {
    path: '/login',
    name: 'Login',
    component: SignIn // 指向SignIn组件
  },
  // 添加其他路由配置
];

// 创建router实例
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes // 使用定义的路由配置
});

export default router;
