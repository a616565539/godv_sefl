package com.godv.lgd.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
@ApiModel(value = "导出excel Vo")
public class ExportExcelVO {

    @ApiModelProperty("sheet名称")
    private String sheetName;

    @ApiModelProperty("行集合")
    private List<List<String>> rowTitle;

}
