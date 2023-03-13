package com.oj.backend.controller.user;

import com.alibaba.fastjson2.JSONObject;
import com.oj.backend.service.user.GetlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class GetlistController {
    @Autowired
    private GetlistService getlistService;
    @GetMapping("/api/user/getlist/")
    public JSONObject getListProblem(@RequestParam MultiValueMap<String,String> data){
        Integer page = Integer.parseInt(Objects.requireNonNull(data.getFirst("page")));
        return getlistService.getlist(page);
    }
}
