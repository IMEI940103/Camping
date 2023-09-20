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
@Table(name="USER_INFO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_no;

    private String user_name;
    private String user_email;
    private String user_phone;

    @Enumerated(EnumType.STRING)
    private RoleType roleType; // 사용자 권한

    @Enumerated(EnumType.STRING)
    private ProviderType providerType; // sns분류

    private String categorize;


    @Builder
    public User(String user_name, String user_email, String user_phone, RoleType roleType, ProviderType providerType, String categorize){
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.roleType = roleType;
        this.providerType = providerType;
        this.categorize = categorize;
    }

}
