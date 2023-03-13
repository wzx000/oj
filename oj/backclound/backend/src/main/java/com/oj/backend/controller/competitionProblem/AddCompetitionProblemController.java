package com.oj.backend.controller.competitionProblem;

import com.oj.backend.service.competitionProblem.AddCompetitionProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddCompetitionProblemController {
    @Autowired
    private AddCompetitionProblemService addCompetitionProblemService;
    @PostMapping("/api/competition/problem/add/")
    public Map<String,String>addCompetitionProblem(@RequestParam Map<String,String>data){
        return addCompetitionProblemService.addCompetitionProblem(data);
    }
}
