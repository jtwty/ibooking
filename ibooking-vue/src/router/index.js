import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/tabs'
        },
        {
            path: '/',
            component: () => import('../components/common/Home.vue'),
            meta: { title: '自述文件' },
            children: [
                {
                    path: '/tabs',
                    component: () => import('../components/page/Dashboard.vue'),
                    meta: { title: '预定记录' }
                },
                {
                    path: '/404',
                    component: () => import('../components/page/404.vue'),
                    meta: { title: '404' }
                },
                {
                    path: '/403',
                    component: () => import('../components/page/403.vue'),
                    meta: { title: '403' }
                },
                {
                    path: '/seats',
                    component: () => import('../components/page/seatfree.vue'),
                    meta: { title: '座位查询' }
                },
                {
                    path: '/studyroom',
                    component: () => import('../components/page/studyroom.vue'),
                    meta: { title: '自习室管理' }
                },
                {
                    path: '/getstudyroom',
                    component: () => import('../components/page/getstudyroom.vue'),
                    meta: { title: '自习室查询' }
                },
                {
                    path: '/qiangwei',
                    component: () => import('../components/page/qiangwei.vue'),
                    meta: { title: '学生抢位' }
                },
                {
                    path: '/inform',
                    component: () => import('../components/page/inform.vue'),
                    meta: { title: '通知管理' }
                }
            ]
        },
        {
            path: '/login',
            component: () => import('../components/page/Login.vue'),
            meta: { title: '登录' }
        },
        {
            path: '*',
            redirect: '/404'
        }
    ]
});
