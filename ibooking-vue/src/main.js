import Vue from 'vue';
import App from './App.vue';
import router from './router';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/css/icon.css';
import './components/common/directives';
import 'babel-polyfill';

Vue.config.productionTip = false;
Vue.use(ElementUI, {
    size: 'small'
});

router.beforeEach((to, from, next) => {
    document.title = `${to.meta.title} | study-room-manager`;
    localStorage.setItem('token', 'admin')
    localStorage.setItem('ms_username', 'admin')
    const role = localStorage.getItem('token');
    if (!role && to.path !== '/login') {
        next('/login');
    } else {
        next();
    }
});

new Vue({
    router,
    render: h => h(App)
}).$mount('#app');
