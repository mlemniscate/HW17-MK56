package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.domain.User;
import ir.maktab.repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl extends BaseEntityRepositoryImpl<User, Long> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByUsername(String username) {
        List<User> userList = getEntityManager().createQuery(
                " from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();
        if(userList.size() > 0) return userList.get(0);
        else return null;
    }
}
