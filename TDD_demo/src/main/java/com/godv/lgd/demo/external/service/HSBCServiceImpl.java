package com.godv.lgd.demo.external.service;

import com.godv.lgd.demo.external.model.HSBCData;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2022-08-01 17:43
 **/

@Service("hsbcService")
public class HSBCServiceImpl implements HSBCService{
    @Override
    public List<HSBCData> getHSBCData() {
        List<HSBCData> mockHSBCDataList = new ArrayList<>();
        HSBCData mockHSBCData1 = HSBCData.builder()
                .productName("serviceName1")
                .productPrice(new BigDecimal(111)).build();
        HSBCData mockHSBCData2 = HSBCData.builder()
                .productName("serviceName2")
                .productPrice(new BigDecimal(222)).build();

        mockHSBCDataList.add(mockHSBCData1);
        mockHSBCDataList.add(mockHSBCData2);
        return mockHSBCDataList;
    }
}
