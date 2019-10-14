package com.hungkuei.base;

import com.alibaba.fastjson.JSONObject;

public class BaseMessage {

    public static String msgJson(String interfaceType, String email){
        JSONObject msgJson = new JSONObject();
        JSONObject headerJson = new JSONObject();
        headerJson.put("interfaceType",interfaceType);
        JSONObject contentJson = new JSONObject();
        contentJson.put("email", email);
        msgJson.put("header", headerJson);
        msgJson.put("content", contentJson);
        return msgJson.toJSONString();
    }


}
