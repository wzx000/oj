package com.oj.backend.service.impl.competition;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oj.backend.mapper.CompetitionMapper;
import com.oj.backend.pojo.Competition;
import com.oj.backend.pojo.Problem;
import com.oj.backend.service.competition.GetListCompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListCompetitionServiceImpl implements GetListCompetitionService {
    @Autowired
    private CompetitionMapper competitionMapper;
    @Override
    public JSONObject getListCompetition(Integer page) {
        IPage<Competition> competitionIPage = new Page<>(page, 5);
        QueryWrapper<Competition> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        List<Competition> competitions = competitionMapper.selectPage(competitionIPage, queryWrapper).getRecords();
        JSONObject resp = new JSONObject();
        resp.put("competitions", competitions);
        resp.put("competitions_count", competitionMapper.selectCount(null));
        return resp;
    }
}
