package com.demo.demospring.common;

public enum StatusType {
    PLANNING("Lập kế hoạch"),
    DOING("Thực hiện"),
    COMPLETE("Hoàn thành");

    public final String value;


    StatusType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
