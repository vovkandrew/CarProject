package carproject.dao;

import carproject.model.Car;

public interface CarDao {
    Long add(Car car);

    Car findById(Long id);
}
