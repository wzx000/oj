<template>
    <NavCom></NavCom>
    <ContentField>
        <table class="table table-striped table-hover" style="text-align: center;">
            <thead>
                <tr>
                    <th>#</th>
                    <th>标题</th>
                    <th>时间限制</th>
                    <th>空间限制</th>
                </tr>
            </thead>
            <tbody>    
                <tr v-for="competitionProblem in competitionProblems" :key="competitionProblem.id">
                    <td>
                        <div @click="click_competitionProblem(competitionProblem)">
                        {{ competitionProblem.number }}
                        </div>
                    </td>
                    <td>
                        <div @click="click_competitionProblem(competitionProblem)">
                        {{ competitionProblem.title }}
                        </div>
                    </td>
                    <td>
                        <div @click="click_competitionProblem(competitionProblem)">
                        
                        </div>
                    </td>
                    <td>
                        <div @click="click_competitionProblem(competitionProblem)">
                        
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </ContentField>

</template>

<script>
import NavCom from "../../../components/competition/NavCom.vue";
import ContentField from "../../../components/ContentField.vue";
import { useStore } from "vuex";
import { ref } from "vue";
import $ from 'jquery';
import router from "../../../router";

export default{
    components:{
        NavCom,
        ContentField,
    },
    setup(){
        const store = useStore();
        let competitionProblems = ref([]);
        let error_message = ref('');

        const getlist_competitionProblem = () => {
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
                    store.commit("setCompetitionProblemNumber",competitionProblems.value.length);
                    error_message = "success";
                },
                error(resp) {
                    console.log(resp);
                }
            })
        }
        getlist_competitionProblem();
        const click_competitionProblem = competitionProblem =>{
            store.commit("updateCompetitionProblem",competitionProblem);
            router.push({ name: 'competition_problem' });
        }
        return {
            competitionProblems,
            error_message,
            click_competitionProblem,
        }
    }

}
</script>

<style scoped>

</style>