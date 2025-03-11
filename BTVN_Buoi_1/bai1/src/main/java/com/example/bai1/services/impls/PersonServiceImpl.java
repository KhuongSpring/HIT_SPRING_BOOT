package com.example.bai1.services.impls;

import com.example.bai1.entities.Person;
import com.example.bai1.services.interfaces.IPersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {
    @Override
    public Person makePerson(){
        return Person.builder()
                .name("Khuong")
                .age(20)
                .email("boyzsno1@gmail.com")
                .gender("Male")
                .build();
    }
}
