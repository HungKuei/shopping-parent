package com.hungkuei.api.service;

import com.hungkuei.base.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/member")
public interface TestService {

    @RequestMapping("/test")
    Map<String, Object> test(Integer id, String name);

    @RequestMapping("/base")
    BaseResponse base(Integer id, String name);

    @RequestMapping("redis")
    BaseResponse redis(String key, String value);

}
