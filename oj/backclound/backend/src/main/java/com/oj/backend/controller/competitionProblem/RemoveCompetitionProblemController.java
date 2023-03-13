package com.oj.backend.controller.competitionProblem;

import com.oj.backend.service.competitionProblem.RemoveCompetitionProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RemoveCompetitionProblemController {
    @Autowired
    private RemoveCompetitionProblemService removeCompetitionProblemService;
    @PostMapping("/api/competition/problem/remove/")
    public Map<String,String>removeCompetitionProblem(@RequestParam Map<String,String>data){
        return removeCompetitionProblemService.removeCompetitionProblem(data);
    }
}
