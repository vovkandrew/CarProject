package carproject.service.impl;

import carproject.dao.CarDoorDao;
import carproject.model.CarDoor;
import carproject.service.CarDoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarDoorServiceImpl implements CarDoorService {
    @Autowired
    private CarDoorDao carDoorDao;

    @Override
    public Long add(CarDoor door) {
        return carDoorDao.add(door);
    }

    @Override
    public CarDoor findById(Long id) {
        return carDoorDao.findById(id);
    }
}
