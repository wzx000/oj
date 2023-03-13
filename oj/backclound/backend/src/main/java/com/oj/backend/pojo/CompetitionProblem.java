package com.oj.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionProblem {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer competitionId;
    private Integer number;
    private String title;
    private String type;
    private Integer score;
    private String topicDescription;
    private String inputDescription;
    private String outputDescription;
    private String exampleOneInput;
    private String exampleOneOutput;
    private String exampleTwoInput;
    private String exampleTwoOutput;
    private String exampleThreeInput;
    private String exampleThreeOutput;
}
