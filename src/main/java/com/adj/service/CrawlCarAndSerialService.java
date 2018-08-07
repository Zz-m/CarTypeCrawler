package com.adj.service;

import com.adj.api.YicheWangApi;
import com.adj.bean.CarAndSerialResponse;
import com.adj.bean.CarQueryResponse;
import com.adj.bean.CarResponse;
import com.adj.bean.CarSerialResponse;
import com.adj.domain.entity.CarBrand;
import com.adj.domain.entity.CarSerial;
import com.adj.domain.entity.CarType;
import com.adj.domain.entity.MySetting;
import com.adj.domain.repository.CarBrandRepository;
import com.adj.domain.repository.CarSerialRepository;
import com.adj.domain.repository.CarTypeRepository;
import com.adj.domain.repository.MySettingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by dhx on 2018/8/7.
 */
@Service
public class CrawlCarAndSerialService {

    public static final String PAGE_PROPERTY_KEY = "pageNum";

    private Logger logger = LoggerFactory.getLogger(CrawlCarAndSerialService.class);

    @Resource
    YicheWangApi yicheWangApi;
    @Resource
    CarBrandRepository carBrandRepository;
    @Resource
    CarSerialRepository carSerialRepository;
    @Resource
    CarTypeRepository carTypeRepository;
    @Resource
    MySettingRepository propertyRepository;

    public void startCrawl() throws IOException {

        int page = 1;
        MySetting property = propertyRepository.findFirstByMyId(PAGE_PROPERTY_KEY);
        if (property != null) {
            page = Integer.parseInt(property.getValue());
        }

        logger.warn("start page: " + page);

        while (true) {
            CarAndSerialResponse carAndSerialResponse = yicheWangApi.loadCarAndSerial(page);
            List<CarSerialResponse> carSerialResponses = carAndSerialResponse.getResList();
            if (carSerialResponses.size() == 0) break;
            for (CarSerialResponse carSerialResponse : carSerialResponses) {
                long brandId = carSerialResponse.getMasterId();
                CarBrand carBrand = carBrandRepository.findFirstById(brandId);
                if (carBrand == null) {
                    MySetting propertyToSave = new MySetting();
                    propertyToSave.setMyId(PAGE_PROPERTY_KEY);
                    propertyToSave.setValue(Integer.toString(page));
                    propertyRepository.save(propertyToSave);
                    throw new IllegalArgumentException("brand not found : " + brandId + " name: " + carSerialResponse.getShowName());
                }
                CarSerial carSerial = new CarSerial(carSerialResponse.getSerialId(), carSerialResponse.getShowName(), carBrand);
                carSerialRepository.save(carSerial);

                CarQueryResponse carQueryResponse = yicheWangApi.loadCarDetailList(carSerial.getId(), carSerialResponse.getCarIdList());
                for (CarResponse carResponse : carQueryResponse.getCarList()) {
                    CarType carType = new CarType(carResponse.getCarID(), carResponse.getCarName(), carResponse.getCarYear(), carSerial);
                    carTypeRepository.save(carType);
                }
            }
            page++;
        }

        MySetting propertyToSave = new MySetting();
        propertyToSave.setMyId(PAGE_PROPERTY_KEY);
        propertyToSave.setValue("1");
        propertyRepository.save(propertyToSave);
        logger.warn("crawl finished! congratulate...");
    }
}
