package org.example.Homework9.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CarController{
    @Autowired
    private CarDAO carDAO;

    @GetMapping("/cars")
    public List<Car> getAll() {
        return carDAO.findAll();
    }
    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable int id) {
        return carDAO.findOne(id);
    }

    @PostMapping("/cars")
    public ResponseEntity<Void> createCar(@RequestBody Car car) {
        carDAO.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        carDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/cars/power/{value}")
    public List<Car> getCarbyPower(@PathVariable int value) {
        return carDAO.findByPower(value);
    }

    @GetMapping("/cars/producer/{value}")
    public List<Car> getCarbyProducer(@PathVariable String value) {
        return carDAO.findByProducer(value);
    }
}
