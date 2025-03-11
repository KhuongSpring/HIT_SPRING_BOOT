package com.example.bai1.services.impls;

import com.example.bai1.services.interfaces.IVehicleService;
import org.springframework.stereotype.Service;

@Service
public class MotobikeServiceImpl implements IVehicleService {
    @Override
    public String callName(){
        return "This is moto bike";
    }
}
