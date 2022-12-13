## 1번 풀이
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
