package com.oj.backend.service.user;

import com.alibaba.fastjson2.JSONObject;
import com.oj.backend.pojo.User;

import java.util.List;
import java.util.Map;

public interface GetlistService {
    JSONObject getlist(Integer page);
}
