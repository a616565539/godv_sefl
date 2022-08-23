package com.godv.lgd.demo.repo;


import com.godv.lgd.demo.mapper.CitiMapper;
import com.godv.lgd.demo.model.CitiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: lgd
 * @description: repository
 * @author: GodV
 * @create: 2022-07-26 18:47
 **/
@Component
public class CitiRepository {

    @Autowired
    CitiMapper citiMapper;

    public List<CitiData> queryByCondition(){
        return citiMapper.doQuery();
    }
}
