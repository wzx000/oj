<template>
    <ContentField>    
        <router-link :to="{name: 'competition_problem_add'}" role="button">
            添加题目
        </router-link>
    </ContentField>
    <ContentField>
        <table class="table table-striped table-hover" style="text-align: center;">
            <thead>
                <tr>
                    <th>题目</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="competitionProblem in competitionProblems" :key="competitionProblem.id">
                    <td>{{ competitionProblem.title }}</td>
                    <td>
                        <button type="button" class="btn btn-secondary" style="margin-right: 10px;" @click="update_competitionProblem(competitionProblem)">修改</button>
                        <button type="button" class="btn btn-danger"  @click="remove_competitionProblem(competitionProblem)">删除</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </ContentField>
</template>

<script>
import ContentField from "../../../components/ContentField.vue";
import { useStore } from "vuex";
import { ref } from "vue";
import router from "../../../router/index";
import $ from 'jquery';

export default{
    components:{
        ContentField,
    },
    setup(){
        const store = useStore();
        let competitionProblems = ref([]);
        let error_message = ref('');
        
        const getlist_competitionProblem=() => {
            $.ajax({
                url: "http://127.0.0.1:3000/api/competition/problem/getlist/",
                data: {
                    competition_id: store.state.problem.competitionId,
                },
                type: "get",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    competitionProblems.value = resp;
                    error_message = "success";
                },
                error(resp) {
                    console.log(resp);
                }
            })
        }
        getlist_competitionProblem();

        const update_competitionProblem = competitionProblem =>{
            store.commit("updateCompetitionProblem",competitionProblem);
            router.push({ name: "competition_problem_update" });
        }
        const remove_competitionProblem = competitionProblem =>{
             $.ajax({
                url:"http://127.0.0.1:3000/api/competition/problem/remove/",
                type:"post",
                data:{
                    competition_problem_id:competitionProblem.id,
                },
                headers:{
                    Authorization: "Bearer "+store.state.user.token,
                },
                success(resp){
                    if(resp.error_message === "success"){
                        getlist_competitionProblem();
                    }               
                }
            })
        }
        return {
            competitionProblems,
            error_message,
            update_competitionProblem,
            remove_competitionProblem,
        }
    }
}
</script>

<style  scoped>

</style>