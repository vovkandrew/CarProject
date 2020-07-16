package carproject.mapper;

import carproject.dto.WheelResponseDto;
import carproject.model.CarWheel;
import org.springframework.stereotype.Component;

@Component
public class WheelMapper {
    public WheelResponseDto getWheelResponseDtoFromCarWheel(CarWheel carWheel) {
        return new WheelResponseDto(carWheel.getWheelState());
    }
}
