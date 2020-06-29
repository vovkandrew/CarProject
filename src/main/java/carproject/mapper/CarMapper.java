package carproject.mapper;

import carproject.dto.CarRequestDto;
import carproject.dto.CarResponseDto;
import carproject.model.Car;
import carproject.model.CarDoor;
import carproject.model.CarWheel;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public CarResponseDto getCarResponseDtoFromCar(Car car) {
        String release = car.getReleaseDate().toString();
        String type = car.getEngineType();
        int speed = car.getMaxSpeed();
        double acceleration = car.getAccelerationTo100();
        int seats = car.getNumberOfSeats();
        return new CarResponseDto(release, type, speed, acceleration, seats);
    }

    public Car getCarFromCarRequestDto(CarRequestDto carRequestDto) {
        LocalDate release = LocalDate.parse(carRequestDto.getReleaseDate());
        String type = carRequestDto.getEngineType();
        int speed = carRequestDto.getMaxSpeed();
        double acceleration = carRequestDto.getAccelerationTo100();
        int seats = carRequestDto.getNumberOfSeats();
        List<CarWheel> wheels = List.of(new CarWheel(1),
                                        new CarWheel(1),
                                        new CarWheel(1),
                                        new CarWheel(1));
        List<CarDoor> doors =
                List.of(new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED),
                        new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED),
                        new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED),
                        new CarDoor(CarDoor.DoorState.CLOSED, CarDoor.WindowState.CLOSED));
        return new Car(release, type, speed, acceleration, seats,
                0, 0, doors, wheels);
    }
}
