package com.oj.backend.controller.problem;

import com.oj.backend.pojo.Problem;
import com.oj.backend.service.problem.GetProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetProblemController {
    @Autowired
    private GetProblemService getProblemService;
    @GetMapping("/api/problem/get/")
    public List<Problem>getProblem(@RequestParam Map<String,String>data){
        return getProblemService.getProblem(data);
    }
}
