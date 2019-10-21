package com.hungkuei.feign;

import com.hungkuei.api.service.UserService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("member-server")
public interface UserServiceFeign extends UserService {
}
