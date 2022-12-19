# 1번 풀이
문제 자체는 복잡한 문제는 아니었으나, Python이 확실히 데이터 인덱싱에 탁월한 언어임을 꺠달았다.

문제 풀이 로직에 대해 간단히 설명하면,
1. stack을 선언하고, 재료가 순서대로 1,2,3,1 일때 햄버거 하나를 만들 수 있으므로, 정답 재료 배열 {1,2,3,1}을 선언한다.
2. 주어진 총 재료 배열(ingredient)을 차례대로 돌면서 stack에 push한다.
3. stack의 크기가 4이상이 되면, stack의 마지막 인덱스 -4 부터 마지막 인덱스 까지 값을 가져와서 임시배열(tempArr)에 값을 넣어준다.
4. 그리고 임시배열과 정답 재료 배열이 같으면, stack에서 pop을 4번 시행하고 answer의 크기를 1증가 시킨다.
</br>

## 로직구현과정에서의 필요한 개념
배열 비교시 ==를 사용하면, 두 배열의 Heap주소 값을 비교하므로 배열의 타입, 동일한 수의 요소 그리고 정렬 순서가 동일하더라도 두 배열은 동일하지 않다.   

따라서, 배열을 비교할때는 Arrays.equals()메서드를 사용하여, 주소값을 비교하는 것이 아닌 배열의 원소를 비교하도록 하자.   
(ps. 다차원 배열일때는 deepEquals()메서드를 사용할 것)
 
</br>

## 다른 사람의 좋은코드
제출 후, 풀이를 보다가 기발하고 간단하게 짠 코드가 있어서 참고하기 위해 기재하였다.

``` java
class Solution2 {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                    && stack[sp - 2] == 3
                    && stack[sp - 3] == 2
                    && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }
}
```
</br>