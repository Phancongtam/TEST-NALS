package com.demo.demospring.model.request;

import com.demo.demospring.common.StatusType;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@JsonRootName("work_req")
public class WorkReq {
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String workName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @NotNull
    private StatusType status;
}
