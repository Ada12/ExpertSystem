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
 * Created by yangchen on 2018/4/7.
 */
@Repository
public class OptimalDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<LibBstMcEntity> getLibBstMc() {
        TypedQuery<LibBstMcEntity> query = entityManager.createQuery("select l from LibBstMcEntity l", LibBstMcEntity.class);
        List<LibBstMcEntity> entities = query.getResultList();
        return entities;
    }

    public List<LibCaliperEntity> getLibCaliper() {
        TypedQuery<LibCaliperEntity> query;
        query = entityManager.createQuery("select l from LibCaliperEntity l", LibCaliperEntity.class);
        List<LibCaliperEntity> entities = query.getResultList();
        return entities;
    }

    public List<LibControlEntity> getLibControl() {
        TypedQuery<LibControlEntity> query= entityManager.createQuery("select l from LibControlEntity l", LibControlEntity.class);
        List<LibControlEntity> entities = query.getResultList();
        return entities;
    }

    public List<LibDrumRotorEntity> getLibDrumRotor() {
        TypedQuery<LibDrumRotorEntity> query = entityManager.createQuery("select l from LibDrumRotorEntity l", LibDrumRotorEntity.class);
        List<LibDrumRotorEntity> entities = query.getResultList();
        return entities;
    }

    public List<LibLiningEntity> getLibLining() {
        TypedQuery<LibLiningEntity> query;
        query = entityManager.createQuery("select l from LibLiningEntity l", LibLiningEntity.class);
        List<LibLiningEntity> entities = query.getResultList();
        return entities;
    }

    public List<LibPedalEntity> getLibPedal() {
        TypedQuery<LibPedalEntity> query = entityManager.createQuery("select l from LibPedalEntity l", LibPedalEntity.class);
        List<LibPedalEntity> entities = query.getResultList();
        return entities;
    }

    public List<LibSolidRotorEntity> getLibSolidRotor() {
        TypedQuery<LibSolidRotorEntity> query = entityManager.createQuery("select l from LibSolidRotorEntity l", LibSolidRotorEntity.class);
        List<LibSolidRotorEntity> entities = query.getResultList();
        return entities;
    }

    public List<LibTireEntity> getLibTire() {
        TypedQuery<LibTireEntity> query = entityManager.createQuery("select l from LibTireEntity l", LibTireEntity.class);
        List<LibTireEntity> entities = query.getResultList();
        return entities;
    }

    public List<LibVehicleEntity> getLibVehicle() {
        TypedQuery<LibVehicleEntity> query = entityManager.createQuery("select l from LibVehicleEntity l", LibVehicleEntity.class);
        List<LibVehicleEntity> entities = query.getResultList();
        return entities;
    }

    public List<LibVentedRotorEntity> getLibVentedRotor() {
        TypedQuery<LibVentedRotorEntity> query = entityManager.createQuery("select l from LibVentedRotorEntity l", LibVentedRotorEntity.class);
        List<LibVentedRotorEntity> entities = query.getResultList();
        return entities;
    }

    public List<LibRotorEntity> getLibRotor() {
        TypedQuery<LibRotorEntity> query = entityManager.createQuery("select l from LibRotorEntity l", LibRotorEntity.class);
        List<LibRotorEntity> entities = query.getResultList();
        return entities;
    }

    // pre optimization descs
    public List<PreOptimizationInstanceEntity> getOptimizationDesc(int userId) {
        TypedQuery<PreOptimizationInstanceEntity> query;
        query = entityManager.createQuery("select b from PreOptimizationInstanceEntity b where b.userId = :userId", PreOptimizationInstanceEntity.class);
        query.setParameter("userId", userId);
        List<PreOptimizationInstanceEntity> entities = query.getResultList();
        return entities;
    }

    public PreOptimizationInstanceEntity getOptimization(String description, int userId) {
        TypedQuery<PreOptimizationInstanceEntity> query;
        query = entityManager.createQuery("select b from PreOptimizationInstanceEntity b where b.description = :description and b.userId = :userId",
                PreOptimizationInstanceEntity.class);
        query.setParameter("description", description);
        query.setParameter("userId", userId);
        PreOptimizationInstanceEntity entities = new PreOptimizationInstanceEntity();
        try {
            entities = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            entities = null;
        }
        return entities;
    }

    public boolean addNewOptimization(PreOptimizationInstanceEntity entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteOptimization(String description, int userId) {
        int query;
        try {
            query = entityManager.createQuery("delete from PreOptimizationInstanceEntity b where b.description = '" + description + "' and b.userId = " + userId,
                    PreOptimizationInstanceEntity.class).executeUpdate();
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
}
