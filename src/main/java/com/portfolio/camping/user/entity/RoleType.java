package com.portfolio.camping.user.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor //필드 모든 생성자만 만듦.
public enum RoleType {

    USER("ROLE_USER","일반회원"),
    President("ROLE_PRESIDENT","사장님"),
    ADMIN("ROLE_ADMIN","관리자"),
    GUEST("ROLE_GUEST","비회원");

    private final String code;
    private final String displayName;


}
