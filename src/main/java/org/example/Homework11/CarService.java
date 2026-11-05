package org.example.Homework11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService{

    @Autowired
    private CarRepository carRepository;

    public void deleteWeakCars() {
        List<Car> weakCars = carRepository.findByPowerLessThan(100);

        carRepository.deleteAll(weakCars);

        System.out.println("Видалено машин: " + weakCars.size());
    }
}