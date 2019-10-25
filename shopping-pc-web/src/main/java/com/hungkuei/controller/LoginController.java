package com.hungkuei.controller;

import com.hungkuei.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    @Autowired
    private UserServiceFeign userServiceFeign;


}
