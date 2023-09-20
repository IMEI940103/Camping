package com.portfolio.camping.api.service;

import com.portfolio.camping.api.entity.Camping;
import com.portfolio.camping.api.entity.Camping_Repository;
import com.portfolio.camping.api.entity.Room;
import com.portfolio.camping.api.entity.Room_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImportSQL {

    private final Camping_Repository campingRepository;
    private final Room_Repository roomRepository;

    public void init_insert_campinginfo(){

        String[] camping_name = {"프라이빗 캠핑장","단양 포시즌카라반","서울북한산카라반","클럽레스피아 in 태안점(구름포해수욕장)"};
        String[] camping_address = {"충청북도 충주시 살미면 월악로 1233","충청북도 단양군 가곡면 남한강로 1117","서울특별시 은평구 북한산로 242","충청남도 태안군 소원면 구름포길 117"};
        String[] camping_number = {"010-9222-1334","070-4336-1824","010-7652-0734","070-7719-6882"};
        String[] camping_introduction = {
                "프라이빗 캠프닉 신규오픈했습니다.<br />충주월악선착장 내 위치하였고 피크닉과 캠핑을 선택하여 즐기실 수 있도록 각각의 개별동으로 사이트를 만들어놓았습니다.<br /> 개별 사이트내 바베큐존에서 충주호의 낭만과 월악산의 경치를 한번에 즐길실 수 있는 힐링 캠핑공간입니다.<br /> ※냉난방가능,에어컨,전자레인지,커피포트,침구류,식기,버너 구비 되어있습니다.",
                "저희 단양 포시즌펜션은 단양의 아름다운 남한강 강줄기위에 위치해있으며, 현재 모든 객실은 캠핑카식 카라반으로 운영하고 있습니다.<br /> 여러분들은 한번쯤 캠핑카를 타고 여행을 하는 꿈을 꾸었을 것입니다. 단양포시즌펜션에서는 그 꿈을 잠시 이루어 드립니다. 새로운 여행을 즐기고 싶으신 분은 저희 단양 포시즌펜션으로 오세요.<br />여러분의 색다른 여행에 불편함 없는 휴식이 되도록 최선을 다할 것입니다.<br />감사합니다.",
                "<<<<<<예약 전 필독 주의사항>>>>>><br />※네이버예약과 위에 나와있는 홈페이지를 제외한 다른 사이트는 예약이 불가합니다.<br />(가끔 다른플랫폼에서 마음대로 오픈합니다.)<br /><br />※두가족,두커플 이상 예약 절대불가.<br />(몰래 예약하고 와서 붙여달라고 할시 두팀 모두 환불없이 강제퇴실입니다.!!)",
                "구름포 해수욕장이 바로 앞에 위치하며, 저녁 노을을 감상할 수 있는 멋진 비치와 산책로를 걸어보세요.<br />갯벌채집,바다낚시가 가능한 황금스팟으로 놀러오세요!"
        };
        String camping_builder = "시설정보";
        String[] camping_natural = {
                "river,forest",
                "forest",
                "city,forest",
                "sea,forest"
        };
        String[] camping_type = {
                "auto,glamping",
                "caravan",
                "caravan,easycamp",
                "auto,caravan,glamping"
        };
        String camping_img = "이미지";

        for(int i=0;i<= camping_name.length-1;i++){
            campingRepository.save(
                    Camping.builder()
                            .camping_name(camping_name[i]).camping_address(camping_address[i]).camping_number(camping_number[i])
                            .camping_introduction(camping_introduction[i]).camping_builder(camping_builder).camping_img(camping_img)
                            .camping_natural(camping_natural[i]).camping_type(camping_type[i]).build()
            );
        }


    }

    public void init_insert_room(){
        Long[] camping_no = {
                1L,1L,1L,
                2L,2L,2L,2L,
                3L,3L,3L,3L,3L,3L,
                4L,4L,4L,4L
        };
        String[] room_name = {
                "*오토캠핑*캠핑사이트/파쇄석","*글램핑B*","*카라반*",
                "웨건 3시간 피크닉(점심) *11시~14시","웨건 3시간 피크닉(오후) *15시~18시","웨건 3시간 피크닉(저녁) *19시~22시","고급형 2~4인 카라반",
                "*카라반1호*","*카라반2호*","*카라반3호*","*카라반4호*","*카라반5호*","*카라반6호*",
                "오토캠핑존","두가족 캠핑사이트","세모동(방갈로)","네모동(방갈로)"
        };
        String[] room_type = {
                "auto","glamping","caravan",
                "easycamp","easycamp","easycamp","caravan",
                "caravan","caravan","caravan","caravan","caravan","caravan",
                "auto","auto","glamping","glamping"
        };
        String[] room_introduction = {
                "자가텐트를 준비해오시는 상품입니다.","글램핑은 신발신고 이용하는 객실입니다. 객실배정은 랜덤배정입니다.","카라반 객실은 반드시 신발을 벗고 입실해주세요. 객실배정은 랜덤입니다.",
                "피크닉이란 숙박없이 정해진 시간내에서 캠핑시설을 이용하는것을 의미합니다.","피크닉이란 숙박없이 정해진 시간내에서 캠핑시설을 이용하는것을 의미합니다.","피크닉이란 숙박없이 정해진 시간내에서 캠핑시설을 이용하는것을 의미합니다.","23시 이후 술, 음식 섭취 불가",
                "- 반려동물 입실 절대 불가<br />- 카라반 원룸 형태의 객실로 침대룸과 거실, 주방, 화장실로 이루어져 있습니다","- 반려동물 입실 절대 불가<br />- 카라반 원룸 형태의 객실로 침대룸과 거실, 주방, 화장실로 이루어져 있습니다","- 반려동물 입실 절대 불가<br />- 카라반 원룸 형태의 객실로 침대룸과 거실, 주방, 화장실로 이루어져 있습니다","- 반려동물 입실 절대 불가<br />- 카라반 원룸 형태의 객실로 침대룸과 거실, 주방, 화장실로 이루어져 있습니다","- 반려동물 입실 절대 불가<br />- 카라반 원룸 형태의 객실로 침대룸과 거실, 주방, 화장실로 이루어져 있습니다","- 반려동물 입실 절대 불가<br />- 카라반 원룸 형태의 객실로 침대룸과 거실, 주방, 화장실로 이루어져 있습니다",
                "오토캠핑으로 예약하시면 방갈로 미개방되며,각각의 사이트내 바베큐존은 사용가능","두가족 캠핑사이트","충주호가 훤히 보이는 뷰입니다.","충주호가 훤히 보이는 뷰입니다."
        };
        String[] checkin_time = {
                "15:00","15:00","15:00",
                "11:00","15:00","18:00","15:00",
                "15:00","15:00","15:00","15:00","15:00","15:00",
                "14:00","14:00","15:00","15:00"
        };
        String[] checkout_time = {
                "11:00","11:00","11:00",
                "14:00","18:00","22:00","11:00",
                "11:00","11:00","11:00","11:00","11:00","11:00",
                "00:00","11:00","00:00","00:00"
        };
        int minimum_people = 2;
        int[] maximum_people = {
                4,4,4,
                5,5,5,4,
                4,6,4,6,5,6,
                4,8,4,4
        };
        int room_quantity = 1;
        int[] room_price = {
                40000,88000,108000,
                50000,50000,50000,149000,
                100000,100000,100000,100000,100000,100000,
                60000,100000,100000,100000
        };
        String room_img = "방사진";

        for(int i = 0; i<=room_name.length-1; i++){
            roomRepository.save(Room.builder()
                    .camping_no(camping_no[i])
                    .room_name(room_name[i]).room_type(room_type[i]).room_introduction(room_introduction[i])
                    .checkin_time(checkin_time[i]).checkout_time(checkout_time[i]).minimum_people(minimum_people)
                    .maximum_people(maximum_people[i]).room_quantity(room_quantity)
                    .room_price(room_price[i]).room_img(room_img)
                    .build());
        }

    }




}
