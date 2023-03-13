<template>
    <NavCom></NavCom>
    <ContentField>
        {{ $store.state.problem.competitionDetails }}
    </ContentField>
</template>

<script>
import NavCom from "../../components/competition/NavCom.vue";
import ContentField from "../../components/ContentField.vue"
export default{
    components:{
        NavCom,
        ContentField,
    }

}

</script>

<style scoped>

</style>