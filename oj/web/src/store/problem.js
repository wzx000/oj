export default {
    state: {
        id: "",
        number: "",
        title: "",
        type: "",
        score: "",
        topicDescription: "",
        inputDescription: "",
        outputDescription: "",
        exampleOneInput: "",
        exampleOneOutput: "",
        exampleTwoInput: "",
        exampleTwoOutput: "",
        exampleThreeInput: "",
        exampleThreeOutput: "",
        link: "",
        competitionId: "",
        competitionName: "",
        competitionDetails: "",
        competitionProblemNumber: "",
    },
    getters: {},
    mutations: {
        updateProblem(state, problem) {
            state.id = problem.id;
            state.number = problem.number;
            state.title = problem.title;
            state.type = problem.type;
            state.topicDescription = problem.topicDescription;
            state.inputDescription = problem.inputDescription;
            state.outputDescription = problem.outputDescription;
            state.exampleOneInput = problem.exampleOneInput;
            state.exampleOneOutput = problem.exampleOneOutput;
            state.exampleTwoInput = problem.exampleTwoInput;
            state.exampleTwoOutput = problem.exampleTwoOutput;
            state.exampleThreeInput = problem.exampleThreeInput;
            state.exampleThreeOutput = problem.exampleThreeOutput;
            state.link = problem.link;
        },
        updateCompetitionProblem(state,problem){
            state.id = problem.id;
            state.number = problem.number;
            state.title = problem.title;
            state.type = problem.type;
            state.score = problem.score;
            state.topicDescription = problem.topicDescription;
            state.inputDescription = problem.inputDescription;
            state.outputDescription = problem.outputDescription;
            state.exampleOneInput = problem.exampleOneInput;
            state.exampleOneOutput = problem.exampleOneOutput;
            state.exampleTwoInput = problem.exampleTwoInput;
            state.exampleTwoOutput = problem.exampleTwoOutput;
            state.exampleThreeInput = problem.exampleThreeInput;
            state.exampleThreeOutput = problem.exampleThreeOutput;
        },
        removeProblem(state){
            state.id = "";
            state.number = "";
            state.title = "";
            state.type = "";
            state.topicDescription = "";
            state.inputDescription = "";
            state.outputDescription ="";
            state.exampleOneInput = "";
            state.exampleOneOutput = "";
            state.exampleTwoInput = "";
            state.exampleTwoOutput = "";
            state.exampleThreeInput = "";
            state.exampleThreeOutput = "";
            state.link = "";
        },
        setCompetitionId(state,competitionId){
            state.competitionId=competitionId;
        },
        setCompetitionName(state,competitionName){
            state.competitionName=competitionName;
        },
        setCompetitionDetails(state,competitionDetails){
            state.competitionDetails=competitionDetails;
        },
        setCompetitionProblemNumber(state,competitionProblemNumber){
            state.competitionProblemNumber = competitionProblemNumber;
        }
    },
    modules: {}
}
