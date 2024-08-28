package com.godv.lgd.demo.service;

import com.godv.lgd.demo.external.exception.HSBCBusinessException1;
import com.godv.lgd.demo.external.exception.HSBCBusinessException2;
import com.godv.lgd.demo.external.exception.HSBCBusinessException3;
import com.godv.lgd.demo.external.model.HSBCData;
import com.godv.lgd.demo.external.service.HSBCService;
import com.godv.lgd.demo.model.CitiData;
import com.godv.lgd.demo.repo.CitiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: lgd
 * @description: calculate data
 * F * @author: GodV
 * @create: 2022-07-26 18:26
 **/

@Service
public class CalculationService {

    @Autowired
    HSBCService hsbcService;

    @Autowired
    CitiRepository citiRepository;


    public void wholeProcess() throws InterruptedException {
        //模拟代码运行时间
        Thread.sleep(1000L*60L*60L);

        //需要修改的代码
        summaryData();

        //模拟代码运行时间
        Thread.sleep(1000L*60L*60L);
    }

    public void summaryData() {
        //query from database
        List<CitiData> CitiDataList = citiRepository.queryByCondition();

        //query from external RPC
        List<HSBCData> hsbcDataList = null;
        try {
            hsbcDataList = hsbcService.getHSBCData();
        }
        catch (HSBCBusinessException1 e1) {
            //异常1,直接返回,不做自己的业务处理
            System.out.println("捕获异常1,直接返回");
            return;
        }catch (HSBCBusinessException2 e2) {
            //异常2,不计算外部业务,只做自己的业务处理
            System.out.println("捕获异常2,返回空数组继续运行");
            hsbcDataList=new ArrayList<>();
        }catch (HSBCBusinessException3 e3) {
            //异常3
            System.out.println("捕获异常3,执行异常处理逻辑");
        }

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
        System.out.println("summaryData()方法直接完毕,total="+total);
    }

}
