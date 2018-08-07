package com.adj.domain.repository;

import com.adj.domain.entity.CarBrand;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dhx on 2018/8/7.
 */
public interface CarBrandRepository extends CrudRepository<CarBrand, Integer> {

    CarBrand findFirstById(long id);

}
