package carproject.service;

import carproject.model.CarDoor;

public interface CarDoorService {
    Long add(CarDoor door);

    CarDoor findById(Long id);
}
