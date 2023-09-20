package com.portfolio.camping.api.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Camping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long camping_no; // PK키
    private String camping_name; // 캠핑장명
    private String camping_address; // 사업지주소
    private String camping_number; // 사업자연락처
    private String camping_introduction; // 소개글귀
    private String camping_builder; // 시설정보. 배열화
    private String camping_natural; // 주변자연환경. 배열화
    private String camping_type; // 캠핑장 타입. 배열화 .-->값은 room_info의 타입을 취합.
    private String camping_img; // 사진 배열

    @Builder
    public Camping(String camping_name,String camping_address,String camping_number,String camping_introduction,String camping_builder,String camping_natural,String camping_type,String camping_img){
        this.camping_name = camping_name;
        this.camping_address = camping_address;
        this.camping_number = camping_number;
        this.camping_introduction = camping_introduction;
        this.camping_builder = camping_builder;
        this.camping_natural = camping_natural;
        this.camping_type = camping_type;
        this.camping_img = camping_img;
    }
}
