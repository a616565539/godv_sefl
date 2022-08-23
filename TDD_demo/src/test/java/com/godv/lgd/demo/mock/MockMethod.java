package com.godv.lgd.demo.mock;

import com.godv.lgd.demo.enums.MockTypeEnum;

import java.util.ArrayList;
import java.util.List;

/** @Description:
  * @Author: GodV
  * @Date: 2022/8/5 11:46 上午
  *
  * @return:
*/
public interface MockMethod<T> {

    List<T> mockDataByConstructor();

    List<T> mockDataByJsonFile();

    default List<T> getMockData(MockTypeEnum mockTypeEnum) {
        List<T> result = new ArrayList<>();
        switch (mockTypeEnum) {
            case CONSTRUCTOR:
                result = this.mockDataByConstructor();
                break;
            case JSONFILE:
                result = this.mockDataByJsonFile();
                break;
            case MEMORY_DB:

            default:
                break;
        }
        return result;
    }
}
