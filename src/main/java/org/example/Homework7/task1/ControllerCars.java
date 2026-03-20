package org.example.Homework7.task1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerCars {

    List<Car> carList = new ArrayList<>();

    public ControllerCars() {
        carList.add(new Car(1, "Model S", "Tesla", 670));
        carList.add(new Car(2, "M5", "BMW", 600));
        carList.add(new Car(3, "Golf GTI", "Volkswagen", 245));
        carList.add(new Car(4, "Mustang", "Ford", 450));
        carList.add(new Car(5, "RS6", "Audi", 600));

    }


    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity <Car> getCarById(@PathVariable int id) {
        for (Car car : carList) {
            if (car.getId() == id) {
                return new ResponseEntity<>(car, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @PostMapping("/cars")
    public ResponseEntity<List<Car>> saveCar(@RequestBody Car car) {
        this.carList.add(car);
        return new ResponseEntity<>(this.carList, HttpStatus.CREATED);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<List<Car>> deleteCarr(@PathVariable int id) {
        carList.removeIf(car -> car.getId() == id);
        return new ResponseEntity<>(carList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/cars/power/{value}")
    public ResponseEntity<List<Car>> getCarByPower(@PathVariable int value) {
        List<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPower() == value) {
                result.add(car);
            }
        }
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }
    
    @GetMapping("/cars/producer/{value}")
    public ResponseEntity<List<Car>> getCarByProducer(@PathVariable String value) {
        List<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.getProducer().equals(value)) {
                result.add(car);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
