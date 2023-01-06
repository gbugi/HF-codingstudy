# 1번 풀이
주어진 양의 정수가 연속되는 수의 합으로 몇번이나 표현되는지 알아보는 문제이다.   
로직은 간단하다.   
i는 1부터 주어진 n까지 for문을 돌면서, 연속되는 수의 합이 sum 보다 작거나 같을때까지 while문으로 반복하고, sum이 n일때 answer+1을 해주면서 while문 break,   
아닐때는 sum+=num(num은 for문이 다시 돌때 초기화되게=i)과 해당 num+1을 해주면된다.   

## 기가막힌 풀이(수학적인 접근= **등차중앙** 이용)
![image](https://user-images.githubusercontent.com/75151693/210743929-d629419d-1946-4c85-8a7e-6c536c1ebb2e.png)

</br>
 
# 2번 풀이

<br>

# 3번 풀이
재귀를 이용한 문제인줄 알고 풀었는데, 두 번의 시행착오를 거쳤다. 이유는 아래와 같다.
1. 첫번째 오류코드는 모든 피보나치 수를 재귀로 리스트에 담아서 리스트.get(i) % 1234567 로 결과를 도출했다. 하지만 이 방법은, 엄청난 Stack Overflow가 발생한다.   
2. 두번째 오류코드는 피보나치 수를 구하기 위한 정석 재귀 방식으로 풀었는데, 시간초과가 떴다. 이유는 n이 엄청나게 큰 숫자라면(ex: 100,000), 재귀하는데만 엄청난 시간이 걸리기 때문이다.   

> 오류코드1
 ```Java
import java.util.ArrayList;
import java.util.List;

class Solution {
   List<Integer> list = new ArrayList<>();

   public int solution(int n) {
        list.add(0);
        list.add(1);

        recursive(list, n, 0);

        int answer = list.get(n) % 1234567;
        return answer;
    }

    public void recursive(List<Integer> fiboList, int num, int last_index) {
        System.out.println(fiboList);
        int fibo = 0;
        if(fiboList.size() == num+1) {
            return;
        }
        for(int i = last_index; i <= last_index+1; i++) {
            fibo += fiboList.get(i);
        }

        fiboList.add(fibo);
        recursive(fiboList, num, last_index+1);
    }
}
```                                                    
> 오류코드2
```Java
class Solution {

    public int solution(int n) {

        int answer = fibonaci(n) % 1234567;
        return answer;
    }

    public int fibonaci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        else {
            return fibonaci(n-1) + fibonaci(n-2);
        }
    }
}
```

</br>

## 문제해결
따라서 재귀로 풀지않고, 중복된 연산을 여러번하는 낭비를 줄이기 위해 **동적 계획법(Dynamic programming)**으로 코딩을 해보았다.   
> 해결코드
```Java
class Solution {
    public int solution(int n) {
        
        int answer = fibo(n);
        return answer;
    }
    
    public int fibo(int n) {
        int[] cache = new int[n+1];
        
        cache[0] = 0;
        cache[1] = 1;
        
        for (int i=2; i<= n; i++){
            // 99999와 같이 큰 수를 넣을 경우 int와 long타입의 범위를 넘어
            // 값들을 문제 조건에 맞게 1234567로 나눈 나머지로 저장
            cache[i] = (cache[i-1] + cache[i-2]) % 1234567;
        }
        
        return cache[n] % 1234567;
    }
}
```

## 결론
피보나치는 가장 기본중의 기본인 코드이지만 아무런 생각 없이 Recursive하게 된다면 중복된 연산을 반복해서 해야하는 시간 낭비와 계속 함수 내부에서 함수를 호출하여 메모리를 많이 사용해야하는 메모리 낭비가 발생하게 된다. 이러한 경우는 **Dynamic programming**을 하여 중복연산과 불필요한 메모리 사용을 줄이도록 코딩해야한다.   

또한 "n은 1이상, 100000이하인 자연수입니다"와 같은 문제의 조건을 잘 읽어 문제의 연산을 하며 자료형의 범위를 넘지 않는지도 생각해야 한다.
