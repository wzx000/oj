package com.oj.backend.service.impl.competitionProblem;

import com.oj.backend.mapper.CompetitionProblemMapper;
import com.oj.backend.service.competitionProblem.RemoveCompetitionProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveCompetitionProblemServiceImpl implements RemoveCompetitionProblemService {
    @Autowired
    private CompetitionProblemMapper competitionProblemMapper;
    @Override
    public Map<String, String> removeCompetitionProblem(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();
        competitionProblemMapper.deleteById(data.get("competition_problem_id"));
        map.put("error_message", "success");
        return map;
    }
}
