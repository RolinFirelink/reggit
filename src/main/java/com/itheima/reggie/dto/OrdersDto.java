package com.itheima.reggie.dto;

import com.itheima.reggie.entity.Orders;
import lombok.Data;

@Data
public class OrdersDto extends Orders {

    //记录订单的数量
    private Integer sumNum;

    //记录下单用户的名字
    private String consignee;
}
