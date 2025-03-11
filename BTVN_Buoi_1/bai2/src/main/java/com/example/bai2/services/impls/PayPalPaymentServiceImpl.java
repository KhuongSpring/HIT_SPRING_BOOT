package com.example.bai2.services.impls;

import com.example.bai2.services.interfaces.IPaymentService;
import org.springframework.stereotype.Service;

@Service
public class PayPalPaymentServiceImpl implements IPaymentService {
    @Override
    public String paymentWay(){
        return "Thanh toán qua Paypal...";
    }
}
