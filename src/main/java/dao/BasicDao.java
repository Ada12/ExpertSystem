package dao;

import entity.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public List<BasicApplyEntity> getBasicApplyDesc(int userId) {
        TypedQuery<BasicApplyEntity> query;
        query = entityManager.createQuery("select b from BasicApplyEntity b where b.userId = :userId", BasicApplyEntity.class);
        query.setParameter("userId", userId);
        List<BasicApplyEntity> entities = query.getResultList();
        return entities;
    }

    public BasicApplyEntity getBasicApply(String description, int userId) {
        TypedQuery<BasicApplyEntity> query;
        query = entityManager.createQuery("select b from BasicApplyEntity b where b.description = :description and b.userId = :userId",
                BasicApplyEntity.class);
        query.setParameter("description", description);
        query.setParameter("userId", userId);
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
            updateConfigurationChangeFlag("apply", entity.getDescription(), entity.getUserId());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteApply(String description, int userId) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicApplyEntity b where b.description = '" + description + "' and b.userId = " + userId,
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
    public List<BasicControlEntity> getBasicControlDesc(int userId) {
        TypedQuery<BasicControlEntity> query;
        query = entityManager.createQuery("select b from BasicControlEntity b where b.userId = :userId", BasicControlEntity.class);
        query.setParameter("userId", userId);
        List<BasicControlEntity> entities = query.getResultList();
        return entities;
    }

    public BasicControlEntity getBasicControl(String description, int userId) {
        TypedQuery<BasicControlEntity> query;
        query = entityManager.createQuery("select b from BasicControlEntity b where b.description = :description and b.userId = :userId", BasicControlEntity.class);
        query.setParameter("description", description);
        query.setParameter("userId", userId);
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
            updateConfigurationChangeFlag("control", entity.getDescription(), entity.getUserId());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteControl(String description, int userId) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicControlEntity b where b.description = '" + description + "' and b.userId = " + userId,
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
    public List<BasicDiscBrakeEntity> getBasicDiscBrakeDesc(int userId) {
        TypedQuery<BasicDiscBrakeEntity> query;
        query = entityManager.createQuery("select b from BasicDiscBrakeEntity b where b.userId = :userId", BasicDiscBrakeEntity.class);
        query.setParameter("userId", userId);
        List<BasicDiscBrakeEntity> entities = query.getResultList();
        return entities;
    }

    public BasicDiscBrakeEntity getBasicDiscBrake(String description, int userId) {
        TypedQuery<BasicDiscBrakeEntity> query;
        query = entityManager.createQuery("select b from BasicDiscBrakeEntity b where b.description = :description and b.userId = :userId", BasicDiscBrakeEntity.class);
        query.setParameter("description", description);
        query.setParameter("userId", userId);
        BasicDiscBrakeEntity entities = new BasicDiscBrakeEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean deleteDiscBrake(String description, int userId) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicDiscBrakeEntity b where b.description = '" + description + "' and b.userId = " + userId,
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
            updateConfigurationChangeFlag("discBrake", entity.getDescription(), entity.getUserId());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // basic drum brake
    public List<BasicDrumBrakeEntity> getBasicDrumBrakeDesc(int userId) {
        TypedQuery<BasicDrumBrakeEntity> query;
        query = entityManager.createQuery("select b from BasicDrumBrakeEntity b where b.userId = :userId", BasicDrumBrakeEntity.class);
        query.setParameter("userId", userId);
        List<BasicDrumBrakeEntity> entities = query.getResultList();
        return entities;
    }

    public BasicDrumBrakeEntity getBasicDrumBrake(String description, int userId) {
        TypedQuery<BasicDrumBrakeEntity> query;
        query = entityManager.createQuery("select b from BasicDrumBrakeEntity b where b.description = :description and b.userId = :userId", BasicDrumBrakeEntity.class);
        query.setParameter("description", description);
        query.setParameter("userId", userId);
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
            updateConfigurationChangeFlag("drumBrake", entity.getDescription(), entity.getUserId());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteDrumBrake(String description, int userId) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicDrumBrakeEntity b where b.description = '" + description + "' and b.userId = " + userId,
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
    public List<BasicTireEntity> getBasicTireWheelDesc(int userId) {
        TypedQuery<BasicTireEntity> query;
        query = entityManager.createQuery("select b from BasicTireEntity b where b.userId = :userId", BasicTireEntity.class);
        query.setParameter("userId", userId);
        List<BasicTireEntity> entities = query.getResultList();
        return entities;
    }

    public BasicTireEntity getBasicTireWheel(String description, int userId) {
        TypedQuery<BasicTireEntity> query;
        query = entityManager.createQuery("select b from BasicTireEntity b where b.description = :description and b.userId = :userId", BasicTireEntity.class);
        query.setParameter("description", description);
        query.setParameter("userId", userId);
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
            updateConfigurationChangeFlag("tire", entity.getDescription(), entity.getUserId());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteTireWheel(String description, int userId) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicTireEntity b where b.description = '" + description + "' and b.userId = " + userId,
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
    public List<BasicVehicleEntity> getBasicVehicleDesc(int userId) {
        TypedQuery<BasicVehicleEntity> query;
        query = entityManager.createQuery("select b from BasicVehicleEntity b where b.userId = :userId", BasicVehicleEntity.class);
        query.setParameter("userId", userId);
        List<BasicVehicleEntity> entities = query.getResultList();
        return entities;
    }

    public BasicVehicleEntity getBasicVehicle(String description, int userId) {
        TypedQuery<BasicVehicleEntity> query;
        query = entityManager.createQuery("select b from BasicVehicleEntity b where b.description = :description and b.userId =:userId", BasicVehicleEntity.class);
        query.setParameter("description", description);
        query.setParameter("userId", userId);
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
            updateConfigurationChangeFlag("vehicle", entity.getDescription(), entity.getUserId());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteVehicle(String description, int userId) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicVehicleEntity b where b.description = '" + description + "' and b.userId = " + userId,
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
    public List<BasicRequirementEntity> getBasicRequirementDesc(int userId) {
        TypedQuery<BasicRequirementEntity> query;
        query = entityManager.createQuery("select b from BasicRequirementEntity b where b.userId = :userId", BasicRequirementEntity.class);
        query.setParameter("userId", userId);
        List<BasicRequirementEntity> entities = query.getResultList();
        return entities;
    }

    public BasicRequirementEntity getBasicRequirement(String description, int userId) {
        TypedQuery<BasicRequirementEntity> query;
        query = entityManager.createQuery("select b from BasicRequirementEntity b where b.description = :description and b.userId = :userId", BasicRequirementEntity.class);
        query.setParameter("description", description);
        query.setParameter("userId", userId);
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
            updateConfigurationChangeFlag("require", entity.getDescription(), entity.getUserId());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteRequirement(String description, int userId) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicRequirementEntity b where b.description = '" + description + "' and b.userId = " + userId,
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
    public List<ConfigurationEntity> getBasicConfigurationDesc(int userId) {
        TypedQuery<ConfigurationEntity> query;
        query = entityManager.createQuery("select b from ConfigurationEntity b where b.userId =:userId", ConfigurationEntity.class);
        query.setParameter("userId", userId);
        List<ConfigurationEntity> entities = query.getResultList();
        return entities;
    }

    public ConfigurationEntity getBasicConfiguration(String description, int userId) {
        TypedQuery<ConfigurationEntity> query;
        query = entityManager.createQuery("select b from ConfigurationEntity b where b.description = :description and b.userId =:userId", ConfigurationEntity.class);
        query.setParameter("description", description);
        query.setParameter("userId", userId);
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
            updateConfigurationChangeFlag("control", entity.getDescription(), entity.getUserId());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteConfiguration(String description, int userId) {
        int query;
        try {
            query = entityManager.createQuery("delete from ConfigurationEntity b where b.description = '" + description + "' and b.userId = " + userId,
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

    // parking
    public List<BasicParkingEntity> getBasicParkingDesc(int userId) {
        TypedQuery<BasicParkingEntity> query;
        query = entityManager.createQuery("select b from BasicParkingEntity b where b.userId =:userId", BasicParkingEntity.class);
        query.setParameter("userId", userId);
        List<BasicParkingEntity> entities = query.getResultList();
        return entities;
    }

    public BasicParkingEntity getBasicParking(String description, int userId) {
        TypedQuery<BasicParkingEntity> query;
        query = entityManager.createQuery("select b from BasicParkingEntity b where b.description = :description and b.userId =:userId", BasicParkingEntity.class);
        query.setParameter("description", description);
        query.setParameter("userId", userId);
        BasicParkingEntity entities = new BasicParkingEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean addNewParking(BasicParkingEntity entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            updateConfigurationChangeFlag("parking", entity.getDescription(), entity.getUserId());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteParking(String description, int userId) {
        int query;
        try {
            query = entityManager.createQuery("delete from BasicParkingEntity b where b.description = '" + description + "' and b.userId = " + userId,
                    BasicParkingEntity.class).executeUpdate();
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

    // update workspace
    public void updateWorkspace(
            String apply,
            String control,
            String discBrake,
            String drumBrake,
            String require,
            String tire,
            String vehicle,
            String parking,
            int userId
    ) {
        // apply
        TypedQuery<BasicApplyEntity> applyQuery1;
        applyQuery1 = entityManager.createQuery("update BasicApplyEntity b set b.isWork = 1 where b.description =:description and b.userId =:userId", BasicApplyEntity.class);
        applyQuery1.setParameter("description", apply);
        applyQuery1.setParameter("userId", userId);
        applyQuery1.executeUpdate();
        TypedQuery<BasicApplyEntity> applyQuery2;
        applyQuery2 = entityManager.createQuery("update BasicApplyEntity b set b.isWork = 0 where b.description !=:description and b.userId =:userId", BasicApplyEntity.class);
        applyQuery2.setParameter("description", apply);
        applyQuery2.setParameter("userId", userId);
        applyQuery2.executeUpdate();
        // control
        TypedQuery<BasicControlEntity> controlQuery1;
        controlQuery1 = entityManager.createQuery("update BasicControlEntity b set b.isWork = 1 where b.description =:description and b.userId =:userId", BasicControlEntity.class);
        controlQuery1.setParameter("description", control);
        controlQuery1.setParameter("userId", userId);
        controlQuery1.executeUpdate();
        TypedQuery<BasicControlEntity> controlQuery2;
        controlQuery2 = entityManager.createQuery("update BasicControlEntity b set b.isWork = 0 where b.description !=:description and b.userId =:userId", BasicControlEntity.class);
        controlQuery2.setParameter("description", control);
        controlQuery2.setParameter("userId", userId);
        controlQuery2.executeUpdate();
        // discBrake
        TypedQuery<BasicDiscBrakeEntity> discBrakeQuery1;
        discBrakeQuery1 = entityManager.createQuery("update BasicDiscBrakeEntity b set b.isWork = 1 where b.description =:description and b.userId =:userId", BasicDiscBrakeEntity.class);
        discBrakeQuery1.setParameter("description", discBrake);
        discBrakeQuery1.setParameter("userId", userId);
        discBrakeQuery1.executeUpdate();
        TypedQuery<BasicDiscBrakeEntity> discBrakeQuery2;
        discBrakeQuery2 = entityManager.createQuery("update BasicDiscBrakeEntity b set b.isWork = 0 where b.description !=:description and b.userId =:userId", BasicDiscBrakeEntity.class);
        discBrakeQuery2.setParameter("description", discBrake);
        discBrakeQuery2.setParameter("userId", userId);
        discBrakeQuery2.executeUpdate();
        // drumBrake
        TypedQuery<BasicDrumBrakeEntity> drumBrakeQuery1;
        drumBrakeQuery1 = entityManager.createQuery("update BasicDrumBrakeEntity b set b.isWork = 1 where b.description =:description and b.userId =:userId", BasicDrumBrakeEntity.class);
        drumBrakeQuery1.setParameter("description", drumBrake);
        drumBrakeQuery1.setParameter("userId", userId);
        drumBrakeQuery1.executeUpdate();
        TypedQuery<BasicDrumBrakeEntity> drumBrakeQuery2;
        drumBrakeQuery2 = entityManager.createQuery("update BasicDrumBrakeEntity b set b.isWork = 0 where b.description !=:description and b.userId =:userId", BasicDrumBrakeEntity.class);
        drumBrakeQuery2.setParameter("description", drumBrake);
        drumBrakeQuery2.setParameter("userId", userId);
        drumBrakeQuery2.executeUpdate();
        // require
        TypedQuery<BasicRequirementEntity> requireQuery1;
        requireQuery1 = entityManager.createQuery("update BasicRequirementEntity b set b.isWork = 1 where b.description =:description and b.userId =:userId", BasicRequirementEntity.class);
        requireQuery1.setParameter("description", require);
        requireQuery1.setParameter("userId", userId);
        requireQuery1.executeUpdate();
        TypedQuery<BasicRequirementEntity> requireQuery2;
        requireQuery2 = entityManager.createQuery("update BasicRequirementEntity b set b.isWork = 0 where b.description !=:description and b.userId =:userId", BasicRequirementEntity.class);
        requireQuery2.setParameter("description", require);
        requireQuery2.setParameter("userId", userId);
        requireQuery2.executeUpdate();
        // tire
        TypedQuery<BasicTireEntity> tireQuery1;
        tireQuery1 = entityManager.createQuery("update BasicTireEntity b set b.isWork = 1 where b.description =:description and b.userId =:userId", BasicTireEntity.class);
        tireQuery1.setParameter("description", tire);
        tireQuery1.setParameter("userId", userId);
        tireQuery1.executeUpdate();
        TypedQuery<BasicTireEntity> tireQuery2;
        tireQuery2 = entityManager.createQuery("update BasicTireEntity b set b.isWork = 0 where b.description !=:description and b.userId =:userId", BasicTireEntity.class);
        tireQuery2.setParameter("description", tire);
        tireQuery2.setParameter("userId", userId);
        tireQuery2.executeUpdate();
        // vehicle
        TypedQuery<BasicVehicleEntity> vehicleQuery1;
        vehicleQuery1 = entityManager.createQuery("update BasicVehicleEntity b set b.isWork = 1 where b.description =:description and b.userId =:userId", BasicVehicleEntity.class);
        vehicleQuery1.setParameter("description", vehicle);
        vehicleQuery1.setParameter("userId", userId);
        vehicleQuery1.executeUpdate();
        TypedQuery<BasicVehicleEntity> vehicleQuery2;
        vehicleQuery2 = entityManager.createQuery("update BasicVehicleEntity b set b.isWork = 0 where b.description !=:description and b.userId =:userId", BasicVehicleEntity.class);
        vehicleQuery2.setParameter("description", vehicle);
        vehicleQuery2.setParameter("userId", userId);
        vehicleQuery2.executeUpdate();
        // parking
        TypedQuery<BasicParkingEntity> parkingQuery1;
        parkingQuery1 = entityManager.createQuery("update BasicParkingEntity b set b.isWork = 1 where b.description =:description and b.userId =:userId", BasicParkingEntity.class);
        parkingQuery1.setParameter("description", parking);
        parkingQuery1.setParameter("userId", userId);
        parkingQuery1.executeUpdate();
        TypedQuery<BasicParkingEntity> parkingQuery2;
        parkingQuery2 = entityManager.createQuery("update BasicParkingEntity b set b.isWork = 0 where b.description !=:description and b.userId =:userId", BasicParkingEntity.class);
        parkingQuery2.setParameter("description", parking);
        parkingQuery2.setParameter("userId", userId);
        parkingQuery2.executeUpdate();
    }

    public Map<String, String> getWorkspace(int userId) {
        Map<String, String> desc = new HashedMap();
        // apply
        TypedQuery<BasicApplyEntity> applyQuery;
        applyQuery = entityManager.createQuery("select b from BasicApplyEntity b where b.isWork = 1 and b.userId =:userId",
                BasicApplyEntity.class);
        applyQuery.setParameter("userId", userId);
        desc.put("apply", applyQuery.getSingleResult().getDescription());
        // control
        TypedQuery<BasicControlEntity> controlQuery;
        controlQuery = entityManager.createQuery("select b from BasicControlEntity b where b.isWork = 1 and b.userId =:userId",
                BasicControlEntity.class);
        controlQuery.setParameter("userId", userId);
        desc.put("control", controlQuery.getSingleResult().getDescription());
        // discBrake
        TypedQuery<BasicDiscBrakeEntity> discBrakeQuery;
        discBrakeQuery = entityManager.createQuery("select b from BasicDiscBrakeEntity b where b.isWork = 1 and b.userId =:userId",
                BasicDiscBrakeEntity.class);
        discBrakeQuery.setParameter("userId", userId);
        desc.put("discBrake", discBrakeQuery.getSingleResult().getDescription());
        // drumBrake
        TypedQuery<BasicDrumBrakeEntity> drumBrakeQuery;
        drumBrakeQuery = entityManager.createQuery("select b from BasicDrumBrakeEntity b where b.isWork = 1 and b.userId =:userId",
                BasicDrumBrakeEntity.class);
        drumBrakeQuery.setParameter("userId", userId);
        desc.put("drumBrake", drumBrakeQuery.getSingleResult().getDescription());
        // require
        TypedQuery<BasicRequirementEntity> requireQuery;
        requireQuery = entityManager.createQuery("select b from BasicRequirementEntity b where b.isWork = 1 and b.userId =:userId",
                BasicRequirementEntity.class);
        requireQuery.setParameter("userId", userId);
        desc.put("requirement", requireQuery.getSingleResult().getDescription());
        // tire
        TypedQuery<BasicTireEntity> tireQuery;
        tireQuery = entityManager.createQuery("select b from BasicTireEntity b where b.isWork = 1 and b.userId =:userId",
                BasicTireEntity.class);
        tireQuery.setParameter("userId", userId);
        desc.put("tire", tireQuery.getSingleResult().getDescription());
        // vehicle
        TypedQuery<BasicVehicleEntity> vehicleQuery;
        vehicleQuery = entityManager.createQuery("select b from BasicVehicleEntity b where b.isWork = 1 and b.userId =:userId",
                BasicVehicleEntity.class);
        vehicleQuery.setParameter("userId", userId);
        desc.put("vehicle", vehicleQuery.getSingleResult().getDescription());
        // parking
        TypedQuery<BasicParkingEntity> parkingQuery;
        parkingQuery = entityManager.createQuery("select b from BasicParkingEntity b where b.isWork = 1 and b.userId =:userId",
                BasicParkingEntity.class);
        parkingQuery.setParameter("userId", userId);
        desc.put("parking", parkingQuery.getSingleResult().getDescription());
        return desc;
    }

    // for contrast
    public void updateConfigurationChangeFlag(String type, String desc, int userId) {
        try {
            if (type.equals("vehicle")) {
                entityManager.createQuery("update ConfigurationEntity b set b.changeFlag = 1 where b.vehicleDesc = '" + desc + "' and b.userId = " + userId,
                        ConfigurationEntity.class).executeUpdate();
            } else if (type.equals("tire")) {
                entityManager.createQuery("update ConfigurationEntity b set b.changeFlag = 1 where b.tireDesc = '" + desc + "' and b.userId = " + userId,
                        ConfigurationEntity.class).executeUpdate();
            } else if (type.equals("apply")) {
                entityManager.createQuery("update ConfigurationEntity b set b.changeFlag = 1 where b.applyDesc = '" + desc + "' and b.userId = " + userId,
                        ConfigurationEntity.class).executeUpdate();
            } else if (type.equals("control")) {
                entityManager.createQuery("update ConfigurationEntity b set b.changeFlag = 1 where b.controlDesc = '" + desc + "' and b.userId = " + userId,
                        ConfigurationEntity.class).executeUpdate();
            } else if (type.equals("discBrake")) {
                entityManager.createQuery("update ConfigurationEntity b set b.changeFlag = 1 where b.discBrakeDesc = '" + desc + "' and b.userId = " + userId,
                        ConfigurationEntity.class).executeUpdate();
            } else if (type.equals("drumBrake")) {
                entityManager.createQuery("update ConfigurationEntity b set b.changeFlag = 1 where b.drumBrakeDesc = '" + desc + "' and b.userId = " + userId,
                        ConfigurationEntity.class).executeUpdate();
            } else if (type.equals("require")) {
                entityManager.createQuery("update ConfigurationEntity b set b.changeFlag = 1 where b.requireDesc = '" + desc + "' and b.userId = " + userId,
                        ConfigurationEntity.class).executeUpdate();
            } else if (type.equals("parking")) {
                entityManager.createQuery("update ConfigurationEntity b set b.changeFlag = 1 where b.parkingDesc = '" + desc + "' and b.userId = " + userId,
                        ConfigurationEntity.class).executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean updateConfigurationFileName(String desc, String fileName, int userId) {
        try {
            int query = entityManager.createQuery("update ConfigurationEntity b set b.fileName = '"+ fileName +"', b.changeFlag = 0 where b.description = '" + desc + "' and b.userId = " + userId,
                    ConfigurationEntity.class).executeUpdate();
            if (query > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getConfigurationFileName(String desc, int userId) {
        TypedQuery<ConfigurationEntity> query;
        query = entityManager.createQuery("select b from ConfigurationEntity b where b.description = :description and b.userId =:userId and b.changeFlag = 0", ConfigurationEntity.class);
        query.setParameter("description", desc);
        query.setParameter("userId", userId);
        ConfigurationEntity entities = new ConfigurationEntity();
        String fileName;
        try {
            entities = query.getSingleResult();
            fileName = entities.getFileName();
        } catch (NoResultException e) {
            System.out.println(e);
            fileName = "";
        }
        if (fileName == null) {
            return "";
        } else {
            return fileName;
        }
    }

    public List<String> getUselessFileNames(int userId) {
        TypedQuery<ConfigurationEntity> query;
        query = entityManager.createQuery("select b from ConfigurationEntity b where b.userId =:userId and b.changeFlag = 1", ConfigurationEntity.class);
        query.setParameter("userId", userId);
        List<ConfigurationEntity> entities = new ArrayList<ConfigurationEntity>();
        try {
            entities = query.getResultList();
        } catch (NoResultException e) {
            System.out.println(e);
        }
        List<String> fileNames = new ArrayList<String>();
        for (ConfigurationEntity entity: entities) {
            fileNames.add(entity.getFileName());
        }
        return fileNames;
    }
}
