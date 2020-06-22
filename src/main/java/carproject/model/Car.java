package carproject.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Car {
    private final LocalDate releaseDate;
    private String engineType;
    private int maxSpeed;
    private double accelerationTo100;
    private int numberOfSeats;
    private int currentNumberOfPassengers;
    private int currentSpeed;
    private ArrayList<CarDoor> carDoors;
    private ArrayList<CarWheel> carWheels;

    public Car(LocalDate releaseDate, String engineType, int maxSpeed, double accelerationTo100,
               int numberOfSeats, int currentNumberOfPassengers, int currentSpeed,
               ArrayList<CarDoor> carDoors, ArrayList<CarWheel> carWheels) {
        this.releaseDate = releaseDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.accelerationTo100 = accelerationTo100;
        this.numberOfSeats = numberOfSeats;
        this.currentNumberOfPassengers = currentNumberOfPassengers;
        this.currentSpeed = currentSpeed;
        this.carDoors = carDoors;
        this.carWheels = carWheels;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAccelerationTo100() {
        return accelerationTo100;
    }

    public void setAccelerationTo100(double accelerationTo100) {
        this.accelerationTo100 = accelerationTo100;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getCurrentNumberOfPassengers() {
        return currentNumberOfPassengers;
    }

    public void setCurrentNumberOfPassengers(int currentNumberOfPassengers) {
        this.currentNumberOfPassengers = currentNumberOfPassengers;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public ArrayList<CarDoor> getCarDoors() {
        return carDoors;
    }

    public void setCarDoors(ArrayList<CarDoor> carDoors) {
        this.carDoors = carDoors;
    }

    public ArrayList<CarWheel> getCarWheels() {
        return carWheels;
    }

    public void setCarWheels(ArrayList<CarWheel> carWheels) {
        this.carWheels = carWheels;
    }

    @Override
    public String toString() {
        return "Car{"
                + "releaseDate="
                + releaseDate
                + ", engineType='"
                + engineType
                + '\''
                + ", maxSpeed="
                + maxSpeed
                + ", accelerationTo100="
                + accelerationTo100
                + ", numberOfSeats="
                + numberOfSeats
                + ", currentNumberOfPassengers="
                + currentNumberOfPassengers
                + ", currentSpeed="
                + currentSpeed
                + ", carDoors="
                + carDoors
                + ", carWheels="
                + carWheels
                + '}'
                + "current max speed"
                + getCurrentMaxSpeed();
    }

    public void changeCurrentCarSpeed(int speed) {
        setCurrentSpeed(speed);
    }

    public void addOnePassenger() {
        int currentNumberOfPassengers = getCurrentNumberOfPassengers();
        setCurrentNumberOfPassengers(currentNumberOfPassengers + 1);
    }

    public void removeOnePassenger() {
        int currentNumberOfPassengers = getCurrentNumberOfPassengers();
        setCurrentNumberOfPassengers(currentNumberOfPassengers - 1);
    }

    public void removeAllPassengers() {
        while (getCurrentNumberOfPassengers() != 0) {
            removeOnePassenger();
        }
    }

    public CarDoor getDoorByIndex(int doorIndex) {
        return getCarDoors().get(doorIndex);
    }

    public CarWheel getWheelByIndex(int wheelIndex) {
        return getCarWheels().get(wheelIndex);
    }

    public void removeAllWheelsFromCar() {
        getCarWheels().clear();
    }

    public void addNewWheels(int numberOfNewWheels) {
        ArrayList<CarWheel> currentWheels = getCarWheels();
        while (numberOfNewWheels != 0) {
            currentWheels.add(new CarWheel(1));
            numberOfNewWheels--;
        }
        setCarWheels(currentWheels);
    }

    public int getCurrentMaxSpeed() {
        if (getCurrentNumberOfPassengers() == 0) {
            return 0;
        } else {
            CarWheel theMostWornWheel = getCarWheels()
                    .stream()
                    .min(Comparator.comparing(CarWheel::getWheelState)).get();
            return (int) (getMaxSpeed() * theMostWornWheel.getWheelState());
        }
    }
}
