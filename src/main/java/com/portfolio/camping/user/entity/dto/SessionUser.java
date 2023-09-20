package com.portfolio.camping.user.entity.dto;

import com.portfolio.camping.user.entity.Users;
import lombok.Getter;

@Getter
public class SessionUser { // 인증된 사용자 정보.

    private String user_name;
    private String user_email;
    private String user_phone;

    public SessionUser(Users users){
        this.user_name = users.getUser_name();
        this.user_email = users.getUser_email();
        this.user_phone = getUser_phone();
    }

}
