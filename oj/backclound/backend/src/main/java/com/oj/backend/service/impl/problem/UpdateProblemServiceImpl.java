package com.oj.backend.service.impl.problem;

import com.oj.backend.mapper.ProblemMapper;
import com.oj.backend.pojo.Problem;
import com.oj.backend.service.problem.UpdateProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateProblemServiceImpl implements UpdateProblemService {
    @Autowired
    private ProblemMapper problemMapper;
    @Override
    public Map<String, String> updateProblem(Map<String, String> data) {
        Map<String,String> map = new HashMap<>();
        Integer number = Integer.parseInt(data.get("number"));
        String title = data.get("title");
        String type = data.get("type");
        String topicDescription = data.get("topicDescription");
        String inputDescription = data.get("inputDescription");
        String outputDescription = data.get("outputDescription");
        String exampleOneInput = data.get("exampleOneInput");
        String exampleOneOutput = data.get("exampleOneOutput");
        String exampleTwoInput = data.get("exampleTwoInput");
        String exampleTwoOutput = data.get("exampleTwoOutput");
        String exampleThreeInput = data.get("exampleThreeInput");
        String exampleThreeOutput = data.get("exampleThreeOutput");
        String link = data.get("link");
        Problem problem=problemMapper.selectById(data.get("problem_id"));
        Date now =new Date();
        Problem now_problem=new Problem(
                problem.getId(),
                number,
                title,
                type,
                number.toString()+title+type,
                topicDescription,
                inputDescription,
                outputDescription,
                exampleOneInput,
                exampleOneOutput,
                exampleTwoInput,
                exampleTwoOutput,
                exampleThreeInput,
                exampleThreeOutput,
                link,
                now
        );
        problemMapper.updateById(now_problem);
        map.put("error_message", "success");
        return map;
    }
}
