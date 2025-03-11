package com.example.bai1.controllers;

import com.example.bai1.services.impls.PersonServiceImpl;
import com.example.bai1.services.interfaces.IEngineService;
import com.example.bai1.services.interfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    private static IEngineService engineService;
    private static IVehicleService vehicleService;
    private static PersonServiceImpl personService;

    public PersonController(@Qualifier("electicEngineImpl") IEngineService engineService, @Qualifier("carServiceImpl") IVehicleService vehicleService, PersonServiceImpl personService) {
        this.engineService = engineService;
        this.vehicleService = vehicleService;
        this.personService = personService;
    }

    public static void personDrive(){
        System.out.println(personService.makePerson().toString());
        System.out.println(engineService.callName());
        System.out.println(vehicleService.callName());
    }


}
