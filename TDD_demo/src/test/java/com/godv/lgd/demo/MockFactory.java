package com.godv.lgd.demo;

import com.godv.lgd.demo.enums.MockTypeEnum;
import com.godv.lgd.demo.mock.MockMethod;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2022-08-03 15:38
 **/

public class MockFactory {

    public static List<Object> getMockData(T className, MockTypeEnum mockTypeEnum) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<Object> result = new ArrayList<>();
        String mockClassName = className.getClass().getName() + "Mock";
        MockMethod mockMethod = (MockMethod) Class.forName(mockClassName).newInstance();
        return result;
    }
}
