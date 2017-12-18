package dao;

import entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by yangchen on 17/7/1.
 */
@Repository
public class UserDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public UserEntity getUser(String username) {
        TypedQuery<UserEntity> query;
        query = entityManager.createQuery("select a from UserEntity a where a.userName = :user", UserEntity.class);
        query.setParameter("user", username);
        UserEntity entity = new UserEntity();
        try {
            entity = query.getSingleResult();
        } catch (NoResultException e) {
            entity = null;
            System.out.println(e);
        }
        return entity;
    }

}
