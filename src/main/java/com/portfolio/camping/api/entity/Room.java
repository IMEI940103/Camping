package com.portfolio.camping.api.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_no; // PK키
    private Long camping_no; // camping_info PK키
    private String room_name; // 방이름
    private String room_type; // 방타입
    private String room_introduction; // 소개글귀
    private String checkin_time; // 입실시간
    private String checkout_time; // 퇴실시간
    private int minimum_people; // 최소인원
    private int maximum_people; // 최대인원
    private int room_quantity; // 방갯수
    private int room_price; // 방가격
    private String room_img; // 사진

    @Builder
    public Room(Long camping_no,String room_name,String room_type,String room_introduction,String checkin_time,String checkout_time,int minimum_people,int maximum_people,int room_quantity,int room_price,String room_img){
        this.camping_no = camping_no;
        this.room_name = room_name;
        this.room_type = room_type;
        this.room_introduction = room_introduction;
        this.checkin_time = checkin_time;
        this.checkout_time = checkout_time;
        this.minimum_people = minimum_people;
        this.maximum_people = maximum_people;
        this.room_quantity = room_quantity;
        this.room_price = room_price;
        this.room_img = room_img;

    }


}
