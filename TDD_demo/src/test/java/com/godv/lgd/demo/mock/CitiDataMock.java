package com.godv.lgd.demo.mock;

import com.alibaba.fastjson.JSONObject;
import com.godv.lgd.demo.model.CitiData;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2022-08-03 15:47
 **/

public class CitiDataMock implements MockMethod<CitiData>{
    @Override
    public List<CitiData>  mockDataByConstructor() {
        List<CitiData> mockCitiDataList = new ArrayList<>();

        CitiData mockCitiData1 = CitiData.builder()
                .productId(1L)
                .productName("mockName1")
                .productPrice(new BigDecimal(888)).build();
        CitiData mockCitiData2 = CitiData.builder()
                .productId(2L)
                .productName("mockName2")
                .productPrice(new BigDecimal(666)).build();

        mockCitiDataList.add(mockCitiData1);
        mockCitiDataList.add(mockCitiData2);
        return mockCitiDataList;
    }

    @SneakyThrows
    @Override
    public List<CitiData> mockDataByJsonFile() {
        String filePath="/Users/godv/Documents/selfXM/lgd/TDD_demo/src/main/resources/mock/CitiDataJson";
        String jsonString = FileUtils.readFileToString(new File(filePath));
        return JSONObject.parseArray(jsonString, CitiData.class);
    }
}
