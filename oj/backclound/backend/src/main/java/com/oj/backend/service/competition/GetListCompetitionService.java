package com.oj.backend.service.competition;

import com.alibaba.fastjson2.JSONObject;

public interface GetListCompetitionService {
    JSONObject getListCompetition(Integer page);
}
