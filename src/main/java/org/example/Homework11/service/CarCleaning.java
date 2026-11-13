package org.example.Homework11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class CarCleaning {

    @Autowired
    private CarService carService;

    @Scheduled(fixedRate = 3000)
    public void scheduleCleaning() {
        carService.deleteWeakCars();
    }
}
