package cn.wbomb.www.service;

import cn.wbomb.www.entity.User;
import cn.wbomb.www.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class UserService {

    private final UserMapper userMapper;

    @Inject
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
