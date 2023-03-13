package com.oj.backend.service.impl.user;

import com.oj.backend.mapper.UserMapper;
import com.oj.backend.service.user.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveServiceImpl implements RemoveService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();
        userMapper.deleteById(data.get("user_id"));
        map.put("error_message", "success");
        return map;
    }
}
