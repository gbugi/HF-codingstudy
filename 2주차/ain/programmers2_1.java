import java.util.Stack;

public class programmers2_1 {

    static class Solution {
        public static int solution(int[] ingredient) {
            int answer = 0;

            Stack<Integer> hamburger = new Stack<>();

            for(int ing : ingredient) {
                hamburger.push(ing);
                // 스택의 크기가 4 이상일 때 부터 체크
                if(hamburger.size() >= 4) {
                    int last = hamburger.size() -1;
                    if(hamburger.get(last) == 1 && hamburger.get(last-1) == 3 && hamburger.get(last-2) == 2 && hamburger.get(last-3) == 1) {
                        //스택의 제일 위의 값 부터 빵(1), 고기(3), 야채(2), 빵(1) 이면 스택에서 제거하고 answer 1 추가
                        answer++;
                        hamburger.pop();
                        hamburger.pop();
                        hamburger.pop();
                        hamburger.pop();
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        System.out.println(Solution.solution(ingredient));
    }

}
