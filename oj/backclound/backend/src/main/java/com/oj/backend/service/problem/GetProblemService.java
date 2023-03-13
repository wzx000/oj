package com.oj.backend.service.problem;

import com.oj.backend.pojo.Problem;

import java.util.List;
import java.util.Map;

public interface GetProblemService {
    List<Problem> getProblem(Map<String ,String >data);
}
