package com.oj.backend.service.impl.problem;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oj.backend.mapper.ProblemMapper;
import com.oj.backend.pojo.Problem;
import com.oj.backend.service.problem.GetLikeProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetLikeProblemServiceImpl implements GetLikeProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public JSONObject getLikeProblem(Integer page, Map<String ,String >data) {
        IPage<Problem> problemIPage = new Page<>(page, 25);
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("number_title_type",data.get("name"));
        List<Problem> problems = problemMapper.selectPage(problemIPage, queryWrapper).getRecords();
        JSONObject resp = new JSONObject();
        resp.put("likeProblems", problems);
        resp.put("likeProblems_count", problemMapper.selectCount(null));
        return resp;
    }
}
