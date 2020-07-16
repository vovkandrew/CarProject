package carproject.service.impl;

import carproject.dao.CarWheelDao;
import carproject.model.CarWheel;
import carproject.service.CarWheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarWheelServiceImpl implements CarWheelService {
    @Autowired
    private CarWheelDao carWheelDao;

    @Override
    public Long add(CarWheel wheel) {
        return carWheelDao.add(wheel);
    }

    @Override
    public CarWheel findById(Long id) {
        return carWheelDao.findById(id);
    }
}
