# spgp_term_project
1. 게임소개
   
   게임 이름 : 운빨디펜스

   * 스타크래프트1의 유즈맵 "메이플 운빨 디펜스"의 모작
   * 디펜스 장르
   * 맵 주위를 돌아다니는 몬스터를 유저가 랜덤하게 뽑은 유닛으로 죽이는 게임
-----------------
2. 개발범위

   |내용|필수개발내용|추가개발내용|
   |:---:|:---:|:---:|
   |UI|타이틀, 뽑기, 게임 결과, 돈, 판매|미션, 업그레이드|
   |유닛|6개의 등급, 공격, 배치|특수 공격, 3종류의 공격방식을 가진 유닛|
   |몬스터|움직임, 보스몬스터|미션용 몬스터, 보스 몬스터 스킬, 3종류의 방어형태|

   타이틀 : 게임시작, 게임종료 2가지 버튼과 게임 이름이 적혀있는 화면
   
   인게임 : 우측하단에 뽑기버튼, 판매버튼, 우측 상단에 돈과 현재 남아있는 몬스터 개체수 알려주는 문자
   
   유닛 : 6개의 등급으로 나누어진 유닛, 등급별로 공격력과 공격거리, 공격속도를 나눔, 유닛이 등장하면 드래그해서 배치가능
   
   몬스터 : 3~5종류의 몬스터, 3마리의 보스몬스터
----------------
3. 예상 게임 흐름

   1. 게임이 시작되면 랜덤하게 유닛을 뽑아서 맵 가장자리에 등장하는 몬스터를 잡습니다.
  
   ![image](https://github.com/marvin-0/spgp_term_project/assets/58317329/2e8be339-a61e-4264-85d6-35a85c992ed3)
   
   ![image](https://github.com/marvin-0/spgp_term_project/assets/58317329/d5fbfc9c-fe15-4bbf-a5b3-155536f95d46)
   
   2. 유닛은 등급이 나뉘어져있고 뽑기를 하면 확률에 따라서 등급별로 유닛이 등장합니다. 낮은 확률의 등급일수록 공격력이 높고 공격거리와 속도도 빠릅니다.
   
   ![image](https://github.com/marvin-0/spgp_term_project/assets/58317329/bf394cd9-94ed-4fc8-ba85-719d3cb08d0c)

   3. 몬스터는 각 라운드마다 정해진 마리수만큼 등장하고 특정 마리수이상 몬스터가 있으면 게임은 패배하게 됩니다.

   ![image](https://github.com/marvin-0/spgp_term_project/assets/58317329/31b7914f-ee25-4911-a208-b26310eb9752)

   4. 특정 라운드마다 보스몬스터가 등장하고 그 라운드안에 보스를 잡지못하면 즉시 게임에서 패배하게 됩니다. 그러나 보스를 잡으면 많은 재화를 얻을 수 있습니다.
  
   ![image](https://github.com/marvin-0/spgp_term_project/assets/58317329/b6c1760e-1fa9-435a-a9e3-b9eeadd0bbd6)

---------------------

4. 개발일정
   |주차|개발 내용|상세개발내용|
   |---|---|---|
   |1주차|리소스|유닛 및 몬스터 배경화면 리소스 수집|
   |2주차|타이틀, 맵|타이틀 화면 및 배경화면 리소스로 맵 구현|
   |3주차|유닛|유닛뽑기 및 유닛 배치 구현|
   |4주차|몬스터|몬스터 등장 및 이동 구현|
   |5주차|유닛, 몬스터|유닛이 몬스터 공격 및 몬스터 사망 구현|
   |6주차|유닛, 몬스터|재화버는것 구현, 유닛 판매 구현, 보스몬스터 구현|
   |7주차|라운드|시간별로 라운드 구현, 라운드별로 몬스터 특정 마리수까지 등장 구현|
   |8주차|게임 종료 및 추가구현|게임오버 및 게임 클리어 구현, 추가개발내용 구현|
   |9주차|마무리 점검 및 추가구현|최종 점검 및 추가개발내용 구현|
   

   

   
