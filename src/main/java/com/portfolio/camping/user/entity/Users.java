package com.portfolio.camping.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;
    @Column
    private String userName;
    @Column
    private String userEmail;
    @Column
    private String userPhone;

    @Enumerated(EnumType.STRING)
    private RoleType roleType; // 사용자 권한

    private String providerType; // sns분류

    @Builder
    public Users(String userName, String userEmail, String userPhone, RoleType roleType, String providerType){
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.roleType = roleType;
        this.providerType = providerType;
    }

    public String getRoleType(){
        return this.roleType.getDisplayName();
    }

    public Users update(String userName, String userPhone){
        this.userName = userName;
        this.userPhone = userPhone;
        return this;
    }

}
