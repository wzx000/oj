package com.oj.backend.controller.competitionProblem;

import com.oj.backend.service.competitionProblem.UpdateCompetitionProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateCompetitionProblemController {
    @Autowired
    private UpdateCompetitionProblemService updateCompetitionProblemService;
    @PostMapping("/api/competition/problem/update/")
    public Map<String,String>updateCompetitionProblem(@RequestParam Map<String,String>data){
        return updateCompetitionProblemService.updateCompetitionProblem(data);
    }
}
