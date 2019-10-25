package com.hungkuei.utils;

import com.hungkuei.constant.PublicConstant;

import java.util.UUID;

public class TokenUtil {

    /**
     * 生成会员token
     * @return
     */
    public static String getMemberToken(){
        return PublicConstant.MEMBER_TOKEN + "-" + UUID.randomUUID();
    }
}
