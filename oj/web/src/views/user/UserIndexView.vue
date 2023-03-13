<template>
    <div class="container">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-5">
                <div class="card">
                    <div class="card-body">
                        <div class="personal-information">
                            <div><span class="txt">用户：</span>{{ $store.state.user.username}}</div>
                            <div><span class="txt">学校: </span>&nbsp; 黑河学院</div>
                            <div><span class="txt">学号：</span>{{ $store.state.user.studentId }}</div>
                            <div><span class="txt">QQ号：</span>{{ $store.state.user.qq }}</div>
                            <div><span class="txt">手机号：</span>{{ $store.state.user.telephone }}</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <div class="card">
                    <div class="card-body">
                        <img :src="$store.state.user.photo">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-2"></div>
    </div>
    <ContentField>
        <div>近期参赛</div>

    </ContentField>
</template>

<script>
import ContentField from "../../components/ContentField.vue";

export default{
    components:{
        ContentField,
    }
}
</script>
<style scoped>
div{
    text-align: left;
}
div.personal-information{
    line-height:327%;
}
div.container{
    padding-top: 20px;
}
span.txt{
    font-weight:600;
    font-size:x-large;
}
img{
    width: 100%;
    border-radius: 50% ;
}
</style>