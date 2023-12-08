package com.xuecheng.base.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//分页查询参数
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParams {
//查询第几页
    @ApiModelProperty("当前页码")
    private Long pageNo;
//每页多少条数据
    @ApiModelProperty("每页记录数默认值")
    private Long pageSize = 30L;

}
