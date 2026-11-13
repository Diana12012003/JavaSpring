package org.example.Homework11.repository;


import org.example.Homework11.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findByPowerLessThan(int power);
}
