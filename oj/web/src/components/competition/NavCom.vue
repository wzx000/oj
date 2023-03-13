<template>
    <ContentField>
        <div class="container">
            {{ $store.state.problem.competitionName }}
        </div>
    </ContentField>
    <ContentField>
        <nav class="navbar navbar-expand" style="background-color: white;">
        <div class="container">
            <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                <router-link :class="route_name == 'competition_overview' ? 'nav-link active': 'nav-link'" aria-current="page" :to="{name: 'competition_overview' }">
                    <div class="af">详情</div> 
                </router-link>
                </li>
                <li class="nav-item">
                <router-link :class="route_name == 'competition_problem_overview' ? 'nav-link active': 'nav-link'" aria-current="page" :to="{name: 'competition_problem_overview' }">
                    <div class="af">题目</div> 
                </router-link>
                </li>
                <li class="nav-item">
                <router-link :class="route_name == 'competition_rating' ? 'nav-link active': 'nav-link'" aria-current="page" :to="{name: 'competition_rating' }">
                    <div class="af">排名</div> 
                </router-link>
                </li>
                
            </ul>
        
        
            </div>
            
        </div>
        </nav>
    </ContentField>
</template>
    
<script>
import { useRoute } from "vue-router";
import { computed } from "vue";
import ContentField from "../../components/ContentField.vue";

export default{
    components:{

        ContentField,
    },
    setup() {
      const route =useRoute();
      let route_name =computed(() => route.name);

      return {
        route_name,
      }
    }
}  
</script>
            
<style scoped>
div.container{
    height: 100%;
}
.navbar-expand{
    border-style: none;
}
.active>div.af{
    font-size: 100%;
    font-weight: 600;
    color: #1976d2;
}
div.af{
    font-size: 100%;
    color: black;
    font-weight: 300;
}
</style>