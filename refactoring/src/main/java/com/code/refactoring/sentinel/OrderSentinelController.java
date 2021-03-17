package com.code.refactoring.sentinel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangxi created on 2021/3/17 23:25
 * @version v1.0
 */

@RestController
public class OrderSentinelController {

    @Resource
    private OrderSentinelService orderSentinelService;

    @RequestMapping("/getOrder")
    @ResponseBody
    public String queryOrder(@RequestParam("orderId") String orderId) {
        return orderSentinelService.queryOrderInfo(orderId);
    }


}
