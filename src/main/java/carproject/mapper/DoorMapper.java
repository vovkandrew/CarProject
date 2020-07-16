package carproject.mapper;

import carproject.dto.CarDoorRequestDto;
import carproject.dto.CarDoorResponseDto;
import carproject.model.CarDoor;
import org.springframework.stereotype.Component;

@Component
public class DoorMapper {
    public CarDoor getCarDoorFromCarDoorRequestDto(CarDoorRequestDto carDoorRequestDto) {
        return new CarDoor(CarDoor.DoorState.valueOf(carDoorRequestDto.getDoorState()),
                CarDoor.WindowState.valueOf(carDoorRequestDto.getWindowState()));
    }

    public CarDoorResponseDto getCarDoorResponseDtoFromCarDoor(CarDoor door) {
        return new CarDoorResponseDto(door.getDoorState().toString(),
                door.getWindowState().toString());
    }
}
