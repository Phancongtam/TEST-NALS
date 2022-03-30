package com.demo.demospring.entity;

import com.demo.demospring.common.StatusType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "works")
@Data
public class WorkEntity {
    private static final long serialVersionUID = -297553281792804396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "work_name")
    private String workName;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "status")
    private String status;

    public WorkEntity(String workName, Date endDate, Date startDate, String status) {
        this.workName = workName;
        this.endDate = endDate;
        this.startDate = startDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "WorkEntity [workName=" + workName + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
    }

}
