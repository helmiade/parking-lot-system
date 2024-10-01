package service;

import entity.ParkingSlot;
import entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final ParkingSlot[] slots;

    public ParkingLot(int size) {
        slots = new ParkingSlot[size];
        for (int i = 0; i < size; i++) {
            slots[i] = new ParkingSlot(i + 1);
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        for (ParkingSlot slot : slots) {
            if (slot.isAvailable()) {
                slot.park(vehicle);
                System.out.println("Allocated slot number: " + slot.getSlotNumber());
                return;
            }
        }
        System.out.println("Sorry, parking lot is full");
    }

    public void leave(int slotNumber) {
        if (slotNumber < 1 || slotNumber > slots.length) {
            System.out.println("Invalid slot number");
            return;
        }
        slots[slotNumber - 1].leave();
        System.out.println("Slot number " + slotNumber + " is free");
    }

    public void status() {
        System.out.println("Slot\tNo.\t\tType\tRegistration No\tColour");
        for (ParkingSlot slot : slots) {
            Vehicle vehicle = slot.getVehicle();
            if (vehicle != null) {
                System.out.println(slot.getSlotNumber() + "\t" + vehicle.getRegistrationNumber() +
                        "\t" + vehicle.getType() + "\t" + vehicle.getRegistrationNumber() +
                        "\t" + vehicle.getColor());
            }
        }
    }

    public void vehiclesByType(String type) {
        int count = 0;
        for (ParkingSlot slot : slots) {
            Vehicle vehicle = slot.getVehicle();
            if (vehicle != null && vehicle.getType().equalsIgnoreCase(type)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void vehiclesByOdd() {
        List<String> result = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            Vehicle vehicle = slot.getVehicle();
            if (vehicle != null) {
                if (vehicle.isOddRegistration(vehicle.getRegistrationNumber())) {
                    result.add(vehicle.getRegistrationNumber());
                }
            }
        }
        System.out.println(String.join(", ", result));
    }
    public void vehiclesByEven() {
        List<String> result = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            Vehicle vehicle = slot.getVehicle();
            if (vehicle != null) {
                if (vehicle.isEvenRegistration(vehicle.getRegistrationNumber())) {
                    result.add(vehicle.getRegistrationNumber());
                }
            }
        }
        System.out.println(String.join(", ", result));
    }

    public void vehiclesByColor(String color) {
        List<String> result = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            Vehicle vehicle = slot.getVehicle();
            if (vehicle != null && vehicle.getColor().equalsIgnoreCase(color)) {
                result.add(vehicle.getRegistrationNumber());
            }
        }
        System.out.println(String.join(", ", result));
    }

    public void slotByColor(String color) {
        List<Integer> result = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            Vehicle vehicle = slot.getVehicle();
            if (vehicle != null && vehicle.getColor().equalsIgnoreCase(color)) {
                result.add(slot.getSlotNumber());
            }
        }
        System.out.println(result.toString());
    }

    public void slotByRegistrationNumber(String regNumber) {
        for (ParkingSlot slot : slots) {
            Vehicle vehicle = slot.getVehicle();
            if (vehicle != null && vehicle.getRegistrationNumber().equals(regNumber)) {
                System.out.println(slot.getSlotNumber());
                return;
            }
        }
        System.out.println("Not found");
    }
}
