package com.oj.backend.controller.competition;

import com.oj.backend.service.competition.AddCompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddCompetitionController {
    @Autowired
    private AddCompetitionService addCompetitionService;
    @PostMapping("/api/competition/add/")
    public Map<String,String>addCompetition(@RequestParam Map<String,String>data){
        return addCompetitionService.addCompetition(data);
    }
}
