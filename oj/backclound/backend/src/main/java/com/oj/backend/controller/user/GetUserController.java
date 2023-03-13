package com.oj.backend.controller.user;

import com.oj.backend.service.user.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetUserController {
    @Autowired
    private GetUserService getUserService;
    @GetMapping("/api/user/get/")
    public Map<String,String> getUser(@RequestParam Map<String,String>data){
        return getUserService.getUser(data);
    }
}
