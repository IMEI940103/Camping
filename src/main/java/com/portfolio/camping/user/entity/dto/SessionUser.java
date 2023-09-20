package com.portfolio.camping.user.entity.dto;

import com.portfolio.camping.user.entity.Users;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable { // 인증된 사용자 정보.

    private String userName;
    private String userEmail;
    private String userPhone;

    public SessionUser(Users users){
        this.userName = users.getUserName();
        this.userEmail = users.getUserEmail();
        this.userPhone = users.getUserPhone();
    }

}
