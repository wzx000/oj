<template>
    <ContentField>
        <form @submit.prevent="update">
                    <div class="mb-3">
                        <label for="number" class="form-label">题号</label>
                        <input v-model="number" type="text" class="form-control" id="number">
                    </div>
                    <div class="mb-3">
                        <label for="title" class="form-label">题目</label>
                        <input v-model="title" type="text" class="form-control" id="title">
                    </div>
                    <div class="mb-3">
                        <label for="type" class="form-label">类型</label>
                        <input v-model="type" type="text" class="form-control" id="type">
                    </div>
                    <div class="mb-3">
                        <label for="score" class="form-label">分数</label>
                        <input v-model="score" type="text" class="form-control" id="score">
                    </div>
                    <div class="mb-3">
                        <label for="topicDescription" class="form-label">题目描述</label>
                        <textarea v-model="topicDescription" rows="3" class="form-control" id="topicDescription"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="inputDescription" class="form-label">输入描述</label>
                        <textarea v-model="inputDescription" rows="1" class="form-control" id="inputDescription"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="outputDescription" class="form-label">输出描述</label>
                        <textarea v-model="outputDescription" rows="1" class="form-control" id="outputDescription"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="exampleOneInput" class="form-label">样例一输入</label>
                        <textarea v-model="exampleOneInput" rows="1" class="form-control" id="exampleOneInput"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="exampleOneOutput" class="form-label">样例一输出</label>
                        <textarea v-model="exampleOneOutput" rows="1" class="form-control" id="exampleOneOutput"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="exampleTwoInput" class="form-label">样例二输入</label>
                        <textarea v-model="exampleTwoInput" rows="1" class="form-control" id="exampleTwoInput"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="exampleTwoOutput" class="form-label">样例二输出</label>
                        <textarea v-model="exampleTwoOutput" rows="1" class="form-control" id="exampleTwoOutput"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="exampleThreeInput" class="form-label">样三输入</label>
                        <textarea v-model="exampleThreeInput" rows="1" class="form-control" id="exampleThreeInput"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="exampleThreeOutput" class="form-label">样例三输出</label>
                        <textarea v-model="exampleThreeOutput" rows="1" class="form-control" id="exampleThreeOutput"></textarea>
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
import ContentField from "../../../components/ContentField.vue";
import { useStore } from 'vuex';
import { ref } from 'vue';
import router from "../../../router/index";
import $ from 'jquery';

export default{
    components: {
        ContentField,
    },
    setup() {
        const store = useStore();
        let number = ref(store.state.problem.number);
        let title = ref(store.state.problem.title);
        let type = ref(store.state.problem.type);
        let score = ref(store.state.problem.score);
        let topicDescription = ref(store.state.problem.topicDescription);
        let inputDescription = ref(store.state.problem.inputDescription);
        let outputDescription = ref(store.state.problem.outputDescription);
        let exampleOneInput = ref(store.state.problem.exampleOneInput);
        let exampleOneOutput = ref(store.state.problem.exampleOneOutput);
        let exampleTwoInput = ref(store.state.problem.exampleTwoInput);
        let exampleTwoOutput = ref(store.state.problem.exampleTwoOutput);
        let exampleThreeInput = ref(store.state.problem.exampleThreeInput);
        let exampleThreeOutput = ref(store.state.problem.exampleThreeOutput);
        let error_message = ref('');
        

        const update = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/api/competition/problem/update/",
                type: "post",
                data: {
                    competition_problem_id: store.state.problem.id,
                    competition_id: store.state.problem.competitionId,
                    number: number.value,
                    title: title.value,
                    type: type.value,
                    score: score.value,
                    topicDescription: topicDescription.value,
                    inputDescription: inputDescription.value,
                    outputDescription: outputDescription.value,
                    exampleOneInput: exampleOneInput.value,
                    exampleOneOutput: exampleOneOutput.value,
                    exampleTwoInput: exampleTwoInput.value,
                    exampleTwoOutput: exampleTwoOutput.value,
                    exampleThreeInput: exampleThreeInput.value,
                    exampleThreeOutput: exampleThreeOutput.value,
                },
                headers:{
                    Authorization: "Bearer "+store.state.user.token,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        store.commit("removeProblem");
                        router.push({name: "competition_problem_index"});
                    } else {
                        error_message.value = resp.error_message;
                        console.log("error");
                    }
                },
            });
        }

        return {
            number,
            title,
            type,
            score,
            topicDescription,
            inputDescription,
            outputDescription,
            exampleOneInput,
            exampleOneOutput,
            exampleTwoInput,
            exampleTwoOutput,
            exampleThreeOutput,
            exampleThreeInput,
            error_message,
            update,
        }
    }
}
</script>

<style scoped>
button {
    width: 100%;
}
div.error-message {
    color: red;
}
</style>
