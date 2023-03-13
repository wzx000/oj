package com.oj.backend.service.competitionProblem;

import com.oj.backend.pojo.CompetitionProblem;

import java.util.List;
import java.util.Map;

public interface GetListCompetitionProblemService {
    List<CompetitionProblem>getListCompetitionProblem(Map<String,String>data);
}
