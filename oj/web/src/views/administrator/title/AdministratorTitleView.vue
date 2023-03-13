<template>
    <ContentField>    
        <router-link :to="{name: 'problem_add'}" role="button">
            添加题目
        </router-link>
    </ContentField>
    <ContentField>
        <ProblemGetView></ProblemGetView> 
    </ContentField>
</template>

<script>
import ContentField from "../../../components/ContentField.vue";
import ProblemGetView from "../../problem/ProblemGetView.vue";

export default{
    components:{
        ContentField,
        ProblemGetView,
    },
}
</script>

<style scoped>
</style>