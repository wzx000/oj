<template>
    <ContentField>
        <div style="
            color: black;
            font-size: x-large;
            background: transparent;
            padding-top: 24px;
            padding-left: 12px;
            padding-bottom: 24px;
            background-color: rgba(255,255,255,0.7);"
            >
            {{ $store.state.problem.title }}
        </div>
    </ContentField>
    
    
    <ContentField>
        <div class="TITLE">题目描述</div>
        <ContentFieldProblem>
            <div class="L">{{ $store.state.problem.topicDescription }}</div>
        </ContentFieldProblem>

        <div class="TITLE">输入描述</div>
        <ContentFieldProblem>
            <div class="L">{{ $store.state.problem.inputDescription }}</div>
        </ContentFieldProblem>
        

        <div class="TITLE">输出描述</div>
        <ContentFieldProblem>
            <div class="L">{{ $store.state.problem.outputDescription }}</div>
        </ContentFieldProblem>

        <div  v-if="$store.state.problem.exampleOneOutput !==''">
            <div class="TITLE">样例1</div>
            <ContentFieldProblem>
                <div class="TITLE" style="margin-top: 0%;">输入</div>
                <ContentFieldProblem>
                    <div class="L">{{ $store.state.problem.exampleOneInput }}</div>
                </ContentFieldProblem>
                <div class="TITLE">输出</div>
                <ContentFieldProblem>
                    <div class="L">{{ $store.state.problem.exampleOneOutput }}</div>
                </ContentFieldProblem>
            </ContentFieldProblem>
        </div>

        <div  v-if="$store.state.problem.exampleTwoOutput !==''">
            <div class="TITLE">样例2</div>
            <ContentFieldProblem>
                <div class="TITLE" style="margin-top: 0%;">输入</div>
                <ContentFieldProblem>
                    <div class="L">{{ $store.state.problem.exampleTwoInput }}</div>
                </ContentFieldProblem>
                <div class="TITLE">输出</div>
                <ContentFieldProblem>
                    <div class="L">{{ $store.state.problem.exampleTwoOutput }}</div>
                </ContentFieldProblem>
            </ContentFieldProblem> 
        </div>
        
        

        <div v-if="$store.state.problem.exampleThreeOutput !== ''">
            <div class="TITLE">样例3</div>
            <ContentFieldProblem>
            <div class="TITLE" style="margin-top: 0%;">输入</div>
            <ContentFieldProblem>
                <div class="L">{{ $store.state.problem.exampleThreeInput }}</div>
            </ContentFieldProblem>
            <div class="TITLE">输出</div>
            <ContentFieldProblem>
                <div class="L">{{ $store.state.problem.exampleThreeOutput }}</div>
            </ContentFieldProblem>
        </ContentFieldProblem>
        </div>
        
        <div>
            <label class="form-label">代码编辑</label>
                <VAceEditor
                    @init="editorInit"
                    lang="c_cpp"
                    theme="textmate"
                    style="height: 200px" 
                    :value="code" 
                />
        </div>
        
        <button type="button" class="btn btn-primary"><a :href="$store.state.problem.link" target="_blank"><div style="color: white;">原题链接</div></a></button>
    </ContentField>
</template>

<script>
import ContentField from "../../../components/ContentField.vue";
import ContentFieldProblem from "../../../components/ContentFieldProblem.vue";
import { VAceEditor } from 'vue3-ace-editor';
import ace from 'ace-builds';

export default{
    components:{
        ContentField,
        ContentFieldProblem,
        VAceEditor,
    },
    setup(){
        ace.config.set(
            "basePath", 
            "https://cdn.jsdelivr.net/npm/ace-builds@" + require('ace-builds').version + "/src-noconflict/"
        )
        
    }
}
</script>

<style scoped>
div.TITLE{
    font-size: 14px;
    font-weight: 400;
    margin-bottom: 4px;
    margin-top: 16px;
    font-size: 16px;
    font-weight: 400;
}
div.L{
    font-size: 16px;
    font-weight: 300;
}
</style>