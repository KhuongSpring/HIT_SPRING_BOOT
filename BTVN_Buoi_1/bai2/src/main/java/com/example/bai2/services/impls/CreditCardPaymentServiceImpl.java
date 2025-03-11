package com.example.bai2.services.impls;

import com.example.bai2.services.interfaces.IPaymentService;
import org.springframework.stereotype.Service;

@Service
public class CreditCardPaymentServiceImpl implements IPaymentService {
    @Override
    public String paymentWay(){
        return "Thanh toán qua thẻ tín dụng...";
    }
}
