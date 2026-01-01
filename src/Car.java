public class Car extends Vehicle implements Servicable {

    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors <= 0) {
            throw new IllegalArgumentException("Number of doors must be > 0");
        }
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        int age = getAge(2025);
        return basePrice * 0.02 + age * 50;
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                ", doors=" + numberOfDoors +
                '}';
    }
    @Override
    public void performService() {
        System.out.println("Performing service for car: oil change and inspection");
    }

    @Override
    public int getServiceIntervalKm() {
        return 15000;
    }
}
