package com.hungkuei.mq;

import com.alibaba.fastjson.JSONObject;
import com.hungkuei.adapter.MessageAdapter;
import com.hungkuei.constant.PublicConstant;
import com.hungkuei.email.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class ConsumerDistribute {

    @Autowired
    private EmailService emailService;

    private MessageAdapter messageAdapter;

    @JmsListener(destination = "messages_queue")
    public void distribute(String json){

        log.info("###### 消息平台接收到的消息 #####", json);
        if (StringUtils.isEmpty(json)){
            return;
        }

        JSONObject msgJson = new JSONObject().parseObject(json);
        JSONObject header = msgJson.getJSONObject("header");
        String interfaceType = header.getString("interfaceType");

        if (StringUtils.isEmpty(interfaceType)){
            return;
        }

        //判断是否是邮件消息
        if (interfaceType.equals(PublicConstant.SMS_EMAIL)){
            messageAdapter = emailService;
        }

        JSONObject contentJson = msgJson.getJSONObject("content");
        messageAdapter.sendMsg(contentJson);
    }

}
