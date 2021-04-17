package cn.wbomb.www.mapper;

import cn.wbomb.www.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") Integer id);

    @Insert("INSERT INTO `user` (username, encrypted_password, created_at, updated_at)" +
            "VALUES (#{username}, #{encryptedPassword}, now(), now())")
    void save(@Param("username") String username, @Param("encryptedPassword") String encryptedPassword);

    @Select("select * from user where username = #{username}")
    User findUserByUsername(@Param("username") String username);
}
