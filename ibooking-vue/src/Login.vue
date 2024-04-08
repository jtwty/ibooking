<template>
  <div class="login-container">
    <h1>自习室管理系统</h1>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="studentId">学号</label>
        <input
          type="text"
          id="studentId"
          v-model="studentId"
          required
          autofocus
          placeholder="请输入学号"
        />
      </div>

      <div class="form-group">
        <label for="password">密码</label>
        <input
          type="password"
          id="password"
          v-model="password"
          required
          placeholder="请输入密码"
        />
      </div>

      <button type="submit" class="login-button">登录</button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      studentId: '',
      password: '',
    };
  },
  methods: {
    login() {
    // 登录逻辑
    console.log("登录信息", this.studentId, this.password);
    // 假设登录成功，跳转到学生管理页面
    this.$router.push('/main');
  },
  },
};
</script>

<style scoped>


.login-container {
  max-width: 400px;
  margin: 50px auto;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
  text-align: center;
}

.form-group {
  margin-bottom: 20px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
}

.form-group input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.login-button {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  color: white;
  cursor: pointer;
}

.login-button:hover {
  background-color: #0056b3;
}
</style>
