package console;

import entity.Vehicle;
import service.ParkingLot;

import java.util.Scanner;

public class Menu {
    public void choiceMenu(){
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = null;
        System.out.println("create_parking_lot");
        System.out.println("park");
        System.out.println("leave");
        System.out.println("status");
        System.out.println("type_of_vehicles");
        System.out.println("registration_numbers_for_vehicles_with_ood_plate");
        System.out.println("registration_numbers_for_vehicles_with_event_plate");
        System.out.println("registration_numbers_for_vehicles_with_colour");
        System.out.println("slot_numbers_for_vehicles_with_colour");
        System.out.println("slot_number_for_registration_number");
        System.out.println("exit");
        System.out.println("choice menu: ");

        while (true) {
            String command = scanner.nextLine();
            String[] input = command.split(" ");

            switch (input[0]) {
                case "create_parking_lot":
                    int size = Integer.parseInt(input[1]);
                    parkingLot = new ParkingLot(size);
                    System.out.println("Created a parking lot with " + size + " slots");
                    break;
                case "park":
                    String regNumber = input[1];
                    String color = input[2];
                    String type = input[3];
                    Vehicle vehicle = new Vehicle(regNumber, color, type);
                    if (parkingLot != null) {
                        parkingLot.parkVehicle(vehicle);
                    }
                    break;
                case "leave":
                    int slotNumber = Integer.parseInt(input[1]);
                    if (parkingLot != null) {
                        parkingLot.leave(slotNumber);
                    }
                    break;
                case "status":
                    if (parkingLot != null) {
                        parkingLot.status();
                    }
                    break;
                case "type_of_vehicles":
                    if (parkingLot != null) {
                        parkingLot.vehiclesByType(input[1]);
                    }
                    break;
                case "registration_numbers_for_vehicles_with_ood_plate":
                    if (parkingLot != null) {
                        parkingLot.vehiclesByOdd();
                    }
                    break;
                case "registration_numbers_for_vehicles_with_event_plate":
                    if (parkingLot != null) {
                        parkingLot.vehiclesByEven();
                    }
                    break;
                case "registration_numbers_for_vehicles_with_colour":
                    if (parkingLot != null) {
                        parkingLot.vehiclesByColor(input[1]);
                    }
                    break;
                case "slot_numbers_for_vehicles_with_colour":
                    if (parkingLot != null) {
                        parkingLot.slotByColor(input[1]);
                    }
                    break;
                case "slot_number_for_registration_number":
                    if (parkingLot != null) {
                        parkingLot.slotByRegistrationNumber(input[1]);
                    }
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

}
