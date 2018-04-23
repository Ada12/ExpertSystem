package dao;

import entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by yangchen on 17/7/1.
 */
@Repository
public class BreakDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<UnitsEntity> getAllUnits() {
        TypedQuery<UnitsEntity> query;
        query = entityManager.createQuery("select v from UnitsEntity v", UnitsEntity.class);
        List<UnitsEntity> entities = query.getResultList();
        return entities;
    }

    public int saveInstance(InstanceLibEntity entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity.getId();
    }

    public InstanceLibEntity getInstance(int id) {
        return entityManager.find(InstanceLibEntity.class, id);
    }

    public List<InstanceLibEntity> getAllInstance(int userId) {
        TypedQuery<InstanceLibEntity> query;
        query = entityManager.createQuery("select v from InstanceLibEntity v where v.userId = :userId", InstanceLibEntity.class);
        query.setParameter("userId", userId);
        List<InstanceLibEntity> entities = query.getResultList();
        return entities;
    }
}
