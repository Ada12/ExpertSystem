package dao;

import entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by yangchen on 17/9/5.
 */
@Repository
public class BasicDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // basic apply
    public List<BasicApplyEntity> getBasicApplyDesc() {
        TypedQuery<BasicApplyEntity> query;
        query = entityManager.createQuery("select b from BasicApplyEntity b", BasicApplyEntity.class);
        List<BasicApplyEntity> entities = query.getResultList();
        return entities;
    }

    public BasicApplyEntity getBasicApply(String description) {
        TypedQuery<BasicApplyEntity> query;
        query = entityManager.createQuery("select b from BasicApplyEntity b where b.description = :description", BasicApplyEntity.class);
        query.setParameter("description", description);
        BasicApplyEntity entities = new BasicApplyEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
           System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean addNewApply(BasicApplyEntity entity) {
        try {
            entityManager.persist(entity);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // basic control
    public List<BasicControlEntity> getBasicControlDesc() {
        TypedQuery<BasicControlEntity> query;
        query = entityManager.createQuery("select b from BasicControlEntity b", BasicControlEntity.class);
        List<BasicControlEntity> entities = query.getResultList();
        return entities;
    }

    public BasicControlEntity getBasicControl(String description) {
        TypedQuery<BasicControlEntity> query;
        query = entityManager.createQuery("select b from BasicControlEntity b where b.description = :description", BasicControlEntity.class);
        query.setParameter("description", description);
        BasicControlEntity entities = new BasicControlEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean addNewControl(BasicControlEntity entity) {
        try {
            entityManager.persist(entity);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // basic disc brake
    public List<BasicDiscBrakeEntity> getBasicDiscBrakeDesc() {
        TypedQuery<BasicDiscBrakeEntity> query;
        query = entityManager.createQuery("select b from BasicDiscBrakeEntity b", BasicDiscBrakeEntity.class);
        List<BasicDiscBrakeEntity> entities = query.getResultList();
        return entities;
    }

    public BasicDiscBrakeEntity getBasicDiscBrake(String description) {
        TypedQuery<BasicDiscBrakeEntity> query;
        query = entityManager.createQuery("select b from BasicDiscBrakeEntity b where b.description = :description", BasicDiscBrakeEntity.class);
        query.setParameter("description", description);
        BasicDiscBrakeEntity entities = new BasicDiscBrakeEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean addNewDiscBrake(BasicDiscBrakeEntity entity) {
        try {
            entityManager.persist(entity);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // basic drum brake
    public List<BasicDrumBrakeEntity> getBasicDrumBrakeDesc() {
        TypedQuery<BasicDrumBrakeEntity> query;
        query = entityManager.createQuery("select b from BasicDrumBrakeEntity b", BasicDrumBrakeEntity.class);
        List<BasicDrumBrakeEntity> entities = query.getResultList();
        return entities;
    }

    public BasicDrumBrakeEntity getBasicDrumBrake(String description) {
        TypedQuery<BasicDrumBrakeEntity> query;
        query = entityManager.createQuery("select b from BasicDrumBrakeEntity b where b.description = :description", BasicDrumBrakeEntity.class);
        query.setParameter("description", description);
        BasicDrumBrakeEntity entities = new BasicDrumBrakeEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean addNewDrumBrake(BasicDrumBrakeEntity entity) {
        try {
            entityManager.persist(entity);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // basic tire wheel
    public List<BasicTireWheelEntity> getBasicTireWheelDesc() {
        TypedQuery<BasicTireWheelEntity> query;
        query = entityManager.createQuery("select b from BasicTireWheelEntity b", BasicTireWheelEntity.class);
        List<BasicTireWheelEntity> entities = query.getResultList();
        return entities;
    }

    public BasicTireWheelEntity getBasicTireWheel(String description) {
        TypedQuery<BasicTireWheelEntity> query;
        query = entityManager.createQuery("select b from BasicTireWheelEntity b where b.description = :description", BasicTireWheelEntity.class);
        query.setParameter("description", description);
        BasicTireWheelEntity entities = new BasicTireWheelEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean addNewTireWheel(BasicTireWheelEntity entity) {
        try {
            entityManager.persist(entity);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // basic vehicle
    public List<BasicVehicleEntity> getBasicVehicleDesc() {
        TypedQuery<BasicVehicleEntity> query;
        query = entityManager.createQuery("select b from BasicVehicleEntity b", BasicVehicleEntity.class);
        List<BasicVehicleEntity> entities = query.getResultList();
        return entities;
    }

    public BasicVehicleEntity getBasicVehicle(String description) {
        TypedQuery<BasicVehicleEntity> query;
        query = entityManager.createQuery("select b from BasicVehicleEntity b where b.description = :description", BasicVehicleEntity.class);
        query.setParameter("description", description);
        BasicVehicleEntity entities = new BasicVehicleEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean addNewVehicle(BasicVehicleEntity entity) {
        try {
            entityManager.persist(entity);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // Configuration !!!!!!!!!!!!!!!
    public List<ConfigurationEntity> getBasicConfigurationDesc() {
        TypedQuery<ConfigurationEntity> query;
        query = entityManager.createQuery("select b from ConfigurationEntity b", ConfigurationEntity.class);
        List<ConfigurationEntity> entities = query.getResultList();
        return entities;
    }

    public ConfigurationEntity getBasicConfiguration(String description) {
        TypedQuery<ConfigurationEntity> query;
        query = entityManager.createQuery("select b from ConfigurationEntity b where b.description = :description", ConfigurationEntity.class);
        query.setParameter("description", description);
        ConfigurationEntity entities = new ConfigurationEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean addNewConfiguration(ConfigurationEntity entity) {
        try {
            entityManager.persist(entity);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<UnitsEntity> getUnits() {
        TypedQuery<UnitsEntity> query;
        query = entityManager.createQuery("select b from UnitsEntity b", UnitsEntity.class);
        List<UnitsEntity> entities = query.getResultList();
        return entities;
    }
}
