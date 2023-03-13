package com.oj.backend.service.problem;

import com.alibaba.fastjson2.JSONObject;


public interface GetListProblemService {
    JSONObject getListProblem(Integer page);
}
