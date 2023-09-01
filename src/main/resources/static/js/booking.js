function check(){
            var namechek = document.getElementById('booking_name').value;
            var phonechek = document.getElementById('booking_phone').value;

            if(namechek==null||namechek==""){alert('예약자 이름을 작성해주세요.');return false;}
            if(phonechek==null||phonechek==""){alert('휴대폰 번호를 작성해주세요.');return false;}

            var con1 = !document.getElementById('con1').checked;
            var con2 = !document.getElementById('con2').checked;
            var con3 = !document.getElementById('con3').checked;
            var con4 = !document.getElementById('con4').checked;

            if(con1){alert('약관에 동의해주세요.');return false;}
            if(con2){alert('약관에 동의해주세요.');return false;}
            if(con3){alert('약관에 동의해주세요.');return false;}
            if(con4){alert('약관에 동의해주세요.');return false;}

            if(confirm('결제를 계속 진행 하시겠습니까?')){ document.Form.submit(); }
            else{ return false; }
        }