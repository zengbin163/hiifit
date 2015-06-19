package com.hiifit.haipay.manager;

import com.hiifit.haipay.vo.User;

public interface UserManager {
    User getByUserId(Integer userId);
}
