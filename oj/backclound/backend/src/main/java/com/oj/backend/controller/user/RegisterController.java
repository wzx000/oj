package com.oj.backend.controller.user;

import com.oj.backend.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/api/user/register/")
    public Map<String, String> register(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        String confirmedPassword = map.get("confirmedPassword");
        Integer studentId = Integer.parseInt(map.get("studentId"));
        String qq = map.get("qq");
        String telephone = map.get("telephone");
        return registerService.register(username,password,confirmedPassword,studentId,qq,telephone);
    }
}