package com.oj.backend.controller.competitionProblem;

import com.oj.backend.pojo.CompetitionProblem;
import com.oj.backend.service.competitionProblem.GetListCompetitionProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetListCompetitionProblemController {
    @Autowired
    private GetListCompetitionProblemService getListCompetitionProblemService;
    @GetMapping("/api/competition/problem/getlist/")
    public List<CompetitionProblem> getListCompetitionProblem(@RequestParam Map<String,String>data){
        return getListCompetitionProblemService.getListCompetitionProblem(data);
    }
}
