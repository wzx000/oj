<template>
    <ContentField>
        <form @submit.prevent="add">
                <div class="mb-3">
                    <label for="gameName" class="form-label">名称</label>
                    <input v-model="gameName" type="text" class="form-control" id="gameName">
                </div>
                <div class="mb-3">
                    <label for="gameType" class="form-label">类型</label>
                    <input v-model="gameType" type="text" class="form-control" id="gameType">
                </div>
                <div class="mb-3">
                    <label for="details" class="form-label">详情</label>
                    <input v-model="details" type="text" class="form-control" id="details">
                </div>
                <div class="mb-3">
                    <label for="startTime" class="form-label">开始时间</label>
                    <input v-model="startTime" type="text" class="form-control" id="startTime">
                </div>
                <div class="mb-3">
                    <label for="endTime" class="form-label">结束时间</label>
                    <input v-model="endTime" type="text" class="form-control" id="endTime">
                </div>
                <div class="error-message">{{ error_message }}</div>
                    <div class="row">
                        <div class="col-3"></div>
                        <div class="col-3">
                            <button type="submit" class="btn btn-primary">提交</button>
                        </div>
                        <div class="col-3"></div>
                    </div>
        </form>
    </ContentField>
    
</template>

<script>
import ContentField from "../../components/ContentField.vue";
import { useStore } from "vuex";
import { ref } from "vue";
import router from "../../router";
import $ from 'jquery';

export default{
    components:{
        ContentField,
    },
    setup(){
        const store = useStore();
            let gameName =  ref('');
            let gameType = ref('');
            let details = ref('');
            let startTime = ref('');
            let endTime = ref('');
            let error_message = ref('');
        const add = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/api/competition/add/",
                type: "post",
                data: {
                    game_name:gameName.value,
                    game_type:gameType.value,
                    details :details.value,
                    start_time:startTime.value,
                    end_time:endTime.value,
                },
                headers:{
                    Authorization: "Bearer "+store.state.user.token,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        store.commit("setCompetitionId",resp.competition_id);
                        router.push({name: "competition_problem_index"});
                    } else {
                        error_message.value = resp.error_message;
                        console.log("error");
                    }
                },
            });
        }
        return {
            add,
            gameName,
            gameType,
            details,
            startTime,
            endTime,
        }
    }
}
</script>

<style scoped>
</style>