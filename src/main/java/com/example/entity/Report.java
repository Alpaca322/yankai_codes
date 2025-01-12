package com.example.entity;

import lombok.Data;
import java.util.Date;

@Data

public class Report {

    private Integer reportId;
    private String reportType;
    private String content;
    private Date createdAt;
}
