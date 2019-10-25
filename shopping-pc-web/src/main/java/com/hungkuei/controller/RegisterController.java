package com.hungkuei.controller;

import com.hungkuei.base.BaseResponse;
import com.hungkuei.entity.UserEntity;
import com.hungkuei.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RegisterController {

    public static final String REGISTER = "register";
    public static final String LOGIN = "login";

    @Autowired
    private UserServiceFeign userServiceFeign;

    @GetMapping("register")
    public String register(){
        return REGISTER;
    }

    @PostMapping("register")
    @ResponseBody
    public BaseResponse register(@RequestBody UserEntity userEntity){
        return userServiceFeign.register(userEntity);
    }

    @GetMapping("login")
    public String login(){
        return LOGIN;
    }

    @PostMapping("login")
    public BaseResponse login(@RequestBody UserEntity userEntity){
        return userServiceFeign.login(userEntity);
    }
}
