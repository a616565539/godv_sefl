package com.godv.demo.repo;


import com.godv.demo.mapper.CitiMapper;
import com.godv.demo.model.CitiData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: lgd
 * @description: repository
 * @author: GodV
 * @create: 2022-07-26 18:47
 **/

public class CitiRepository {

    @Autowired
    CitiMapper citiMapperImpl;

    public List<CitiData> queryByCondition(){
        return citiMapperImpl.doQuery();
    }
}
