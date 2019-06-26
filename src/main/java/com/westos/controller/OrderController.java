package com.westos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @RequestMapping("/order/search")
    public String ordersearch(){

        return "/order/search/search";
    }

    @RequestMapping("/order/stat")
    public String ordersta(){

        return "/order/stat/stat";
    }


    @RequestMapping("/product/search")
    public String productsearch(){

        return "/product/search/search";
    }

    @RequestMapping("/product/onoff")
    public String productonoff(){

        return "/product/onoff/onoff";
    }

    @RequestMapping("/product/stat")
    public String productstat(){

        return "/product/stat/stat";
    }

    @RequestMapping("/product/inventory")
    public String productinventory(){

        return "/product/inventory/inventory";
    }
}
