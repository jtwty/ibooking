<template>
  <div id="all_students" class="container mt-5">
    <h1 class="mb-4">学生管理</h1>

    <div class="mb-3">
      <router-link :to="{ name: 'add_student' }" class="btn btn-success">
        添加学生信息
      </router-link>
    </div>


    <div class="input-group mb-3">
      <input
        type="text"
        name="search"
        v-model="studentSearch"
        placeholder="Search Students"
        class="form-control"
        v-on:keyup="searchStudents"
      />
      <div class="input-group-append">
        <button class="btn btn-outline-secondary" type="button" @click="searchStudents">搜索</button>
      </div>
    </div>

    <table class="table table-bordered table-hover">
      <thead class="thead-dark">
        <tr>
          <th>ID</th>
          <th>学号</th>
          <th>姓名</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="student in students" :key="student.id">
          <td>{{ student.id }}</td>
          <td>{{ student.stuNum }}</td>
          <td>{{ student.name }}</td>
          <td>
            <router-link :to="{ name: 'edit_student', params: { stu: student } }" class="btn btn-info mr-2">
              修改
            </router-link>
            <router-link :to="{ name: 'delete_student', params: { stu: student } }" class="btn btn-warning">
              删除
            </router-link>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
