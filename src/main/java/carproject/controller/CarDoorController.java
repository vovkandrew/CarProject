package carproject.controller;

import carproject.dto.CarDoorRequestDto;
import carproject.dto.CarDoorResponseDto;
import carproject.mapper.DoorMapper;
import carproject.model.CarDoor;
import carproject.service.CarDoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-door")
public class CarDoorController {
    @Autowired
    private DoorMapper doorMapper;

    @Autowired
    private CarDoorService carDoorService;

    @PostMapping("/add-door")
    public CarDoorResponseDto add(@RequestBody CarDoorRequestDto carDoorRequestDto) {
        CarDoor door = doorMapper.getCarDoorFromCarDoorRequestDto(carDoorRequestDto);
        carDoorService.add(door);
        return doorMapper.getCarDoorResponseDtoFromCarDoor(door);
    }

    @GetMapping("/find-by-id")
    public CarDoorResponseDto findById(@RequestParam Long id) {
        CarDoor door = carDoorService.findById(id);
        return doorMapper.getCarDoorResponseDtoFromCarDoor(door);
    }
}
