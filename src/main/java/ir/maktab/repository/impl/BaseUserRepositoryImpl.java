package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.domain.BaseUser;
import ir.maktab.repository.BaseUserRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class BaseUserRepositoryImpl extends BaseEntityRepositoryImpl<BaseUser, Long> implements BaseUserRepository {

    public BaseUserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<BaseUser> getEntityClass() {
        return BaseUser.class;
    }

    @Override
    public BaseUser findByUsername(String username) {
        List<BaseUser> list = getEntityManager().createQuery(
                "select a from BaseUser a where a.username = :username", BaseUser.class)
                .setParameter("username", username)
                .getResultList();
        if(list.size() > 0) return list.get(0);
        else return null;
    }
}
