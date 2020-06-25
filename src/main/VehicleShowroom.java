package main;

import vehicle.Vehicle;
import vehicle.NormalVehicle;
import vehicle.HeavyVehicle;
import vehicle.SportsVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by A.A.MAMUN on 6/25/2020.
 */
public class VehicleShowroom {

    static int visitor = 30;

    public static void main(String[] args) {

        List<Vehicle> vehicleList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.print("1. Add Vehicle\n2. Remove Vehicle\n3. Show Vehicles\n" +
                    "4. Show vehicles with current expected visitor\n5. Exit\n");
            System.out.print("Please enter option : ");
            int option = scanner.nextInt();
            if(option==1){
                addVehicle(vehicleList);
            }else if(option==2){
                if(vehicleList.size()==0){
                    System.out.println("Vehicle list is empty. Please add vehicle at first.");
                }else {
                    showVehicles(vehicleList);
                    removeVehicle(vehicleList);
                }
            }else if(option==3){
                showVehicles(vehicleList);
            }else if(option==4){
                showVehicles(vehicleList);
                System.out.println("Current expected visitor : " + visitor);
            }else if(option==5){
                break;
            }else {
                System.out.println("Invalid option. Please try again.");
            }
            System.out.println("-----------------------------------------");
        }

    }

    /**
     * method for add vehicle
     */
    public static void addVehicle(List<Vehicle> vehicleList){

        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Normal Vehicle\n2. Sports Vehicle\n3. Heavy Vehicle\nPlease select an option : ");
        int option = scanner.nextInt();
        Vehicle vehicle = null;
        if(option > 0 && option < 4){

            System.out.print("Enter model number : ");
            String modelNumber = scanner.next();
            System.out.print("Enter engine power : ");
            String enginePower = scanner.next();
            System.out.print("Enter tire size : ");
            String tireSize = scanner.next();

            if(option == 1){

                String engineType;
                int type;
                while (true) {
                    System.out.print("1. Diesel\n2. Gas\n3. Oil\nPlease choose engine type : ");
                    type = scanner.nextInt();
                    if(type < 1 || type > 3){
                        System.out.println("Invalid option. Please try again.");
                    }else {
                        switch (type) {
                            case 1:
                                engineType = Vehicle.DIESEL;
                                break;
                            case 2:
                                engineType = Vehicle.GAS;
                                break;
                            default:
                                engineType = Vehicle.OIL;
                                break;
                        }
                        break;
                    }
                }
                vehicle = new NormalVehicle(modelNumber, engineType, enginePower, tireSize);

            }else if(option == 2){
                System.out.print("Turbo : ");
                String turbo = scanner.next();
                vehicle = new SportsVehicle(modelNumber, enginePower, tireSize, turbo);
               visitor = visitor + 20;
            }else {
                System.out.print("Enter weight : ");
                String weight = scanner.next();
                vehicle = new HeavyVehicle(modelNumber, enginePower, tireSize, weight);

            }
            vehicleList.add(vehicle);
            System.out.println("Vehicle successfully added!");
        }else {
            System.out.println("Invalid option.");
            return;
        }
    }

    /**
     * method for remove vehicle from list.
     */
    public static void removeVehicle(List<Vehicle> vehicleList){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the SL No. to remove vehicle : ");
        int position = scanner.nextInt();

        if(position>0 && position<=vehicleList.size()){
            Vehicle vehicle = vehicleList.get(position-1);
            if(vehicle instanceof SportsVehicle){
                visitor = visitor - 20;
            }
            vehicleList.remove(position-1);
            System.out.println("Successfully removed!");
        }else {
            System.out.println("Invalid SL No. please try later with valid one");
        }
    }

    /**
     * show the all current vehicles.
     */
    public static void showVehicles(List<Vehicle> vehicleList){
        System.out.println("# Vehicle List :");
        if(vehicleList.size()==0){
            System.out.println("Vehicle list is empty.");
            return;
        }

        for (int i = 0; i <vehicleList.size(); i++){
            System.out.println((i+1)+". "+vehicleList.get(i));
        }
    }

}
