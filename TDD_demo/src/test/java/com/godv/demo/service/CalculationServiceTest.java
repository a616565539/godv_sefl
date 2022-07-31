package com.godv.demo.service;

import com.godv.demo.external.model.HSBCData;
import com.godv.demo.external.service.HSBCService;
import com.godv.demo.model.CitiData;
import com.godv.demo.repo.CitiRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculationServiceTest {

    @Mock
    CitiRepository citiRepository;

    @Mock
    HSBCService hsbcService;

    @InjectMocks
    CalculationService calculationService;

    @Test
    public void summaryDataTest() {

        //mock CitiDataList (json文件或者自己手动创建)
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
        when(citiRepository.queryByCondition()).thenReturn(mockCitiDataList);


        //mock mockHSBCDataList
        List<HSBCData> mockHSBCDataList = new ArrayList<>();

        HSBCData mockHSBCData1 = HSBCData.builder()
                .productName("mockName1")
                .productPrice(new BigDecimal(888)).build();
        HSBCData mockHSBCData2 = HSBCData.builder()
                .productName("mockName2")
                .productPrice(new BigDecimal(666)).build();

        mockHSBCDataList.add(mockHSBCData1);
        mockHSBCDataList.add(mockHSBCData2);
        when(hsbcService.getHSBCData()).thenReturn(mockHSBCDataList);

        calculationService.summaryData();
    }


}