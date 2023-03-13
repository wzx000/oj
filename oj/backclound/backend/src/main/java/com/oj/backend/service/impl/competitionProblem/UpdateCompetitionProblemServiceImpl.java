package com.oj.backend.service.impl.competitionProblem;

import com.oj.backend.mapper.CompetitionProblemMapper;
import com.oj.backend.pojo.CompetitionProblem;
import com.oj.backend.service.competitionProblem.UpdateCompetitionProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateCompetitionProblemServiceImpl implements UpdateCompetitionProblemService {
    @Autowired
    private CompetitionProblemMapper competitionProblemMapper;
    @Override
    public Map<String, String> updateCompetitionProblem(Map<String, String> data) {
        Map<String,String> map = new HashMap<>();
        Integer competitionId = Integer.parseInt(data.get("competition_id"));
        Integer number = Integer.parseInt(data.get("number"));
        String title = data.get("title");
        String type = data.get("type");
        Integer score = Integer.parseInt(data.get("score"));
        String topicDescription = data.get("topicDescription");
        String inputDescription = data.get("inputDescription");
        String outputDescription = data.get("outputDescription");
        String exampleOneInput = data.get("exampleOneInput");
        String exampleOneOutput = data.get("exampleOneOutput");
        String exampleTwoInput = data.get("exampleTwoInput");
        String exampleTwoOutput = data.get("exampleTwoOutput");
        String exampleThreeInput = data.get("exampleThreeInput");
        String exampleThreeOutput = data.get("exampleThreeOutput");

        CompetitionProblem competitionProblem=competitionProblemMapper.selectById(data.get("competition_problem_id"));
        CompetitionProblem now_competitionProblem= new CompetitionProblem(
                competitionProblem.getId(),
                competitionId,
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
                exampleThreeInput,
                exampleThreeOutput
        );
        competitionProblemMapper.updateById(now_competitionProblem);
        map.put("error_message", "success");
        return map;
    }
}
