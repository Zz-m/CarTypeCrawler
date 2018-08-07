package com.adj.domain.repository;

import com.adj.domain.entity.MySetting;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dhx on 2018/8/7.
 */
public interface MySettingRepository extends CrudRepository<MySetting, String> {

    MySetting findFirstByMyId(String key);
}
