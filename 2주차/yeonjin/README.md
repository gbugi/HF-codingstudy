## 1번 문제 (햄버거 만들기)
1. 새로운 리스트를 생성(스택으로 사용하기 위함), ingredient의 원소를 하나씩 담음
2. 재료가 4개이상 쌓였을때 마지막 4개의 값이 각각 1,3,2,1 일 때 (인덱스 : -1 ~ -4)
3. 마지막 값 4개를 pop 하고 answer에 1 더해줌


## 2번문제 (성격유형검사)
1. 각 유형을 key로 하고 value가 0인 dictionary를 생성 
2. 점수는 각 문항에서 선택한 점수에서 4를 뺀 값으로 함 (중간값 '모르겠음'을 0점으로 하기 위함)
3. survey에 있는 값이 1.에서 생성한 키값이랑 일치할 경우 value에 2.에서 계산한 점수를 더함/
   일치하지 않을 경우 value에 2.에서 계산한 점수를 뺀다
4. dictionary 에서 각 지표에 해당하는 value값을 이용해 판별
   * value <= 0  첫번째 문자에 해당하는 값이 성격유형이 됨
   * value  > 0  두번째 문자에 해당하는 값이 성격유형이 됨

## 3번문제 (프린터)
1. deque를 사용하기 위해 -> from collections import deque
2. priorities와 location을 담을 deque를 각각 선언
3. priorities의 인덱스와 요소를 각각 deque에 추가
4. 현재 deque의 max값을 구함 -> deque의 원소 pop하기
 
