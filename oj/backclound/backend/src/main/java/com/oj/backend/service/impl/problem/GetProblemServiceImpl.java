package com.oj.backend.service.impl.problem;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oj.backend.mapper.ProblemMapper;
import com.oj.backend.pojo.Problem;
import com.oj.backend.service.problem.GetProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class GetProblemServiceImpl implements GetProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public List<Problem> getProblem(Map<String, String> data) {
        HashMap<String ,Object>hashMap=new HashMap<>();
        hashMap.put("title",data.get("name"));
        return problemMapper.selectByMap(hashMap);
    }
}
