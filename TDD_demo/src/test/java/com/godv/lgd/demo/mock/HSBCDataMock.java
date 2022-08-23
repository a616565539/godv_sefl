package com.godv.lgd.demo.mock;

import com.alibaba.fastjson.JSONObject;
import com.godv.lgd.demo.external.model.HSBCData;
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
 * @create: 2022-08-04 11:46
 **/

public class HSBCDataMock implements MockMethod<HSBCData>{


    @Override
    public List<HSBCData> mockDataByConstructor() {
        List<HSBCData> mockHSBCDataList = new ArrayList<>();
        HSBCData mockHSBCData1 = HSBCData.builder()
                .productName("mockName1")
                .productPrice(new BigDecimal(888)).build();
        HSBCData mockHSBCData2 = HSBCData.builder()
                .productName("mockName2")
                .productPrice(new BigDecimal(666)).build();

        mockHSBCDataList.add(mockHSBCData1);
        mockHSBCDataList.add(mockHSBCData2);
        return mockHSBCDataList;
    }

    @SneakyThrows
    @Override
    public List<HSBCData> mockDataByJsonFile() {
        String filePath="/Users/godv/Documents/selfXM/lgd/TDD_demo/src/main/resources/mock/HSBCDataJson";
        String jsonString = FileUtils.readFileToString(new File(filePath));
        return JSONObject.parseArray(jsonString, HSBCData.class);
    }
}


