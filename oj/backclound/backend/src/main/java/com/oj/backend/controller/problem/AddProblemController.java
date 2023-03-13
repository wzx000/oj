package com.oj.backend.controller.problem;

import com.oj.backend.service.problem.AddProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Map;

@RestController
public class AddProblemController {

    @Autowired
    private AddProblemService addProblemService;

    @PostMapping("/api/problem/add/")
    public Map<String,String> addProblem(@RequestParam Map<String,String>data){
        return addProblemService.addProblem(data);
    }
}
