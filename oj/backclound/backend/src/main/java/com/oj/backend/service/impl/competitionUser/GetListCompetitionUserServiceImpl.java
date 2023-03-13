package com.oj.backend.service.impl.competitionUser;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oj.backend.mapper.CompetitionUserMapper;
import com.oj.backend.pojo.CompetitionUser;
import com.oj.backend.service.competittionUser.GetListCompetitionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;


@Service
public class GetListCompetitionUserServiceImpl implements GetListCompetitionUserService {
    @Autowired
    private CompetitionUserMapper competitionUserMapper;
    @Override
    public JSONObject getListCompetitionUser(Integer page, MultiValueMap<String, String> data) {
        IPage<CompetitionUser> competitionUserIPage = new Page<>(page, 25);
        QueryWrapper<CompetitionUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("competition_id",data.getFirst("competition_id")).orderByDesc("score");
        List<CompetitionUser> competitionUsers = competitionUserMapper.selectPage(competitionUserIPage,queryWrapper).getRecords();
        JSONObject resp = new JSONObject();
        resp.put("competitionUsers",competitionUsers);
        resp.put("competitionUsers_count",competitionUserMapper.selectList(queryWrapper).size());
        return resp;
    }
}
