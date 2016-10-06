package com.tsystems;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/
public class Car {
    private String model;
    private int price;
    private int horsePower;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "com.tsystems.Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", horsePower=" + horsePower +
                '}';
    }
}
