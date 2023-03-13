package com.oj.backend.service.impl.user;

import com.oj.backend.mapper.UserMapper;
import com.oj.backend.pojo.User;
import com.oj.backend.service.user.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GetUserServiceImpl implements GetUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Map<String, String> getUser(Map<String, String> date) {
        User user=userMapper.selectById(date.get("user_id"));
        user.setPassword("");
        Map<String,String>map = new HashMap<>();
        map.put("name", user.getUsername());
        map.put("photo",user.getPhoto());
        return map;
    }
}
