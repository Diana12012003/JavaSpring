package org.example.Homework10.models;

import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "car")
public class Car {

    public interface View {
        interface Level1 extends Level2 {}
        interface Level2 extends Level3 {}
        interface Level3 {}

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Level1.class)
    private int id;
    @NotBlank(message = "Модель не може бути порожньою")
    @JsonView(View.Level3.class)
    private String model;
    @NotBlank(message = "Виробник має бути вказаний")
    @JsonView(View.Level3.class)
    private String producer;
    @Min(value = 1, message = "Потужність має бути більше 0")
    @JsonView(View.Level2.class)
    private int power;

    public Car() {
    }

    public Car(int id, String model, String producer, int power) {
        this.id = id;
        this.model = model;
        this.producer = producer;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                ", power=" + power +
                '}';
    }


}

