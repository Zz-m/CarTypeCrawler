package com.adj.schedule;

import com.adj.service.TestHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by dhx on 2018/8/16.
 */
@Component
public class TestScheduleTask {


    private TestHibernateService testHibernateService;

    @Autowired
    public TestScheduleTask(TestHibernateService testHibernateService) {
        this.testHibernateService = testHibernateService;
    }

    @Scheduled(fixedDelay = 1000)
    public void test() {
        testHibernateService.test();
    }
}
