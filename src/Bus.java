public class Bus extends Vehicle implements Servicable {

    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Passenger capacity must be > 0");
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        int age = getAge(2025);
        return basePrice * 0.03 + passengerCapacity * 10 + age * 30;
    }

    @Override
    public String toString() {
        return "Bus{" +
                super.toString() +
                ", capacity=" + passengerCapacity +
                '}';
    }
    @Override
    public void performService() {
        System.out.println("Performing service for bus: full technical inspection");
    }

    @Override
    public int getServiceIntervalKm() {
        return 30000;
    }
}

