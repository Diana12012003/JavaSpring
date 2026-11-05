package org.example.Homework11;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CarCleaning {

    @Autowired
    private CarService carService;

    @Scheduled(fixedRate = 3600000)
    public void runCleanup() {
        carService.deleteWeakCars();
    }
}
