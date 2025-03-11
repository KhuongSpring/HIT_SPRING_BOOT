package com.example.bai1.services.impls;

import com.example.bai1.services.interfaces.IEngineService;
import org.springframework.stereotype.Service;

@Service
public class ElecticEngineImpl implements IEngineService {
    @Override
    public String callName(){
        return "This is electric engine";
    }
}
