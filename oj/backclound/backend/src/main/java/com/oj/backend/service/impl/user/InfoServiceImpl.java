package com.oj.backend.service.impl.user;

import com.oj.backend.pojo.User;
import com.oj.backend.service.impl.utils.UserDetailsImpl;
import com.oj.backend.service.user.InfoService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public Map<String, String> getinfo() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();

        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("id", user.getId().toString());
        map.put("username", user.getUsername());
        map.put("student_id",user.getStudentId().toString());
        map.put("qq",user.getQq());
        map.put("telephone",user.getTelephone());
        map.put("photo", user.getPhoto());
        return map;
    }
}

