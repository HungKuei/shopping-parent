package com.hungkuei.api.service.impl;

import com.hungkuei.api.service.TestService;
import com.hungkuei.base.BaseResponse;
import com.hungkuei.base.BaseService;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestServiceImpl extends BaseService implements TestService {

    @Override
    public Map<String, Object> test(Integer id, String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "200");
        result.put("msg", "success");
        result.put("data", new String[]{"1", "hungkuei", id + "", name});
        return result;
    }

    @Override
    public BaseResponse base(Integer id, String name) {
        return success();
    }

    @Override
    public BaseResponse redis(String key, String value) {
        baseRedisService.setString(key, value, null);
        Map<String, Object> data = new HashMap<>();
        data.put("key", key);
        data.put("value", value);
        return success(data);
    }


}
