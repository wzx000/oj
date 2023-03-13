package com.oj.backend.controller.competition;

import com.oj.backend.service.competition.UpdateCompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateCompetitionController {
    @Autowired
    private UpdateCompetitionService updateCompetitionService;
    @PostMapping("/api/competition/update/")
    public Map<String,String>updateCompetittion(@RequestParam Map<String,String>data){
        return updateCompetitionService.updateCompetition(data);
    }
}
