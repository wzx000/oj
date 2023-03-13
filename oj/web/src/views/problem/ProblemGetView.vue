<template>
    <form @submit.prevent="search">
        <label for="name" class="form-label">查找题目</label>
        <input v-model="name" type="text" class="form-control" id="name" placeholder="请输入题目">
        <button type="submit" class="btn btn-primary">搜索</button>
    </form>
    <ContentField v-if="error_message === 'success'">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>名称</th>
                    <th>操作</th>
                 </tr>
            </thead>
            <tbody>
                <tr v-for="problem in problems" :key="problem.id">
                    <td>{{ problem.title }}</td>
                    <td>
                        <button type="button" class="btn btn-secondary" style="margin-right: 10px;" @click="update_problem(problem)">修改</button>
                        <button type="button" class="btn btn-danger"  @click="remove_problem(problem)">删除</button>
                            
                    </td>
                </tr>
            </tbody>
        </table>    
    </ContentField>
    

</template>

<script>
import ContentField from '../../components/ContentField.vue'
import { ref } from 'vue';
import { useStore } from 'vuex';
import $ from 'jquery';
import router from '../../router/index';

export default{
    components:{
        ContentField,
    },
    setup(){
        const store = useStore();
        let name = ref('');
        let error_message = ref('');
        let problems = ref([]);
        const search= () => {
            
            $.ajax({
                url: "http://127.0.0.1:3000/api/problem/get/",
                type: "get",
                data: {
                    name: name.value,
                },
                headers:{
                    Authorization: "Bearer "+store.state.user.token,
                },
                success(resp) {     
                    problems.value = resp;
                    error_message.value = "success";
                },
            });
        }
        const update_problem= (problem) =>{
            store.commit("updateProblem",problem);
            router.push({ name: 'problem_update' });
        }
        const remove_problem=(problem)=> {
            $.ajax({
                url:"http://127.0.0.1:3000/api/problem/remove/",
                type:"post",
                data:{
                    problem_id:problem.id,
                },
                headers:{
                    Authorization: "Bearer "+store.state.user.token,
                },
            })
        }
        return {
            search,
            remove_problem,
            update_problem,
            name,
            error_message,
            problems,
        }
    }
}
</script>

<style scoped>

</style>