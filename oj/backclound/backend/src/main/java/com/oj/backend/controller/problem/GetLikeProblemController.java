package com.oj.backend.controller.problem;

import com.alibaba.fastjson2.JSONObject;
import com.oj.backend.service.problem.GetLikeProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
public class GetLikeProblemController {
    @Autowired
    private GetLikeProblemService getLikeProblemService;
    @GetMapping("/api/problem/getlike/")
    public JSONObject getLikeProblem(
            @RequestParam MultiValueMap<String,String> data,
            @RequestParam Map<String,String>map
    ){
        Integer page=Integer.parseInt(Objects.requireNonNull(data.getFirst("page")));
        return getLikeProblemService.getLikeProblem(page,map);
    }
}
