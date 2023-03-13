package com.oj.backend.controller.user;

import com.oj.backend.service.user.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RemoveController {
    @Autowired
    private RemoveService removeService;
    @PostMapping("/api/user/remove/")
    public Map<String,String>remove(@RequestParam Map<String,String>data){
        return removeService.remove(data);
    }
}
