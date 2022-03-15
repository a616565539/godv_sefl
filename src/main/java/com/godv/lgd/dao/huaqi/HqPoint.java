package com.godv.lgd.dao.huaqi;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2022-03-14 23:59
 **/

@Getter
@Setter
public class HqPoint {

    String jobName;
    String status;

    //坐标
    Integer x;
    Integer y;

    //
    Date StartTime;
    Date endTimeTime;
    String runTimeAve;

}
