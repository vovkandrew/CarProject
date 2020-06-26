package carproject.service;

import carproject.model.CarWheel;

public interface CarWheelService {
    Long add(CarWheel wheel);

    CarWheel findById(Long id);

}
