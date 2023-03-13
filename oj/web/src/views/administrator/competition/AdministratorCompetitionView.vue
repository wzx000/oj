<template>
    <ContentField>    
        <router-link :to="{name: 'competition_add'}" role="button">
            添加比赛
        </router-link>
    </ContentField>
    <ContentField>
        <table class="table table-striped table-hover" style="text-align: center;">
            <thead>
                <tr>
                    <th>比赛</th>
                    <th>类型</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="competition in competitions" :key="competition.id">
                    <td>{{ competition.gameName }}</td>
                    <td>{{ competition.gameType }}</td>
                    <td>
                        <button type="button" class="btn btn-secondary" style="margin-right: 10px;" @click="update_competition(competition)">修改</button>
                        <button type="button" class="btn btn-danger"  @click="remove_competition(competition)">删除</button>
                    </td>
                </tr>
            </tbody>
        </table>
        <nav aria-label="...">
        <ul class="pagination" style="float: right;">
            <li class="page-item" @click="click_page(-2)">
                <a class="page-link" href="#">前一页</a>
            </li>
            <li :class="'page-item ' + page.is_active" v-for="page in pages" :key="page.number" @click="click_page(page.number)">
                <a class="page-link" href="#">{{ page.number }}</a>
            </li>
            <li class="page-item" @click="click_page(-1)">
                <a class="page-link" href="#">后一页</a>
            </li>
        </ul>
        </nav>
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
    setup() {
        const store = useStore();
        let competitions = ref([]);
        let current_page = 1;
        let total_competitions = 0;
        let pages = ref([]);

        const click_page = page => {
            if (page === -2) page = current_page - 1;
            else if (page === -1) page = current_page + 1;
            let max_pages = parseInt(Math.ceil(total_competitions / 10));

            if (page >= 1 && page <= max_pages) {
                pull_page(page);
            }
        }

        const udpate_pages = () => {
            let max_pages = parseInt(Math.ceil(total_competitions / 10));
            let new_pages = [];
            for (let i = current_page - 2; i <= current_page + 2; i ++ ) {
                if (i >= 1 && i <= max_pages) {
                    new_pages.push({
                        number: i,
                        is_active: i === current_page ? "active" : "",
                    });
                }
            }
            pages.value = new_pages;
        }

        const pull_page = page => {
            current_page = page;
            $.ajax({
                url: "http://127.0.0.1:3000/api/competition/getlist/",
                data: {
                    page,
                },
                type: "get",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    competitions.value = resp.competitions;
                    total_competitions = resp.competitions_count;
                }
            });
        }

        pull_page(current_page);

        const update_competition = competition =>{
            store.commit("setCompetitionId",competition.id); 
            router.push({name: "competition_problem_index"});
        }
        const remove_competition = competition =>{
             $.ajax({
                url:"http://127.0.0.1:3000/api/competition/remove/",
                type:"post",
                data:{
                    competition_id:competition.id,
                },
                headers:{
                    Authorization: "Bearer "+store.state.user.token,
                },
                success(resp){
                    if(resp.error_message === "success"){
                        udpate_pages();
                        pull_page(current_page);
                    }               
                }
            })
        }
        return {
            competitions,
            pages,
            click_page,
            update_competition,
            remove_competition,
        }
    }
}
</script>

<style scoped>
</style>