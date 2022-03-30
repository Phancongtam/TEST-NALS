package com.demo.demospring.model.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName("filter_req")
public class FilterReq {
    private Integer size;
    private Integer page;
}
