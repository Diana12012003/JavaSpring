package org.example.Homework10.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.example.Homework10.models.Car;
import org.example.Homework10.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cars")

public class CarController{

    private final CarService carService;

    private CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    @JsonView(Car.View.Level3.class)
        public ResponseEntity<List<Car>> getCars() {
            List<Car> all = carService.findAll();
            return new ResponseEntity<>(all, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        @JsonView(Car.View.Level1.class)
        public ResponseEntity<Car> getCar(@PathVariable int id) {
            Car car = carService.findOne(id);
            return new ResponseEntity<>(car, HttpStatus.OK);
        }

        @PostMapping("")
        @JsonView(Car.View.Level1.class)
        public ResponseEntity<Car> saveCar(@RequestBody @Valid Car car) {
            carService.save(car);
            return new ResponseEntity<>(car, HttpStatus.CREATED);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCar(@PathVariable int id) {
            carService.delete(id);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("/findby/power/{value}")
        @JsonView(Car.View.Level2.class)
        public ResponseEntity<List<Car>> findByPower(@PathVariable int value) {
            List<Car> cars = carService.findByPower(value);
            return new ResponseEntity<>(cars, HttpStatus.OK);
        }

        @GetMapping("/findby/producer/{value}")
        @JsonView(Car.View.Level2.class)
        public ResponseEntity<List<Car>> findByProducer(@PathVariable String value) {
        List<Car> cars = carService.findByProducer(value);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}

