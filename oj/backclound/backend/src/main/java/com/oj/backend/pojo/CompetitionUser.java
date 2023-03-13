package com.oj.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionUser {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer competitionId;
    private Integer userId;
    private Integer score;
    private String code1;
    private Integer score1;
    private String code2;
    private Integer score2;
    private String code3;
    private Integer score3;
    private String code4;
    private Integer score4;
    private String code5;
    private Integer score5;
    private String code6;
    private Integer score6;
    private String code7;
    private Integer score7;
    private String code8;
    private Integer score8;
    private String code9;
    private Integer score9;
    private String code10;
    private Integer score10;
}
