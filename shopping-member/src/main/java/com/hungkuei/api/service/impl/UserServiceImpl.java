package com.hungkuei.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hungkuei.base.BaseMessage;
import com.hungkuei.constant.PublicConstant;
import com.hungkuei.entity.UserEntity;
import com.hungkuei.mapper.UserMapper;
import com.hungkuei.api.service.UserService;
import com.hungkuei.base.BaseResponse;
import com.hungkuei.base.BaseService;
import com.hungkuei.mq.RegisterMailboxProducer;
import com.hungkuei.utils.MD5Util;
import com.hungkuei.utils.MessageUtil;
import com.hungkuei.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RegisterMailboxProducer registerMailboxProducer;

    @Value("${messages.queue}")
    private String messagesQueue;

    @Override
    public BaseResponse<UserEntity> getByUserId(@PathVariable("userId") Integer userId) {
        UserEntity userEntity = userMapper.selectById(userId);
        if (userEntity == null){
            return success("未查找到用户信息");
        }
        return success(userEntity);
    }

    @Override
    public BaseResponse register(@RequestBody UserEntity userEntity) {

        if (StringUtils.isEmpty(userEntity.getUsername())){
            return error("登录账号不能为空");
        }

        if (StringUtils.isEmpty(userEntity.getPassword())){
            return error("密码不能为空");
        }
        // 这里对用户密码进行盐值加密
        userEntity.setSalt(UUID.randomUUID().toString());
        userEntity.setPassword(MD5Util.MD5(userEntity.getPassword()));
        // 判断邮箱或手机号是否为空，发送邮箱或短信验证
        String msgJson = MessageUtil.msgJson(PublicConstant.SMS_EMAIL, userEntity.getEmail());
        log.info("####将会员注册消息发送到消息平台:{}", msgJson);
        // 创建消息队列
        ActiveMQQueue messages_queue = new ActiveMQQueue(messagesQueue);
        // 发送消息
        registerMailboxProducer.sendMsg(messages_queue, msgJson);
        if (userMapper.insert(userEntity) > 0) {
            return success("注册成功");
        }else{
            return error("注册失败");
        }
    }

    @Override
    public BaseResponse login(@RequestBody UserEntity userEntity) {
        // 验证参数
        String username = userEntity.getUsername();
        if (StringUtils.isEmpty(username)){
            return error("用户名不能为空");
        }
        String password = userEntity.getPassword();
        if (StringUtils.isEmpty(password)){
            return error("密码不能为空");
        }
        UserEntity user = userMapper.selectByUsername(username);
        if (StringUtils.isEmpty(user)){
            return error("用户不存在");
        }
        //密码校验
        String newPassword = MD5Util.MD5(password);
        if (!user.getPassword().equals(newPassword)){
            return error("账号或密码错误");
        }
        //生成token令牌
        String memberToken = TokenUtil.getMemberToken();
        //存入redis缓存
        baseRedisService.setString(memberToken, String.valueOf(user.getId()), PublicConstant.MEMBER_TOKEN_TIME);
        //返回token
        JSONObject token = new JSONObject();
        token.put("memberToken", memberToken);
        return success(token);
    }
}
