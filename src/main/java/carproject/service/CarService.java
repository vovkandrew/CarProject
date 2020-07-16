package carproject.service;

import carproject.model.Car;

public interface CarService {
    Long add(Car car);

    Car findById(Long id);
}
