package carproject.controller;

import carproject.dto.WheelResponseDto;
import carproject.mapper.WheelMapper;
import carproject.model.CarWheel;
import carproject.service.CarWheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-wheel")
public class CarWheelController {
    @Autowired
    private CarWheelService carWheelService;

    @Autowired
    private WheelMapper wheelMapper;

    @PostMapping("/new")
    public WheelResponseDto add(@RequestParam double wheelState) {
        CarWheel wheel = new CarWheel(wheelState);
        carWheelService.add(wheel);
        return wheelMapper.getWheelResponseDtoFromCarWheel(wheel);
    }

    @GetMapping("/{id}")
    public WheelResponseDto findById(@PathVariable Long id) {
        CarWheel wheel = carWheelService.findById(id);
        return wheelMapper.getWheelResponseDtoFromCarWheel(wheel);
    }
}
