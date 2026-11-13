package org.example.Homework11.controllers;

import org.example.Homework11.entity.Car;
import org.example.Homework11.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public Car saveCar(@RequestParam String model, @RequestParam String producer, @RequestParam int power, @RequestParam("image") MultipartFile file) throws IOException {
        return carService.saveCar(model, producer, power, file);
    }
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("cars/{id}")
    public Car getCarById(@PathVariable String id) {
        return carService.getCarById(id);
    }

    @DeleteMapping("cars/{id}")
    public void deleteCar(@PathVariable String id) {
        carService.deleteCar(id);
    }
}