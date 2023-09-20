package com.portfolio.camping.user.entity.dto;

import com.portfolio.camping.user.entity.RoleType;
import com.portfolio.camping.user.entity.Users;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuth2Attributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String providerType;

    @Builder
    public OAuth2Attributes(Map<String,Object> attributes,String nameAttributeKey,String userName,String userEmail,String userPhone,String providerType){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.providerType = providerType;
    }

    public static OAuth2Attributes of(String registrationId,String userNameAttributeName, Map<String,Object> attributes){
        System.out.println(attributes.toString());

               if(registrationId.equals("google")){ return ofGoogle(userNameAttributeName,attributes);}
        else {return ofNaver(userNameAttributeName,(Map)attributes.get("response"));}
    }

    private static OAuth2Attributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){
        return OAuth2Attributes.builder()
                .userName((String)attributes.get("name"))
                .userEmail((String)attributes.get("email"))
                .userPhone((String)attributes.get("mobile"))
                .attributes(attributes)
                .nameAttributeKey("sub")
                .providerType("GOOGLE")
                .build();
    }

    private static  OAuth2Attributes ofNaver(String userNameAttributeName, Map attributes){
        return OAuth2Attributes.builder()
                .userName((String)attributes.get("name"))
                .userEmail((String)attributes.get("email"))
                .userPhone((String)attributes.get("mobile"))
                .attributes(attributes)
                .nameAttributeKey("email")
                .providerType("NAVER")
                .build();
    }

    public Users toEntity(){
        return Users.builder()
                .userName(userName)
                .userEmail(userEmail)
                .userPhone(userPhone)
                .roleType(RoleType.USER)
                .providerType(providerType)
                .build();
    }

}
