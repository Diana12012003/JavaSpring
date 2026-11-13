package org.example.Homework11.service;
import org.example.Homework11.entity.Car;
import org.example.Homework11.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private JavaMailSender mailSender;

    public Car saveCar(String model, String producer, int power, MultipartFile file) throws IOException {
        String uploadDir = System.getProperty("user.home") + File.separator + "carsImages" + File.separator;

        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String filePath = uploadDir + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        Car car = new Car();
        car.setModel(model);
        car.setProducer(producer);
        car.setPower(power);
        car.setPhotoPath(filePath);

        Car savedCar = carRepository.save(car);
        sendEmail("Створено нове авто", "Авто успішно збережено в БД:\n" + savedCar);

        return savedCar;
    }
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(String id) {
        Optional<Car> car = carRepository.findById(id);
        return car.orElse(null);
    }

    public void deleteCar(String id) {
        Car car = getCarById(id);
        if (car != null) {
            carRepository.deleteById(id);
            sendEmail("Видалено авто", "Авто було видалено з БД:\n" + car);
        }
    }

    public void deleteWeakCars() {
        List<Car> weakCars = carRepository.findByPowerLessThan(100);
        for (Car car : weakCars) {
            carRepository.delete(car);
            sendEmail("Авто видалено через алу потжність", "Видалено авто (power < 100):\n" + car);
        }
    }

    private void sendEmail(String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("dianusy777@gmail.com");
            message.setSubject(subject);
            message.setText(text);
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println("Помилка при відправці листа: " + e.getMessage());
        }
    }
}