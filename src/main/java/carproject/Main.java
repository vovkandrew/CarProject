package carproject;

import carproject.config.AppConfig;
import carproject.model.Car;
import carproject.model.CarDoor;
import carproject.model.CarWheel;
import carproject.service.CarDoorService;
import carproject.service.CarService;
import carproject.service.CarWheelService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        CarWheelService carWheelService = context.getBean(CarWheelService.class);
        CarWheel wheel1 = new CarWheel(1);
        System.out.println(carWheelService.add(wheel1));
        System.out.println(carWheelService.findById(1L));
        CarWheel wheel2 = new CarWheel(0.9);
        carWheelService.add(wheel2);
        CarWheel wheel3 = new CarWheel(0.8);
        carWheelService.add(wheel3);
        CarWheel wheel4 = new CarWheel(0.7);
        carWheelService.add(wheel4);
        CarDoor leftFront = new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED);
        CarDoorService carDoorService = context.getBean(CarDoorService.class);
        System.out.println(carDoorService.add(leftFront));
        System.out.println(carDoorService.findById(1L));
        CarDoor rightFront = new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED);
        carDoorService.add(rightFront);
        CarDoor leftBack = new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED);
        carDoorService.add(leftBack);
        CarDoor rightBack = new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED);
        carDoorService.add(rightBack);
        List<CarWheel> wheels = List.of(wheel1, wheel2, wheel3, wheel4);
        List<CarDoor> doors = List.of(rightFront, leftFront, rightBack, leftBack);
        Car car = new Car(LocalDate.now(), "Diesel", 200,
                5.5, 5, 0, 0,
                doors, wheels);
        CarService carService = context.getBean(CarService.class);
        System.out.println(carService.add(car));
        System.out.println(carService.findById(1L));
    }
}
