package com.oj.backend.service.impl.competition;

import com.oj.backend.mapper.CompetitionMapper;
import com.oj.backend.pojo.Competition;
import com.oj.backend.service.competition.UpdateCompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateCompetitionServiceImpl implements UpdateCompetitionService {
    @Autowired
    private CompetitionMapper competitionMapper;
    @Override
    public Map<String, String> updateCompetition(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();
        String gameName = data.get("game_name");
        String gameType = data.get("game_type");
        String details =  data.get("details");
        Date startTime = new Date();
        Date endTime = new Date();
        try {
            startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data.get("start_time"));
        } catch (ParseException e) {
            e.printStackTrace();
            map.put("error_message","时间格数错误");
            return map;
        }
        try {
            endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data.get("end_time"));
        } catch (ParseException e) {
            e.printStackTrace();
            map.put("error_message","时间格数错误");
            return map;
        }
        Competition competition = competitionMapper.selectById(data.get("competition_id"));
        Competition nowCompetition =new Competition(
                competition.getId(),
                gameName,
                gameType,
                details,
                startTime,
                endTime,
                competition.getCreationTime()
        );
        competitionMapper.updateById(nowCompetition);
        map.put("error_message","success");
        return map;
    }
}
