package com.hungkuei.api.service;

import com.hungkuei.entity.UserEntity;
import com.hungkuei.base.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
public interface UserService {

    @GetMapping("/get/{userId}")
    BaseResponse<UserEntity> getByUserId(@PathVariable("userId") Integer userId);
}
