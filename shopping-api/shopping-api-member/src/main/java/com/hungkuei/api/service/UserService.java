package com.hungkuei.api.service;

import com.hungkuei.entity.UserEntity;
import com.hungkuei.base.BaseResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member")
public interface UserService {

    @GetMapping("/get/{userId}")
    BaseResponse<UserEntity> getByUserId(@PathVariable("userId") Integer userId);

    @PostMapping("/register")
    BaseResponse register(@RequestBody UserEntity userEntity);
}
