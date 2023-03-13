package com.oj.backend.controller.competition;

import com.oj.backend.service.competition.RemoveCompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RemoveCompetitionController {
    @Autowired
    private RemoveCompetitionService removeCompetitionService;
    @PostMapping("/api/competition/remove/")
    public Map<String,String>removeCompetition(@RequestParam Map<String,String>data){
        return removeCompetitionService.removeCompetition(data);
    }
}
