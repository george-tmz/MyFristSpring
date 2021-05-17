package cn.wbomb.www.service;

import cn.wbomb.www.mapper.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    BCryptPasswordEncoder mockEncoder;
    UserMapper mockMapper;
    UserService userService = new UserService(mockEncoder, mockMapper);
}