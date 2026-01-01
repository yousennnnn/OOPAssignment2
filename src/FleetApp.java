import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FleetApp {

    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> printAllVehicles();
                case 2 -> addCar();
                case 3 -> addBus();
                case 4 -> showTotalInsurance();
                case 5 -> showVehiclesOlderThanN();
                case 6 -> performServiceForAll();
                case 7 -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nFleet Management System");
        System.out.println("1. Print all vehicles");
        System.out.println("2. Add new car");
        System.out.println("3. Add new bus");
        System.out.println("4. Show total yearly insurance fees");
        System.out.println("5. Show vehicles older than N years");
        System.out.println("6. Perform service for all vehicles");
        System.out.println("7. Quit");
        System.out.print("Choose option: ");
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet");
            return;
        }

        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void addCar() {
        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("Base price: ");
        double price = scanner.nextDouble();

        System.out.print("Number of doors: ");
        int doors = scanner.nextInt();
        scanner.nextLine();

        vehicles.add(new Car(model, year, price, doors));
        System.out.println("Car added");
    }

    private void addBus() {
        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("Base price: ");
        double price = scanner.nextDouble();

        System.out.print("Passenger capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        vehicles.add(new Bus(model, year, price, capacity));
        System.out.println("Bus added");
    }

    private void showTotalInsurance() {
        double total = 0;

        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }

        System.out.println("Total yearly insurance fee: " + total);
    }

    private void showVehiclesOlderThanN() {
        System.out.print("Current year: ");
        int currentYear = scanner.nextInt();

        System.out.print("N years: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
            }
        }
    }

    private void performServiceForAll() {
        for (Vehicle v : vehicles) {
            if (v instanceof Servicable) {
                ((Servicable) v).performService();
            }
        }
    }
}

