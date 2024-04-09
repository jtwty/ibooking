import Vue from 'vue'

import VueRouter from 'vue-router'
Vue.use(VueRouter);

import VueResource from 'vue-resource';
Vue.use(VueResource);
// import Login from './Login.vue';
import App from './App.vue';


// import Main from './components/App.vue'; // 使用ES6导入语法
// import AllStudents from './components/all-students.vue';
// import AddStudent from './components/add-student.vue';
// import EditStudent from './components/edit-student.vue';
// import DeleteStudent from './components/delete-student.vue';
// import AllStudyRooms from './components/all-studyrooms.vue';


// const Main = require('./components/App.vue');
const AllStudents = require('./components/all-students.vue');
const AddStudent = require('./components/add-student.vue');
const EditStudent = require('./components/edit-student.vue');
const DeleteStudent = require('./components/delete-student.vue');
const AllStudyRooms = require('./components/all-studyrooms.vue');

const routes = [
    // {   
    //     name: 'login',
    //     path: '/login',
    //     component: Login 
    // },
    // {
    //     name:'main',
    //     path:'/main',
    //     component: Main
    // },
    {
        name: 'all_students',
        path: '/',
        component: AllStudents
    },
    {
        name: 'all_students',
        path: '/all_students',
        component: AllStudents
    },
    {
        name: 'add_student',
        path: '/student/add-student',
        component: AddStudent
    },
    {
        name: 'edit_student',
        path: '/student/edit/:stu',
        component: EditStudent
    },
    {
        name: 'delete_student',
        path: '/student/delete/:stu',
        component: DeleteStudent
    },
    {
        name: 'all_studyrooms',
        path: '/all_studyrooms',
        component: AllStudyRooms
    }
];
var router = new VueRouter({ routes: routes, mode: 'history' });
new Vue(Vue.util.extend({ router }, App)).$mount('#app');