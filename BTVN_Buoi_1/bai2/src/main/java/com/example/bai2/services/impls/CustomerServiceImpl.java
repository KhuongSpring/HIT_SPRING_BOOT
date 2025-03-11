package com.example.bai2.services.impls;

import com.example.bai2.entities.Customer;
import com.example.bai2.services.interfaces.ICustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Override
    public Customer makeCustomer() {
        return Customer.builder()
                .name("Khuong")
                .age(20)
                .email("boyzsno1@gmail.com")
                .gender("Male")
                .build();
    }
}
