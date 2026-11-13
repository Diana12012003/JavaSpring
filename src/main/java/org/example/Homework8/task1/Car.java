package org.example.Homework8.task1;



public class Car {
    private int id;
    private String model;
    private String producer;
    private int power;

    public Car(int id, String model, String producer, int power) {
        this.id = id;
        this.model = model;
        this.producer = producer;
        this.power = power;
    }

    public Car(){

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
