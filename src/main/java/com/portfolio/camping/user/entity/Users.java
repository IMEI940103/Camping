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
    private Long user_no;

    @Column
    private String user_name;
    @Column
    private String user_email;
    @Column
    private String user_phone;

    @Enumerated(EnumType.STRING)
    private RoleType roleType; // 사용자 권한

    @Enumerated(EnumType.STRING)
    private ProviderType providerType; // sns분류

    //private String categorize;


    @Builder
    public Users(String user_name, String user_email, String user_phone, RoleType roleType, ProviderType providerType, String categorize){
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.roleType = roleType;
        this.providerType = providerType;
        //this.categorize = categorize;
    }

    public String getRoleType(){
        return this.roleType.getDisplayName();
    }

    public Users update(String name, String phone){

        this.user_name = name;
        this.user_phone = phone;

        return this;
    }

}
