package carproject.controller;

import carproject.dto.CarRequestDto;
import carproject.dto.CarResponseDto;
import carproject.mapper.CarMapper;
import carproject.model.Car;
import carproject.service.CarDoorService;
import carproject.service.CarService;
import carproject.service.CarWheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private CarDoorService carDoorService;

    @Autowired
    private CarWheelService carWheelService;

    @Autowired
    private CarMapper carMapper;

    @PostMapping("/new")
    public CarResponseDto add(@RequestBody CarRequestDto car) {
        Car newCar = carMapper.getCarFromCarRequestDto(car);
        newCar.getCarWheels().stream().map(wheel -> carWheelService.add(wheel));
        newCar.getCarDoors().stream().map(door -> carDoorService.add(door));
        carService.add(newCar);
        return carMapper.getCarResponseDtoFromCar(newCar);
    }

    @GetMapping("/{id}")
    public CarResponseDto findById(@PathVariable Long id) {
        Car car = carService.findById(id);

        return carMapper.getCarResponseDtoFromCar(car);
    }
}
