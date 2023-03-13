package com.oj.backend.service.impl.competitionProblem;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oj.backend.mapper.CompetitionProblemMapper;
import com.oj.backend.pojo.CompetitionProblem;
import com.oj.backend.service.competitionProblem.GetListCompetitionProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetListCompetitionProblemServiceImpl implements GetListCompetitionProblemService {
    @Autowired
    private CompetitionProblemMapper competitionProblemMapper;
    @Override
    public List<CompetitionProblem> getListCompetitionProblem(Map<String,String>data) {
        QueryWrapper<CompetitionProblem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("competition_id",data.get("competition_id"));
        return competitionProblemMapper.selectList(queryWrapper);
    }
}
