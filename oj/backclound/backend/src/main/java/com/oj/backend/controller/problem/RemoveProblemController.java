package com.oj.backend.controller.problem;

import com.oj.backend.service.problem.RemoveProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RemoveProblemController {
    @Autowired
    private RemoveProblemService removeProblemService;

    @PostMapping("/api/problem/remove/")
    public Map<String,String> removeProblem(@RequestParam Map<String,String>data){
        return removeProblemService.removeProblem(data);
    }
}
