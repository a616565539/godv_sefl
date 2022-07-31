package com.godv.demo.service;

import com.godv.demo.external.model.HSBCData;
import com.godv.demo.external.service.HSBCService;
import com.godv.demo.model.CitiData;
import com.godv.demo.repo.CitiRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: lgd
 * @description: calculate data
 * @author: GodV
 * @create: 2022-07-26 18:26
 **/

public class CalculationService {

    @Autowired
    HSBCService hsbcService;

    @Autowired
    CitiRepository citiRepository;

    public Boolean summaryData() {

        //query from database
        List<CitiData> CitiDataList = citiRepository.queryByCondition();

        //query from external RPC
        List<HSBCData> hsbcDataList = hsbcService.getHSBCData();


        //自己的业务处理逻辑
        AtomicReference<BigDecimal> citiSum = new AtomicReference<>(new BigDecimal(0));
        CitiDataList.stream().forEach(citiData -> {
            BigDecimal add = citiSum.get().add(citiData.getProductPrice());
            citiSum.set(add);
        });

        AtomicReference<BigDecimal> HSBCSum = new AtomicReference<>(new BigDecimal(0));
        hsbcDataList.stream().forEach(hsbcData -> {
            BigDecimal add = HSBCSum.get().add(hsbcData.getProductPrice());
            HSBCSum.set(add);
        });

        BigDecimal total = citiSum.get().add(HSBCSum.get());
        return total.compareTo(new BigDecimal(100000)) == -1;
    }

}
