package com.oj.backend.service.competittionUser;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.util.MultiValueMap;


public interface GetListCompetitionUserService {
    JSONObject getListCompetitionUser(Integer page, MultiValueMap<String,String> data);
}
