package com.adj.service;

import com.adj.domain.entity.CarModel;
import com.adj.domain.entity.CarType;
import com.adj.domain.repository.CarModelRepository;
import com.adj.domain.repository.CarTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dhx on 2018/8/7.
 */
@Service
public class PrintKeyValueService {

    private Logger logger = LoggerFactory.getLogger(PrintKeyValueService.class);

    @Resource
    CarTypeRepository carTypeRepository;
    @Resource
    CarModelRepository carModelRepository;

    public void printAllToConsole() {
        logger.warn("start print");
        Iterable<CarType> carTypes = carTypeRepository.findAll();
        for (CarType carType : carTypes) {
            String key = "" + carType.getCarSerial().getCarBrand().getId() + "-" + carType.getCarSerial().getId() + "-" + carType.getId();
            String value = carType.getCarSerial().getCarBrand().getName() + carType.getCarSerial().getName() + carType.getName() + carType.getProdYear() + "款";
            logger.info("key:[{}] value[{}]", key, value);
        }
    }

    public void printAllToDB() {
        Iterable<CarType> carTypes = carTypeRepository.findAll();
        for (CarType carType : carTypes) {
            String key = "" + carType.getCarSerial().getCarBrand().getId() + "-" + carType.getCarSerial().getId() + "-" + carType.getId();
            String value = carType.getCarSerial().getCarBrand().getName() + carType.getCarSerial().getName() + carType.getName() + carType.getProdYear() + "款";
            logger.info("key:[{}] value[{}]", key, value);
            CarModel carModel = new CarModel(key, value);
            carModelRepository.save(carModel);
        }
    }
}
