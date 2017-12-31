package dao;

import entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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
            entityManager.flush();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteApply(String description) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicApplyEntity b where b.description = '" + description + "'",
                    BasicApplyEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
            entityManager.flush();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteControl(String description) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicControlEntity b where b.description = '" + description + "'",
                    BasicControlEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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

    public boolean deleteDiscBrake(String description) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicDiscBrakeEntity b where b.description = '" + description + "'",
                    BasicDiscBrakeEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addNewDiscBrake(BasicDiscBrakeEntity entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();
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
            entityManager.flush();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteDrumBrake(String description) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicDrumBrakeEntity b where b.description = '" + description + "'",
                    BasicDrumBrakeEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // get vented rotor
    public BasicVentedRotorEntity getBasicVentedRotor(int id) {
        TypedQuery<BasicVentedRotorEntity> query;
        query = entityManager.createQuery("select b from BasicVentedRotorEntity b where b.id = :id", BasicVentedRotorEntity.class);
        query.setParameter("id", id);
        BasicVentedRotorEntity entities = new BasicVentedRotorEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public int addNewVentedRotor(BasicVentedRotorEntity entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return entity.getId();
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public boolean deleteVentedRotor(int id) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicVentedRotorEntity b where b.id = " + id + "",
                    BasicVentedRotorEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // get solid rotor
    public BasicSolidRotorEntity getBasicSolidRotor(int id) {
        TypedQuery<BasicSolidRotorEntity> query;
        query = entityManager.createQuery("select b from BasicSolidRotorEntity b where b.id = :id", BasicSolidRotorEntity.class);
        query.setParameter("id", id);
        BasicSolidRotorEntity entities = new BasicSolidRotorEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public int addNewSolidRotor(BasicSolidRotorEntity entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return entity.getId();
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public boolean deleteSolidRotor(int id) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicSolidRotorEntity b where b.id = " + id + "",
                    BasicSolidRotorEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // get drum rotor
    public BasicDrumRotorEntity getBasicDrumRotor(int id) {
        TypedQuery<BasicDrumRotorEntity> query;
        query = entityManager.createQuery("select b from BasicDrumRotorEntity b where b.id = :id", BasicDrumRotorEntity.class);
        query.setParameter("id", id);
        BasicDrumRotorEntity entities = new BasicDrumRotorEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public int addNewDrumRotor(BasicDrumRotorEntity entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return entity.getId();
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public boolean deleteDrumRotor(int id) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicDrumRotorEntity b where b.id = " + id + "",
                    BasicDrumRotorEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    // basic tire wheel
    public List<BasicTireEntity> getBasicTireWheelDesc() {
        TypedQuery<BasicTireEntity> query;
        query = entityManager.createQuery("select b from BasicTireEntity b", BasicTireEntity.class);
        List<BasicTireEntity> entities = query.getResultList();
        return entities;
    }

    public BasicTireEntity getBasicTireWheel(String description) {
        TypedQuery<BasicTireEntity> query;
        query = entityManager.createQuery("select b from BasicTireEntity b where b.description = :description", BasicTireEntity.class);
        query.setParameter("description", description);
        BasicTireEntity entities = new BasicTireEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean addNewTireWheel(BasicTireEntity entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteTireWheel(String description) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicTireEntity b where b.description = '" + description + "'",
                    BasicTireEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
            entityManager.flush();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteVehicle(String description) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicVehicleEntity b where b.description = '" + description + "'",
                    BasicVehicleEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // basic requirement
    public List<BasicRequirementEntity> getBasicRequirementDesc() {
        TypedQuery<BasicRequirementEntity> query;
        query = entityManager.createQuery("select b from BasicRequirementEntity b", BasicRequirementEntity.class);
        List<BasicRequirementEntity> entities = query.getResultList();
        return entities;
    }

    public BasicRequirementEntity getBasicRequirement(String description) {
        TypedQuery<BasicRequirementEntity> query;
        query = entityManager.createQuery("select b from BasicRequirementEntity b where b.description = :description", BasicRequirementEntity.class);
        query.setParameter("description", description);
        BasicRequirementEntity entities = new BasicRequirementEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean addNewRequirement(BasicRequirementEntity entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteRequirement(String description) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicRequirementEntity b where b.description = '" + description + "'",
                    BasicRequirementEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
            entityManager.flush();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteConfiguration(String description) {
        int query;
        try {
            query = entityManager.createQuery("delete from ConfigurationEntity b where b.description = '" + description + "'",
                    ConfigurationEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
