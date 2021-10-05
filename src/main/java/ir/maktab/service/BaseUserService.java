package ir.maktab.service;

import ir.maktab.base.service.BaseEntityService;
import ir.maktab.domain.BaseUser;

public interface BaseUserService extends BaseEntityService<BaseUser, Long> {

    BaseUser login(String username, String password) throws Exception;

}
