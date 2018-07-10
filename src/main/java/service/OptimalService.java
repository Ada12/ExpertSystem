package service;

import dao.OptimalDao;
import entity.BasicApplyEntity;
import entity.PreOptimizationInstanceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yangchen on 2018/4/7.
 */
@Transactional
@Service
public class OptimalService {
    @Autowired
    private OptimalDao optimalDao;

    public Object getLibrary(String typeName) {
        if (typeName.equals("bstMc")) {
            return optimalDao.getLibBstMc();
        } else if (typeName.equals("abs")) {
            return optimalDao.getLibControl();
        } else if (typeName.equals("pedal")) {
            return optimalDao.getLibPedal();
        } else if (typeName.equals("tire")) {
            return optimalDao.getLibTire();
        } else if (typeName.equals("vehicle")) {
            return optimalDao.getLibVehicle();
        } else if (typeName.equals("discCaliper") || typeName.equals("drumCaliper")) {
            return optimalDao.getLibCaliper();
        } else if (typeName.equals("discLining") || typeName.equals("drumLining")) {
            return optimalDao.getLibLining();
        } else if (typeName.equals("frtRotor") || typeName.equals("rrRotor")) {
            return optimalDao.getLibRotor();
        } else {
            return "Please enter a right type";
        }
    }

    public List<PreOptimizationInstanceEntity> getOptimizationDesc(int userId) {
        return optimalDao.getOptimizationDesc(userId);
    }

    public PreOptimizationInstanceEntity getOptimization(String description, int userId) {
        return optimalDao.getOptimization(description, userId);
    }

    public boolean addNewOptimization(PreOptimizationInstanceEntity entity) {
        return optimalDao.addNewOptimization(entity);
    }

    public boolean deleteOptimization(String description, int userId) {
        return optimalDao.deleteOptimization(description, userId);
    }
}
