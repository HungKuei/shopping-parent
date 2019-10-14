package com.hungkuei.email.service;

import com.alibaba.fastjson.JSONObject;
import com.hungkuei.adapter.MessageAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 调用第三方发邮件
 */
@Slf4j
@Service
public class EmailService implements MessageAdapter {

    @Override
    public void sendMsg(JSONObject contentJson) {
        //发送邮件
        String email = contentJson.getString("email");

        log.info("#### 发送消息给邮箱：" , email);
    }
}
