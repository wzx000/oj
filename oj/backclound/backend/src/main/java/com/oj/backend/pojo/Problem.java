package com.oj.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer number;
    private String title;
    private String type;
    private String numberTitleType;
    private String topicDescription;
    private String inputDescription;
    private String outputDescription;
    private String exampleOneInput;
    private String exampleOneOutput;
    private String exampleTwoInput;
    private String exampleTwoOutput;
    private String exampleThreeInput;
    private String exampleThreeOutput;
    private String link;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date modifyTime;
}
