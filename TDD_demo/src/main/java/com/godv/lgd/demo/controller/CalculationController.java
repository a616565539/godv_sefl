package com.godv.lgd.demo.controller;

import com.godv.lgd.demo.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2022-08-23 09:06
 **/
@RestController
@RequestMapping("/ut")
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @GetMapping("/summaryData")
    public void doSummary(){
        calculationService.summaryData();
    }
}
