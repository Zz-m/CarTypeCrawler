package com.adj.api;

import com.adj.bean.CarAndSerialResponse;
import com.adj.bean.CarQueryResponse;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by dhx on 2018/8/7.
 */
@Component
public class YicheWangApi {
    private static final String CAR_AND_SERIAL_API_TEMPLATE = "http://select.car.yiche.com/selectcartool/searchresult?page=%d&external=Car&v=20171011";
    private static final String CAR_DETAIL_LIST_API_TEMPLATE = "http://api.car.bitauto.com/CarInfo/GetCarListForSelectCar.ashx?serialId=%d&carids=%s";

    @Resource
    private OkHttpClient okHttpClient;
    @Resource
    private Gson gson;

    public CarAndSerialResponse loadCarAndSerial(int page) throws IOException {
        String url = String.format(CAR_AND_SERIAL_API_TEMPLATE, page);

        Request request = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        if (!response.isSuccessful()) {
            response.body().close();
            throw new IOException("Request fail code: " + response.code());
        }
        String result = response.body().string();
        return gson.fromJson(result, CarAndSerialResponse.class);
    }

    public CarQueryResponse loadCarDetailList(long serialId, String carIdList) throws IOException {
        String url = String.format(CAR_DETAIL_LIST_API_TEMPLATE, serialId, carIdList);

        Request request = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        if (!response.isSuccessful()) {
            response.body().close();
            throw new IOException("Request fail code: " + response.code());
        }
        String result = response.body().string();

        return gson.fromJson(result, CarQueryResponse.class);
    }
}
