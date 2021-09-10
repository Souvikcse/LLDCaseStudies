package com.system.design.lld.parkinglot.models;
/**
 * @author nayanava
 */

public class Vehicle {
    private String registrationNumber;
    String color;
    String vehicleModel;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Vehicle(String registrationNumber,
                   String color,
                   String vehicleModel) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.vehicleModel = vehicleModel;
    }
}
