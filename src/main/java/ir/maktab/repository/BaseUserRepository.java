package ir.maktab.repository;

import ir.maktab.base.repository.BaseEntityRepository;
import ir.maktab.domain.BaseUser;

public interface BaseUserRepository extends BaseEntityRepository<BaseUser, Long> {
    BaseUser findByUsername(String username);
}
