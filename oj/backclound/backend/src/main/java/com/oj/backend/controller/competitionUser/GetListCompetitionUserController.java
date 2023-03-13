package com.oj.backend.controller.competitionUser;

import com.alibaba.fastjson2.JSONObject;
import com.oj.backend.service.competittionUser.GetListCompetitionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class GetListCompetitionUserController {
    @Autowired
    private GetListCompetitionUserService getListCompetitionUserService;
    @GetMapping("/api/competition/user/getlist/")
    public JSONObject getListCompetitionUser(@RequestParam MultiValueMap<String,String> data){
        Integer page = Integer.parseInt(Objects.requireNonNull(data.getFirst("page")));
        return getListCompetitionUserService.getListCompetitionUser(page,data);
    }
}
