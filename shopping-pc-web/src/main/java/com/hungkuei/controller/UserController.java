package com.hungkuei.controller;

import com.hungkuei.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    @Autowired
    private UserServiceFeign userServiceFeign;


}
