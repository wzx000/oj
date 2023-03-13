package com.oj.backend.service.impl.problem;

import com.oj.backend.mapper.ProblemMapper;
import com.oj.backend.pojo.Problem;
import com.oj.backend.service.problem.RemoveProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveProblemServiceImpl implements RemoveProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public Map<String, String> removeProblem(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();
        problemMapper.deleteById(data.get("problem_id"));
        map.put("error_message", "success");
        return map;
    }
}
