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

   유닛 뽑기 재화 : 1회당 10원
   유닛 공격력 :
   * 등급 * 30

확률
노말 : 50%
레어 : 25%
고대 : 15%
서사 : 6%
전설 : 3%
신화 : 1%

업그레이드
   * 같은 등급의 유닛끼리 겹치면 한등급 높은 유닛 생성

몬스터 체력
   * 1라운드 ~ 5라운드 : 16의 배수
   * 6 ~ 10 : 5라운드 체력 + 32의 배수
   * 11 ~ 15 : 10라운드 체력 + 64의 배수

보스 체력
   * 5라운드 : 1000
   * 10라운드 : 3000
   * 15라운드 : 7000

라운드당 등장 몬스터수
   * 50마리

최대 마리수
   * 150마리

라운드 타임
   * 3분~5분
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
   |주차|개발 내용|상세개발내용|진척도|
   |---|---|---|---|
   |1주차|리소스|유닛 및 몬스터 배경화면 리소스 수집|90%|
   |2주차|타이틀, 맵|타이틀 화면 및 배경화면 리소스로 맵 구현|100%|
   |3주차|유닛|유닛뽑기 및 유닛 배치 구현|100%|
   |4주차|몬스터|몬스터 등장 및 이동 구현|90%|
   |5주차|유닛, 몬스터|유닛이 몬스터 공격 및 몬스터 사망 구현|100%|
   |6주차|유닛, 몬스터|재화버는것 구현, 유닛 판매 구현, 보스몬스터 구현|0%|
   |7주차|라운드|시간별로 라운드 구현, 라운드별로 몬스터 특정 마리수까지 등장 구현|70%|
   |8주차|게임 종료 및 추가구현|게임오버 및 게임 클리어 구현, 추가개발내용 구현|0%|
   |9주차|마무리 점검 및 추가구현|최종 점검 및 추가개발내용 구현|0%|

-------------------

5. 주차별 커밋수
   ![image](https://github.com/marvin-0/spgp_term_project/assets/58317329/70ad0ed5-a26a-442f-96d6-dcd3523bfb80)

   |주차|커밋수|
   |:---:|:---:|
   |1주차|6회|
   |2주차|2회|
   |3주차|1회|
   |4주차|5회|
   |5주차|5회|

--------------------

6. MainScean에 등장하는 GameObject

   1. PlayerUnit
      * 그림

        노멀 : ![normal_sheet](https://github.com/marvin-0/spgp_term_project/assets/58317329/a683fba2-1f59-45b8-a3c3-74359cad8403)

        레어 : ![rare_sheet](https://github.com/marvin-0/spgp_term_project/assets/58317329/6a52278b-9fd3-40df-9060-96ba068f36dd)

        고대 : ![ancient_sheet](https://github.com/marvin-0/spgp_term_project/assets/58317329/cce8e590-1940-41ce-a9b8-d32e52586321)

        서사 : ![epic_sheet](https://github.com/marvin-0/spgp_term_project/assets/58317329/8d6116a8-168f-4fdf-ac11-b7b8e746cb3a)

        전설 : ![legend_sheet](https://github.com/marvin-0/spgp_term_project/assets/58317329/4b3e8a40-2f4c-4ce7-9e04-0b862a002b6c)

        신화 : ![mystic_sheet](https://github.com/marvin-0/spgp_term_project/assets/58317329/0e0bea52-bd96-4926-a7f3-5647d7c21d5f)

      * 동작구성 : 뽑기 버튼을 누르면 정해진 확률로 유닛이 등장, 공격하지 않는 상태인 idle 상태와 몬스터가 공격범위 안에 들어오면 공격하는 attack 상태가 있다.
      * 상호작용 : 뽑기 버튼을 누르면 정해진 확률로 유닛이 등장한다. 몬스터가 공격범위 안에 들어오면 공격한다. 유닛을 마우스로 클릭하고 드래그하면 위치를 옮길수 있다. 같은 등급의 유닛과 겹쳐지면 하나는 사라지고 하나는 등급이 상승하여 업그레이드 된다.

   2. Enemy
      * 그림
        1단계 : ![monster1_run](https://github.com/marvin-0/spgp_term_project/assets/58317329/f0fe2cc7-d083-4a2b-b3b9-5487ebb8ff94)
        
      * 동작구성 : 좌측상단에 몬스터가 등장하고 각 라운드마다 정해진 마리수가 등장한다. 몬스터는 직사각형맵의 가장자리를 따라가며 이동한다.
      * 상호작용 : 유저가 몬스터를 공격하면 체력이 깎이고 0이하가 되면 사라진다.

   3. mapTile
      * 그림 : ![grass](https://github.com/marvin-0/spgp_term_project/assets/58317329/bc1457e0-7e19-48a7-9169-e719e065bce3)
     
      * 동작구성 : 게임이 시작되면 정사각형 모양으로 4*8배치로 그려진다. 이미 유닛이 놓여진 타일에는 다른 유닛이 배치되지 못하도록 배치된 상태를 체크한다.
      * 상호작용 : 유닛이 타일에 놓이면 타일 정중앙에 위치하도록 한다.
     
   4. ButtonUi
      * 그림

        뽑기버튼 : ![pickup_button](https://github.com/marvin-0/spgp_term_project/assets/58317329/51802204-f4d3-47ff-bbe5-61f9cc8367f4)

        판매버튼 : ![sell_button](https://github.com/marvin-0/spgp_term_project/assets/58317329/a201817b-f89d-4e8e-9107-a7c185cbce61)

      * 동작구성 : 게임이 시작돠면 화면 우측 하단에 배치가 된다.
      * 상호작용 : 마우스로 뽑기버튼을 클릭하면 유닛을 새로 생성한다.


   

   
