package com.oj.backend.service.impl.problem;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oj.backend.mapper.ProblemMapper;
import com.oj.backend.pojo.Problem;
import com.oj.backend.service.problem.GetListProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListProblemServiceImpl implements GetListProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public JSONObject getListProblem(Integer page) {
        IPage<Problem> problemIPage = new Page<>(page, 25);
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("number");
        List<Problem> problems = problemMapper.selectPage(problemIPage, queryWrapper).getRecords();
        JSONObject resp = new JSONObject();
        resp.put("problems", problems);
        resp.put("problems_count", problemMapper.selectCount(null));
        return resp;
    }
}
