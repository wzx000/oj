package com.oj.backend.service.impl.competitionUser;

import com.oj.backend.mapper.CompetitionUserMapper;
import com.oj.backend.pojo.CompetitionUser;
import com.oj.backend.service.competittionUser.AddCompetitionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddCompetitionUserServiceImpl implements AddCompetitionUserService {
    @Autowired
    private CompetitionUserMapper competitionUserMapper;
    @Override
    public Map<String, String> addCompetitionUser(Map<String, String> data) {
        Map<String,Object>hashmap = new HashMap<>();
        hashmap.put("competition_id", data.get("competition_id"));
        hashmap.put("user_id", data.get("user_id"));
        List<CompetitionUser> list = competitionUserMapper.selectByMap(hashmap);
        Map<String, String> map = new HashMap<>();
        if(list.size()>0){
            map.put("error_message","已经参加比赛");
            return map;
        }
        Integer competitionId = Integer.parseInt(data.get("competition_id"));
        Integer userId = Integer.parseInt(data.get("user_id"));
        CompetitionUser competitionUser = new CompetitionUser();
        competitionUser.setCompetitionId(competitionId);
        competitionUser.setUserId(userId);
        competitionUserMapper.insert(competitionUser);
        map.put("error_message","success");
        return map;
    }
}
