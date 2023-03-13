<template>
    <nav class="navbar navbar-expand " style="background-color: white;">
      <div class="container">
        
          <router-link :class="route_name == 'home_index' ? 'navbar-brand active' : 'navbar-brand'" :to="{name: 'home_index' }">
            <div class="logo">
              <img src="../assets/logo.png" alt="">
            </div>
          </router-link>
        
        <div class="collapse navbar-collapse" id="navbarText">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <router-link :class="route_name == 'home_index' ? 'nav-link active': 'nav-link'" aria-current="page" :to="{name: 'home_index' }">
                <div class="af">首页</div> 
            </router-link>
            </li>
            <li class="nav-item">
              <router-link :class="route_name == 'bank_index' ? 'nav-link active': 'nav-link'" aria-current="page" :to="{name: 'bank_index' }">
                <div class="af">题库</div> 
              </router-link>
            </li>
            <li class="nav-item">
              <router-link :class="route_name == 'subject_index' ? 'nav-link active': 'nav-link'" aria-current="page" :to="{name: 'subject_index' }">
                <div class="af">专题练习</div> 
              </router-link>
            </li>
            <li class="nav-item">
              <router-link :class="route_name == 'competition_index' || route_name == 'competition_overview' || route_name == 'competition_problem_overview' || route_name == 'competition_title' || route_name == 'competition_rating' ? 'nav-link active': 'nav-link'" aria-current="page" :to="{name: 'competition_index' }">
                <div class="af">比赛</div> 
              </router-link>
            </li>
          </ul>
          <ul class="navbar-nav" v-if="$store.state.user.is_login">
            <li class="nav-item dropdown">
               <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                
                  <img class="user-photo" :src="$store.state.user.photo" alt="">
                  {{ $store.state.user.username }}
                
                </a>
               <ul class="dropdown-menu">
                  <li><router-link :class="route_name == 'user_index' ? 'dropdown-item active': 'dropdown-item'" :to="{name: 'user_index' }">个人中心</router-link></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><router-link v-if="$store.state.user.username === '王兆轩'" :class="route_name == 'administrator_index' ? 'dropdown-item active': 'dropdown-item'" :to="{name: 'administrator_index' }">数据管理</router-link></li>
                  <li><a class="dropdown-item" @click="logout">退出</a></li>
               </ul>
            </li>
          </ul>
    
          <ul class="navbar-nav" v-else-if="!$store.state.user.pulling_info">
            <li class="nav-item">
               <router-link :to="{name: 'user_login'}" class="nav-link" role="button">
                  登录
                </router-link>
            </li>
            <li>
                <router-link :to="{name: 'user_register'}" class="nav-link" role="button">
                  注册
                </router-link>
            </li>
          </ul>
    
        </div>
        
      </div>
    </nav>
    
</template>
    
<script>
import { useRoute } from "vue-router";
import { computed } from "vue";
import { useStore } from "vuex";

            
export default{
    setup() {
      const store = useStore();
      const route =useRoute();
      let route_name =computed(() => route.name);
      const logout=()=>{
        store.dispatch("logout");
      }
      return {
        route_name,
        logout,
      }
    }
}
            
</script>
            
<style scoped>
.navbar-expand{
    background: transparent;
    box-shadow: 0px 4px 20px 0px rgb(79 114 205 / 15%);
    background-color: rgba(255,255,255,0.7);
}

div.logo>img{
    width: 6vh;
    border-radius: 50%;
}
.user-photo{
  width: 3vh;
  border-radius: 50%;
}
.active>div.af{
    font-size: 90%;
    font-weight: 600;
    color: #1976d2;
}
div.af{
    font-size: 80%;
    color: black;
    font-weight: 300;
}
</style>