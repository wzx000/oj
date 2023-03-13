package com.oj.backend.controller.problem;

import com.alibaba.fastjson2.JSONObject;
import com.oj.backend.service.problem.GetListProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class GetListProblemController {
    @Autowired
    private GetListProblemService getListProblemService;
    @GetMapping("/api/problem/getlist/")
    public JSONObject getListProblem(@RequestParam MultiValueMap<String,String> data){
        Integer page = Integer.parseInt(Objects.requireNonNull(data.getFirst("page")));
        return getListProblemService.getListProblem(page);
    }
}
