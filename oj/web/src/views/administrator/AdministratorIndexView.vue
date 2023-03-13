<template>
    <ContentField>    
        <router-link :to="{name: 'administrator_user'}" role="button">
            用户数据
        </router-link>
    </ContentField>
    <ContentField>
        <router-link :to="{name: 'administrator_title'}" role="button">
                  题库数据
        </router-link>
    </ContentField>
    <ContentField>
        <router-link :to="{name: 'administrator_competition'}" role="button">
                比赛数据
        </router-link>
    </ContentField>
</template>

<script>
import ContentField from "../../components/ContentField.vue";
export default{
    components:{
        ContentField,
    },
}
</script>

<style scoped>
div{
    text-align: center;
}
</style>