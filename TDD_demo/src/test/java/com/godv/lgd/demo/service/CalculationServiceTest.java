package com.godv.lgd.demo.service;

import com.godv.lgd.demo.enums.MockTypeEnum;
import com.godv.lgd.demo.external.exception.HSBCBusinessException1;
import com.godv.lgd.demo.external.exception.HSBCBusinessException2;
import com.godv.lgd.demo.external.exception.HSBCBusinessException3;
import com.godv.lgd.demo.external.model.HSBCData;
import com.godv.lgd.demo.external.service.HSBCService;
import com.godv.lgd.demo.mock.CitiDataMock;
import com.godv.lgd.demo.mock.HSBCDataMock;
import com.godv.lgd.demo.model.CitiData;
import com.godv.lgd.demo.repo.CitiRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculationServiceTest {

    // spark demo
    @Mock
    CitiRepository citiRepository;

    @Mock
    HSBCService hsbcService;

    @InjectMocks
    CalculationService calculationService;

    private List<CitiData> mockCitiDataByConstructor;
    private List<CitiData> mockCitiDataByJson;
    private List<HSBCData> mockHSBCDataByConstructor;
    private List<HSBCData> mockHSBCDataByJson;

    private CitiDataMock citiDataMock = new CitiDataMock();
    private HSBCDataMock hsbcDataMock = new HSBCDataMock();
    @Before
    public void mockData() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException {
        //mock CitiDataList
        mockCitiDataByConstructor = citiDataMock.getMockData(MockTypeEnum.CONSTRUCTOR);
        mockCitiDataByJson = citiDataMock.getMockData(MockTypeEnum.JSONFILE);

        //mock HSBCDataList
        mockHSBCDataByConstructor = hsbcDataMock.getMockData(MockTypeEnum.CONSTRUCTOR);
        mockHSBCDataByJson = hsbcDataMock.getMockData(MockTypeEnum.JSONFILE);
    }



    @Test
    public void summaryDataNormal() {
        when(citiRepository.queryByCondition()).thenReturn(mockCitiDataByConstructor);
        when(hsbcService.getHSBCData()).thenReturn(mockHSBCDataByConstructor);
        calculationService.summaryData();
    }

    //随机   暴力获取
    @Test
    public void summaryDataException1() {
        when(citiRepository.queryByCondition()).thenReturn(mockCitiDataByConstructor);
        when(hsbcService.getHSBCData()).thenThrow(HSBCBusinessException1.class);
        calculationService.summaryData();
    }

    @Test
    public void summaryDataException2() {
        when(citiRepository.queryByCondition()).thenReturn(mockCitiDataByConstructor);
        when(hsbcService.getHSBCData()).thenThrow(HSBCBusinessException2.class);
        calculationService.summaryData();
    }

    @Test
    public void summaryDataException3() {
        when(citiRepository.queryByCondition()).thenReturn(mockCitiDataByConstructor);
        when(hsbcService.getHSBCData()).thenThrow(HSBCBusinessException3.class);
        calculationService.summaryData();
    }

    private final String s="|";
    @Test
    public void test() {

        System.out.println(new BigDecimal(1.00).doubleValue()/new BigDecimal(3.00).doubleValue());
    }
}