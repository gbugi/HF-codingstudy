import java.util.Stack;

public class programmers2_1 {

    static class Solution {
        public static int solution(int[] ingredient) {
            int answer = 0;

            Stack<Integer> hamburger = new Stack<>();

            for(int ing : ingredient) {
                hamburger.push(ing);
                if(hamburger.size() >= 4) {
                    int last = hamburger.size() -1;
                    if(hamburger.get(last) == 1 && hamburger.get(last-1) == 3 && hamburger.get(last-2) == 2 && hamburger.get(last-3) == 1) {
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
