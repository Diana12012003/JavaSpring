package org.example.Homework10.service;

import org.example.Homework10.dao.CarDAO;
import org.example.Homework10.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService{

    @Autowired
    private CarDAO carDAO;

    public List<Car> findAll() {
        return carDAO.findAll();
    }

    public Car findOne(int id) {
        Car car = carDAO.findOne(id);
        if (car == null) {
            throw new RuntimeException("Авто з таким id не знайдено");
        }
        return car;
    }

    public void save(Car car) {
        carDAO.save(car);
    }

    public void delete(int id) {
        Car car = carDAO.findOne(id);
        if (car == null) {
            throw new RuntimeException("Неможливо видалити, авто з таким id не знайдено");
        }
        carDAO.delete(id);
    }

    public List<Car> findByProducer(String producer) {
        return carDAO.findByProducer(producer);
    }

    public List<Car> findByPower(int power) {
        return carDAO.findByPower(power);
    }
}
