<template>
    <div class="signin-container">
      <h1>登录</h1>
      <form @submit.prevent="signIn">
        <div class="form-group">
          <label for="email">邮箱</label>
          <input type="email" id="email" v-model="credentials.email" required>
        </div>
        <div class="form-group">
          <label for="password">密码</label>
          <input type="password" id="password" v-model="credentials.password" required>
        </div>
        <button type="submit">登录</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'SignIn',
    data() {
      return {
        credentials: {
          email: '',
          password: ''
        }
      };
    },
    methods: {
      async signIn() {
        try {
          const response = await axios.post('/api/auth/signin', this.credentials);
          console.log('Authentication successful', response);
          // 这里可以根据需要处理登录成功后的逻辑，如保存token，导航到另一个页面等
          // 例如: this.$router.push({ name: 'Home' });
        } catch (error) {
          console.error('Authentication failed', error);
          // 处理登录失败的逻辑，可能是显示一个错误消息等
        }
      }
    }
  };
  </script>
  
  <style scoped>
  .signin-container {
    max-width: 400px;
    margin: auto;
    padding: 20px;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  form {
    display: flex;
    flex-direction: column;
  }
  
  label {
    margin-bottom: 5px;
  }
  
  input[type="email"],
  input[type="password"] {
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  
  button {
    padding: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #0056b3;
  }
  </style>
  