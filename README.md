## 플로우 과제
1. 파일 확장자 차단 (table과 화면 개발)


## Vue.js + Springboot
frontend (화면) / src(서버)


## 테이블 구조
1. no(PK)     [int]             => 확장자 추가 시 최대값+1 증가 
2. name(UQ)   [varchar(20)]     => 확장자 명
3. select_chk [tinyint]         => 고정 확장자 체크 여부 (0=false, 1=true)
4. type       [varchar(3)]      => 고정,커스텀 구분 (FIX/CUS)
5. add_cnt    [int]             => 확장자 추가 시 중복이면 증가 (선호도 확인용으로 만들어봤습니다.)

![image](https://user-images.githubusercontent.com/84958504/123897928-496f7200-d99f-11eb-84eb-741c22afd7da.png)


## 고려한 점
1. 커스텀 확장자 중복 체크  => 중복체크를 하기보단 pk가 있으면 sql에서 업데이트를 하는 형식으로 하였습니다.
2. 대소문자 구분           => LOWER를 사용하여 대소문자구분 없이 소문자로 체크하여 확장자를 추가하는 방식으로 하였습니다.
   ex) Txt = txt
   
3. 확장자 명               => 영어만!




