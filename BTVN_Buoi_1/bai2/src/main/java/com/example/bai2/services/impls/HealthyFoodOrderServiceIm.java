package com.example.bai2.services.impls;

import com.example.bai2.services.interfaces.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class HealthyFoodOrderServiceIm implements IOrderService {
    @Override
    public String ordering(){
        return "Đặt món ăn lành mạnh...";
    }
}
