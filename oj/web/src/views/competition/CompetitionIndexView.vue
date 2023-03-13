<template>
     <ContentField>
        <table class="table table-striped table-hover" style="text-align: center;">
            <thead>
                <tr>
                    <th>标题</th>
                    <th>类型</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="competition in competitions" :key="competition.id">
                    <td>
                        <div @click="click_competition(competition)">
                            {{ competition.gameName }}
                        </div>
                    </td>
                    <td>
                        <div @click="click_competition(competition)">
                            {{ competition.gameType }}
                        </div>
                    </td>
                    <td>
                        <div @click="click_competition(competition)">
                            {{ competition.startTime }}
                        </div>
                    </td>
                    <td>
                        <div @click="click_competition(competition)">
                            {{ competition.endTime }}
                        </div>
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
import ContentField from "../../components/ContentField.vue";
import { useStore } from "vuex";
import { ref } from "vue";
import router from "../../router/index";
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
        let error_message = ref('');
        const click_page = page => {
            if (page === -2) page = current_page - 1;
            else if (page === -1) page = current_page + 1;
            let max_pages = parseInt(Math.ceil(total_competitions / 10));

            if (page >= 1 && page <= max_pages) {
                pull_page(page);
            }
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
        const click_competition = competition =>{
            store.commit("setCompetitionId",competition.id);
            store.commit("setCompetitionName",competition.gameName);
            store.commit("setCompetitionDetails",competition.details);
            $.ajax({
                url: "http://127.0.0.1:3000/api/competition/user/add/",
                data: {
                    competition_id: competition.id,
                    user_id: store.state.user.id,
                },
                type: "post",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    error_message.value = resp.error_message;
                },
                error(resp){
                    console.log(resp);
                }
            });
            router.push({ name: 'competition_overview' });
        }

        return {
            competitions,
            pages,
            error_message,
            click_page,
            click_competition,
        }
    }

}
</script>

<style scoped>

</style>