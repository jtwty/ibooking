<template>
    <div>
      <!-- 主入口的布局组件 -->
      <header>这里是头部</header>
      <aside>这里是侧边栏</aside>
      <main>
        <!-- Router View 用于展示匹配的子路由组件 -->
        <router-view></router-view>
      </main>
      <footer>这里是底部</footer>
    </div>
  </template>
  
  <script>
  export default {
    name: 'Main',
    // 你可以在这里添加一些组件的逻辑
  }
  </script>
  
  <style scoped>
  /* 在这里添加样式 */
  header {
    /* 头部样式 */
  }
  aside {
    /* 侧边栏样式 */
  }
  main {
    /* 主内容区样式 */
  }
  footer {
    /* 底部样式 */
  }
  </style>
  