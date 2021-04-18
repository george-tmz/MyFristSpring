package cn.wbomb.www.mapper;

import cn.wbomb.www.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.Instant;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO `user` (username, encrypted_password, created_at, updated_at)" +
            "VALUES (#{username}, #{encryptedPassword}, #{createdAt}, #{updatedAt})")
    void save(@Param("username") String username,
              @Param("encryptedPassword") String encryptedPassword,
              @Param("createdAt") Instant createdAt,
              @Param("updatedAt") Instant updatedAt
    );

    @Select("select * from user where username = #{username}")
    User findUserByUsername(@Param("username") String username);
}
