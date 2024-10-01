package entity;

import java.util.List;

public class Vehicle {
    private String registrationNumber;
    private String color;
    private String type; // Mobil atau Motor

    public Vehicle(String registrationNumber, String color, String type) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public boolean isOddRegistration(String registrationNumber) {
        String[] splitRegistration = registrationNumber.split("-");
        int number=Integer.parseInt(splitRegistration[1]);
        return number%2!=0;

    }

    public boolean isEvenRegistration(String registrationNumber) {
        String[] splitRegistration = registrationNumber.split("-");
        int number=Integer.parseInt(splitRegistration[1]);
        return number%2==0;
    }
}
