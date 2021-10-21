package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.BaseUser;
import ir.maktab.repository.BaseUserRepository;
import ir.maktab.service.BaseUserService;
import java.util.Objects;

public class BaseUserServiceImpl extends BaseEntityServiceImpl<BaseUser, Long, BaseUserRepository> implements BaseUserService {

    public BaseUserServiceImpl(BaseUserRepository repository) {
        super(repository);
    }


    @Override
    public BaseUser login(String username, String password) throws Exception {
        BaseUser airline = repository.findByUsername(username);
        if(Objects.isNull(airline))
            throw new NullPointerException("\n----------------------------------" +
                    "\nYour username is wrong!\n" +
                    "----------------------------------\n");
        else if(!airline.getPassword().equals(password))
            throw new Exception("\n----------------------------------" +
                    "\nYour password is wrong!\n" +
                    "----------------------------------\n");
        else return airline;
    }
}
