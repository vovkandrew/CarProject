package carproject.dao;

import carproject.model.CarDoor;

public interface CarDoorDao {
    Long add(CarDoor door);

    CarDoor findById(Long id);
}
