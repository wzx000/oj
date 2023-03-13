package com.oj.backend.controller.problem;

import com.oj.backend.service.problem.UpdateProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateProblemController {
    @Autowired
    private UpdateProblemService updateProblemService;
    @PostMapping("/api/problem/update/")
    public Map<String,String>updateProblem(@RequestParam Map<String,String>data){
        return updateProblemService.updateProblem(data);
    }
}
