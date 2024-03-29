package com.hungkuei.constant;

public interface PublicConstant {
    String FAILED  = "系统错误";

    String SUCCEED = "操作成功";

    String UNAUTHORIZED  = "获取登录用户信息失败";

    String ERROR  = "操作失败";

    String DATA_ERROR  = "数据操作错误";

    String PARAM_ERROR  = "参数错误";

    String INVALID_USERNAME_PASSWORD  = "用户名或密码错误";

    String INVALID_RE_PASSWORD  = "两次输入密码不一致";

    String INVALID_USER  = "用户不存在";

    String INVALID_ROLE  = "角色不存在";

    String ROLE_USER_USED  = "角色使用中，不可删除";

    String USER_NO_PERMITION  = "当前用户无该接口权限";

    String VERIFY_PARAM_ERROR  = "校验码错误";

    String VERIFY_PARAM_PASS  = "校验码过期";

    String MOBILE_ERROR  = "手机号格式错误";

    String UPDATE_ROLEINFO_ERROR  = "更新角色信息失败";

    String UPDATE_SYSADMIN_INFO_ERROR  = "不能修改管理员信息!";

    String SMS_EMAIL = "email";

    Integer SUCCESS_CODE = 200;

    Integer FAIL_CODE = 500;

    Integer DEFAULT_TYPE_ = 0;

    Integer INVALID_TYPE = 1;

    Integer VALID_TYPE = 2;

    Integer STATUS_INVALID = 0;

    Integer STATUS_VALID = 1;

    /**
     * 会员token头
     */
    String MEMBER_TOKEN = "MEMBER_TOKEN";

    /**
     * token过期时间(90天)
     */
    Long MEMBER_TOKEN_TIME = (long)(60*60*24*90);
}
