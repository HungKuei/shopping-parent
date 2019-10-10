package com.hungkuei.api.service.impl;

import com.hungkuei.entity.UserEntity;
import com.hungkuei.mapper.UserMapper;
import com.hungkuei.api.service.UserService;
import com.hungkuei.base.BaseResponse;
import com.hungkuei.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResponse<UserEntity> getByUserId(@PathVariable("userId") Integer userId) {
        UserEntity userEntity = userMapper.selectById(userId);
        if (userEntity == null){
            return success("未查找到用户信息");
        }
        return success(userEntity);
    }
}
