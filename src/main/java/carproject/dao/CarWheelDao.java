package carproject.dao;

import carproject.model.CarWheel;

public interface CarWheelDao {
    Long add(CarWheel wheel);

    CarWheel findById(Long id);
}
