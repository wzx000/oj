package com.oj.backend.service.problem;

import com.alibaba.fastjson2.JSONObject;

import java.util.Map;

public interface GetLikeProblemService {
    JSONObject getLikeProblem(Integer page, Map<String ,String >data);
}
