package com.demo.demospring.model.response;

import com.demo.demospring.common.StatusType;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import java.util.Date;

@Data
@JsonRootName("work_res")
public class WorkRes {
    private String workName;
    private Date startDate;
    private Date endDate;
    private StatusType status;
}
