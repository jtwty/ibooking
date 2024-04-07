<template>
  <div id="all_studyroom" class="container mt-5">
    <h1 class="mb-4">自习室管理</h1>



    <div class="input-group mb-3">
      <input
        type="text"
        name="search"
        v-model="studyRoomSearch"
        placeholder="Search Study Room"
        class="form-control"
        v-on:keyup="searchStudyRooms"
      />
      <div class="input-group-append">
        <button class="btn btn-outline-secondary" type="button" @click="searchStudyRooms">搜索</button>
      </div>
    </div>

    <table class="table table-bordered table-hover">
      <thead class="thead-dark">
        <tr>
          <th>ID</th>
          <th>楼栋信息</th>
          <th>自习室信息</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="studyRoom in studyRooms" :key="studyRoom.id">
          <td>{{ studyRoom.id }}</td>
          <td>{{ studyRoom.buildingNumber }}</td>
          <td>{{ studyRoom.classRoomNumber }}</td>
          <td>
            <router-link :to="{ name: 'edit_studyRoom', params: { stu: studyRoom } }" class="btn btn-info mr-2">
              修改
            </router-link>
            <router-link :to="{ name: 'delete_studyRoom', params: { stu: studyRoom } }" class="btn btn-warning">
              删除
            </router-link>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
