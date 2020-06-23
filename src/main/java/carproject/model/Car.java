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

    public static class CarBuilder {
        private LocalDate releaseDate;
        private String engineType;
        private int maxSpeed;
        private double accelerationTo100;
        private int numberOfSeats;
        private int currentNumberOfPassengers;
        private int currentSpeed;
        private ArrayList<CarDoor> carDoors;
        private ArrayList<CarWheel> carWheels;

        public CarBuilder setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public CarBuilder setEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public CarBuilder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public CarBuilder setAccelerationTo100(double accelerationTo100) {
            this.accelerationTo100 = accelerationTo100;
            return this;
        }

        public CarBuilder setNumberOfSeats(int numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
            return this;
        }

        public CarBuilder setCurrentNumberOfPassengers(int currentNumberOfPassengers) {
            this.currentNumberOfPassengers = currentNumberOfPassengers;
            return this;
        }

        public CarBuilder setCurrentSpeed(int currentSpeed) {
            this.currentSpeed = currentSpeed;
            return this;
        }

        public CarBuilder setCarDoors(ArrayList<CarDoor> carDoors) {
            this.carDoors = carDoors;
            return this;
        }

        public CarBuilder setCarWheels(ArrayList<CarWheel> carWheels) {
            this.carWheels = carWheels;
            return this;
        }

        public Car build() {
            return new Car(releaseDate, engineType, maxSpeed, accelerationTo100, numberOfSeats,
                    currentNumberOfPassengers, currentSpeed, carDoors, carWheels);
        }
    }
}
