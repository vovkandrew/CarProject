package carproject.model;

import junit.framework.TestCase;
import java.time.LocalDate;
import java.util.ArrayList;

public class CarTest extends TestCase {
    private Car car = init();

    private Car init() {
        CarWheel one = new CarWheel(1);
        CarWheel two = new CarWheel(0.9);
        CarWheel three = new CarWheel(0.8);
        CarWheel four = new CarWheel(0.7);
        ArrayList<CarWheel> wheels = new ArrayList<>();
        wheels.add(one);
        wheels.add(two);
        wheels.add(three);
        wheels.add(four);
        CarDoor leftFront = new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED);
        CarDoor rightFront = new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED);
        CarDoor leftBack = new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED);
        CarDoor rightBack = new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED);
        ArrayList<CarDoor> doors = new ArrayList<>();
        doors.add(leftBack);
        doors.add(leftFront);
        doors.add(leftBack);
        doors.add(rightBack);
        return new Car(LocalDate.now(), "Diesel", 200,
                5.5, 5, 0, 0,
                doors, wheels);
    }

    public void testChangeCurrentCarSpeed() {
        int expected = 100;
        car.changeCurrentCarSpeed(100);
        int actual = car.getCurrentSpeed();
        assertEquals("Testing current speed change", expected, actual);
    }

    public void testAddOnePassenger() {
        int expected = 1;
        car.addOnePassenger();
        int actual = car.getCurrentNumberOfPassengers();
        assertEquals("Adding a passenger to the car", expected, actual);
    }

    public void testRemoveOnePassenger() {
        int expected = 1;
        car.addOnePassenger();
        car.addOnePassenger();
        car.removeOnePassenger();
        int actual = car.getCurrentNumberOfPassengers();
        assertEquals("Testing one passenger removal", expected, actual);
    }

    public void testRemoveAllPassengers() {
        int expected = 0;
        car.addOnePassenger();
        car.addOnePassenger();
        car.addOnePassenger();
        car.addOnePassenger();
        car.removeAllPassengers();
        int actual = car.getCurrentNumberOfPassengers();
        assertEquals("Testing all passengers removal", expected, actual);
    }

    public void testGetDoorByIndex() {
        CarDoor expected = car.getCarDoors().get(2);
        CarDoor actual = car.getDoorByIndex(2);
        assertEquals("Testing getting a door by index", expected, actual);
    }

    public void testGetWheelByIndex() {
        CarWheel expected = car.getCarWheels().get(3);
        CarWheel actual = car.getWheelByIndex(3);
        assertEquals("Testing getting a wheel by index", expected, actual);
    }

    public void testRemoveAllWheelsFromCar() {
        ArrayList<CarWheel> expected = new ArrayList<>();
        car.removeAllWheelsFromCar();
        ArrayList<CarWheel> actual = car.getCarWheels();
        assertEquals("Testing all wheels removal from the car", expected, actual);
    }

    public void testAddNewWheels() {
        int expected = 6;
        car.addNewWheels(2);
        int actual = car.getCarWheels().size();
        assertEquals("Testing adding a particular number of wheels to the car", expected, actual);
    }

    public void testGetCurrentMaxSpeed() {
        int expected = 140;
        car.addOnePassenger();
        int actual = car.getCurrentMaxSpeed();
        assertEquals("Testing getting of the max current speed", expected, actual);
    }
}