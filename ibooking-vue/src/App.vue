<!-- <template>
    <div id="app" class="container mt-4">
      <nav class="navbar navbar-expand-lg navbar-light bg-light rounded mb-4">
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <router-link to="/all_students" class="nav-link">
                学生管理
              </router-link>
            </li>
            <li class="nav-item">
              <router-link to="/all_studyrooms" class="nav-link">
                自习室管理
              </router-link>
            </li>
          </ul>
        </div>
      </nav>
      <router-view> -->
        <!-- This component will be rendered here -->
      <!-- </router-view>
    </div>
  </template>
  
  <style>
  .fade-enter-active, .fade-leave-active {
    transition: opacity 0.5s;
  }
  .fade-enter, .fade-leave-to /* 修改为fade-leave-to */ {
    opacity: 0;
  }
  #app {
    margin-top: 20px;
  }
  .nav-item .nav-link {
    margin-right: 10px;
    transition: color 0.2s ease-in-out;
  }
  .nav-item .nav-link:hover {
    color: #191ce1; /* Bootstrap primary color */
    text-decoration: none;
  }
</style>

  <script>
  export default {
    name: "app",
  };
  </script> -->

  <template>
    <transition name="fade">
      <router-view></router-view>
    </transition>
  </template>
  
  <script>
    export default {
    }
  </script>
  