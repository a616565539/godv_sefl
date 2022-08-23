package com.godv.lgd.demo.mock;

import com.godv.lgd.demo.enums.MockTypeEnum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** @Description:
  * @Author: GodV
  * @Date: 2022-08-03 15:47
  *
  * @return:
*/
public interface MockMethod<T> {

    List<T> mockDataByConstructor();

    List<T> mockDataByJsonFile() throws IOException;

    default List<T> getMockData(MockTypeEnum mockTypeEnum) throws IOException {
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
