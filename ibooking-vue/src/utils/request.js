import axios from 'axios';

const service = axios.create({
    baseURL: '/api',
    timeout: 3000
});

service.interceptors.request.use(
    config => {
        const token = localStorage.getItem('token');
        if (config.method === 'post') {
            config.params = {
                ...config.params
            }
        } else if (config.method === 'get') {
            config.params = {
                ...config.params
            }
        } else if (config.method === 'put') {
            config.params = {
                // token: token,
                ...config.params
            }
        } 
        return config;
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

service.interceptors.response.use(
    response => {
        if (response.status === 200) {
            return response.data;
        } else {
            Promise.reject();
        }
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

export default service;
