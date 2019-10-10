package com.hungkuei.mapper;

import com.hungkuei.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select id,username,password,salt,phone,email,avatar,status,create_time,update_time from mb_user where id =#{userId}")
    UserEntity selectById(@Param("userId") Integer userId);
}
