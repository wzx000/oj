package com.oj.backend.controller.competition;

import com.alibaba.fastjson2.JSONObject;
import com.oj.backend.service.competition.GetListCompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class GetListCompetitionController {
    @Autowired
    private GetListCompetitionService getListCompetitionService;
    @GetMapping("/api/competition/getlist/")
    public JSONObject updateCompetition(@RequestParam MultiValueMap<String,String> data){
        Integer page = Integer.parseInt(Objects.requireNonNull(data.getFirst("page")));
        return getListCompetitionService.getListCompetition(page);
    }
}
