package org.example.Homework10;

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
        return carDAO.findOne(id);
    }

    public void save(Car car) {
        carDAO.save(car);
    }

    public void delete(int id) {
        carDAO.delete(id);
    }

    public List<Car> findByProducer(String producer) {
        return carDAO.findByProducer(producer);
    }

    public List<Car> findByPower(int power) {
        return carDAO.findByPower(power);
    }
}
