<template>
  <div class="home">
    <mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field> 
    <mt-field label="密码" placeholder="请输入密码" v-model="password"></mt-field> 
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      password: ""
    };
  },
};
</script>
