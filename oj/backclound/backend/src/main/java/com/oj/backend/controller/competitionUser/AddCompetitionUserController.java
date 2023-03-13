package com.oj.backend.controller.competitionUser;

import com.oj.backend.service.competittionUser.AddCompetitionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddCompetitionUserController {
    @Autowired
    private AddCompetitionUserService addCompetitionUserService;
    @PostMapping("/api/competition/user/add/")
    public Map<String ,String>addCompetitionUser(@RequestParam Map<String,String>data){
        return addCompetitionUserService.addCompetitionUser(data);
    }
}
