<template>
    <NavCom></NavCom>
    <ContentField>
        <table class="table table-striped table-hover" style="text-align: center;">
            <thead>
                <tr>
                    <th>名次</th>
                    <th>用户</th>
                    <th>总分</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr v-for="competitionUser in competitionUsers" :key="competitionUser.id">
                    <td>
                        {{ competitionUser.rating }}
                    </td>
                    <td>
                        <img :src="competitionUser.user_photo" alt="" class="user-photo">
                        &nbsp;
                        {{ competitionUser.user_name }}
                    </td>
                    <td>
                        {{ competitionUser.score }}
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
import NavCom from "../../components/competition/NavCom.vue";
import ContentField from "../../components/ContentField.vue";
import { useStore } from "vuex";
import { ref } from "vue";
import $ from 'jquery';

export default{
    components:{
        NavCom,
        ContentField,
    },
    setup() {
        const store = useStore();
        let competitionUsers = ref([]);
        let current_page = 1;
        let total_competitionUsers = 0;
        let pages = ref([]);
        let error_message = ref('');

        const click_page = page => {
            if (page === -2) page = current_page - 1;
            else if (page === -1) page = current_page + 1;
            let max_pages = parseInt(Math.ceil(total_competitionUsers / 10));

            if (page >= 1 && page <= max_pages) {
                pull_page(page);
            }
        }
        const udpate_pages = () => {
            let max_pages = parseInt(Math.ceil(total_competitionUsers / 10));
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
                url: "http://127.0.0.1:3000/api/competition/user/getlist/",
                data: {
                    page,
                    competition_id: store.state.problem.competitionId,
                },
                type: "get",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    competitionUsers.value = resp.competitionUsers;
                    total_competitionUsers = resp.competitionUsers_count;
                    udpate_pages();
                    

                    for (let index = 0; index < competitionUsers.value.length; index++) {
                        const competitionUser = competitionUsers.value[index];
                        $.ajax({
                            url: "http://127.0.0.1:3000/api/user/get/",
                            data: {
                                user_id:competitionUser.userId,
                            },
                            type: "get",
                            headers: {
                                Authorization: "Bearer " + store.state.user.token,
                            },
                            success(resp) {
                                competitionUsers.value[index]["rating"]=index+1;
                                competitionUsers.value[index]["user_name"]=resp.name;
                                competitionUsers.value[index]["user_photo"]=resp.photo;
                            }
                        });
                        
                    }


                }
            });
            
        }

        pull_page(current_page);

        return {
            competitionUsers,
            pages,
            error_message,
            click_page,
        }
    }
}
</script>

<style scoped>
img.user-photo {
    width: 4vh;
    border-radius: 50%;
}

</style>