# 1번 풀이
문제를 보고 Python dictionary와 set자료형을 써야겠다고 생각이 들어, Java에서는 HashMap과 HashSet을 사용하면 좋겠다고 판단을 하고 접근하였다.   

두개의 HashMap을 생성했는데,
(신고한사람, 신고당한사람목록)의 데이터를 담은 key, value를 가지는 Map 하나(reporter_map)와
(신고당한사람, 신고당한횟수)의 데이터를 담은 key, value가지는 Map 하나(reported_map)이 각각이다.   

각각의 Map에 data를 넣기 위해 report 배열(신고한사람, 신고당한사람)에서 data를 가져와야하는데,
먼저 [muzi frodo], [muzi frodo]와 같은 중복된 값은 제거를 한 뒤 로직을 구현해야하기에, 배열 -> 리스트 -> set 자료형으로 바꿔줬다.
그 뒤 set에서 데이터를 꺼내고 Map에 값을 삽입하는 방식으로 로직을 처리했다.

</br>

## 로직구현과정에서의 필요한 개념
Map에 값을 삽입할 때, 해당 키의 유무에 따라 값을 추가해주는 방식이 달랐다.

여기서 Map 인터페이스가 가지고 있는 **putIfAbsent**와 **getOrDefault** 메서드를 사용하였는데, 이 두가지 메서드에 대해 알아보겠다.

**putIfAbsent**란?   
> Key 값이 존재하는 경우 Map의 Value의 값을 반환하고, Key값이 존재하지 않는 경우 Key와 Value를 Map에 저장하고 Null을 반환하는 메서드.

**getOrDefault**란?
> 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드

해당 문제에서는 **putIfAbsent**를 통해 Map에 값을 삽입할 때는, 해당 Key가 존재하지 않을 때 이므로, value부분에 새로운 HashSet생성자를 생성하고, 값을 추가해줘야했다.

아래와 같은 방식으로 말이다.
```Java
reporter_map.putIfAbsent(reporter, new HashSet<String>(){{
    add(reported);
}});
```
 
다음으로, **getOrDefault**을 사용한 이유는, reported_map에 데이터를 삽입하는 과정에서,      
해당 key(여기서는 reported)가 존재할 때는, 해당key의 value+1값을 삽입해줘야 했고,   
해당 key가 존재하지 않을 때는, value에 1을 삽입해줘야 했기에, 이 두가지를 만족할만한 메서드는   
getOrDefault(reported, 0)+1을 통해 키가 없을때는 0을 반환, 있을때는 해당 key의 value를 반환할 수 있게 하였다.   

</br>

## 다른 사람의 좋은코드
제출 후, 풀이를 보다가 stream api를 사용한 멋진 코드가 있어서 참고하기 위해 기재하였다.

``` java
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}
```
</br>

***
# 2번 풀이
이 문제를 해결하기 위해서는 아래와 같은 로직을 따른다. 
1. 10진수를 2진수로 변환하고
2. 변환한 수들을 다시 리스트(Integer형)에 담고,
3. 리스트의 각 인덱스의 원소들을 더해서 자리수가 n자리가 아니라면 빈 자리만큼 0을 채워준다(String.format사용).
4. 그 다음, replace메서드를 통해 1과2는 -> "#" , 0은 -> " "(공백) 으로 치환해주고 answer 배열에 넣어준다. 

***
하지만 최종 제출을 했더니, 아래와 같이 테스트 케이스 2번과 6번에서 시간초과가 떴었다.   
![image](https://user-images.githubusercontent.com/75151693/207253851-d5085827-9679-4aa2-9524-ee74984093c1.png)   

## 시간초과뜬 코드 
```Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        List<> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        String[] answer = new String[n];

        for(int ar1 : arr1){
            list1.add(DecimalToBinary(ar1));
        }

        for(int ar2 : arr2){
            list2.add(DecimalToBinary(ar2));
        }
        
        for(int i=0; i<n; i++){
            answer[i]= String.format("%0"+n+"d", list1.get(i)+list2.get(i))
                    .replace("1", "#")
                    .replace("2", "#")
                    .replace("0", " ");
        }

        return answer;
    }

    static int DecimalToBinary(int number) {
        int count = 0;
        int binary_num = 0;

        while(number!=0){
            int remainder = number % 2; 
            double num_of_digits = Math.pow(10, count); 
            binary_num += remainder * num_of_digits; 
            number /= 2;
            count ++;
        }
        return binary_num;
    }
}
```

## 해결방법
이류를 검색해보니, 테스트 케이스 2,6번은 대입하는 값이 크기 때문에,   
**변환 과정에서 Integer형으로 표현할 수 있는 최대 값을 초과**해서 런타임 에러가 발생한다고 한다.   
그래서 Integer 타입을 Long타입으로 바꿔줬더니 해결되었다.

## 해결한 코드
```Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();
        String[] answer = new String[n];

        // 주어진 배열을 이진수로 나타내고 리스트에 담기
        for(int ar1 : arr1){
            list1.add(DecimalToBinary(ar1));
        }

        for(int ar2 : arr2){
            list2.add(DecimalToBinary(ar2));
        }

        for(int i=0; i<n; i++){
            // 배열에 삽입하는 과정에서 만약 자리수가 n자리가 아니면 부족한 부분만큼 0을 채워넣어줌
            answer[i]= String.format("%0"+n+"d", (list1.get(i) + list2.get(i)))
                    .replace("1", "#")
                    .replace("2", "#")
                    .replace("0", " ");
        }

        return answer;
    }

    // 10진수를 2진수로 변환해주는 메서드
    static Long DecimalToBinary(int number) {
        int count = 0;
        long binary_num = 0;

        while(number!=0){
            int remainder = number % 2; // 나머지(0 or 1)
            double num_of_digits = Math.pow(10, count); // 자릿수
            binary_num += (long)(remainder * num_of_digits); // 자리수 * 나머지
            number /= 2;
            count ++;
        }
        return binary_num;
    }
}
```
