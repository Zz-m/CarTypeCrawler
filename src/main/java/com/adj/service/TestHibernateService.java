package com.adj.service;

import com.adj.domain.entity.MySetting;
import com.adj.domain.repository.MySettingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dhx on 2018/8/16.
 */
@Service
public class TestHibernateService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private MySettingRepository mySettingRepository;

    private volatile MySetting oldSetting;

    @Autowired
    public TestHibernateService(MySettingRepository mySettingRepository) {
        this.mySettingRepository = mySettingRepository;
    }

    public void test() {
        MySetting setting = mySettingRepository.findFirstByMyId("king");
        if (oldSetting == null)
            oldSetting = setting;
        logger.info("old: {}", oldSetting.getValue());
        logger.info("new: {}", setting.getValue());
    }
}
