package com.demo.demospring;

import com.demo.demospring.common.StatusType;
import com.demo.demospring.entity.WorkEntity;
import com.demo.demospring.model.request.FilterReq;
import com.demo.demospring.service.WorkService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoSpringApplicationTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private WorkService workService;

    @Test
    void testFilter() {
        testEntityManager.persist(new WorkEntity("học bài",new Date(2022-03-23),new Date(2022-03-20), StatusType.COMPLETE.getValue()));
        FilterReq filterReq = new FilterReq();
        filterReq.setPage(1);
        filterReq.setSize(5);
        List<WorkEntity> products = workService.filter(filterReq);
        Assert.assertEquals(1, products.size());

        Assertions.assertThat(products).extracting(WorkEntity::getWorkName).containsOnly("học bài");
    }

    @Test
    void testAdd() {
    }

    @Test
    void testUpdate() {
    }

    @Test
    void testDelete() {
    }

}
