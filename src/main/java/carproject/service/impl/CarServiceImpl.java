package carproject.service.impl;

import carproject.dao.CarDao;
import carproject.model.Car;
import carproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public Long add(Car car) {
        return carDao.add(car);
    }

    @Override
    public Car findById(Long id) {
        return carDao.findById(id);
    }
}
