package com.oj.backend.service.impl.competition;

import com.oj.backend.mapper.CompetitionMapper;
import com.oj.backend.service.competition.RemoveCompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveCompetitionServiceImpl implements RemoveCompetitionService {
    @Autowired
    private CompetitionMapper  competitionMapper;
    @Override
    public Map<String, String> removeCompetition(Map<String, String> data) {
        Map<String,String> map =  new HashMap<>();
        competitionMapper.deleteById(data.get("competition_id"));
        map.put("error_message","success");
        return map;
    }
}
