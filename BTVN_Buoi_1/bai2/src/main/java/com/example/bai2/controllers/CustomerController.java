package com.example.bai2.controllers;

import com.example.bai2.services.interfaces.ICustomerService;
import com.example.bai2.services.interfaces.IOrderService;
import com.example.bai2.services.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {
    public static IOrderService orderService;
    public static IPaymentService paymentService;
    public static ICustomerService customerService;


    public CustomerController(@Qualifier("healthyFoodOrderServiceIm") IOrderService orderService, @Qualifier("payPalPaymentServiceImpl") IPaymentService paymentService, ICustomerService customerService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.customerService = customerService;
    }

    public static void orderFood(){
        System.out.println(orderService.ordering());
    }
    public static void paymentWay(){
        System.out.println(paymentService.paymentWay());
    }

    public static void customerOrderAndPay(){
        System.out.println(customerService.makeCustomer());
        orderFood();
        paymentWay();
    }
}
