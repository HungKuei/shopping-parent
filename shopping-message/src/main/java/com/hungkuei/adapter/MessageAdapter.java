package com.hungkuei.adapter;

import com.alibaba.fastjson.JSONObject;

public interface MessageAdapter {

    void sendMsg(JSONObject contentJson);
}
