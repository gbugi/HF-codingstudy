public class programmers3_1 {

    static class Solution {
        static int answer = 0;

        public static int solution(int[] numbers, int target) {
            dfs(numbers, 0, target, 0);

            return answer;
        }

        // 깊이 우선 탐색
        public static void dfs(int[] numbers, int depth, int target, int sum){
            if(depth == numbers.length){
                //마지막 노드까지 탐색했을 때 결과값과 타겟넘버가 같은지 확인하여 answer +1
                if(target == sum) answer++;
            } else {
                //재귀함수 사용하여 해당 노드의 값을 더한 뒤 다음 깊이 탐색
                dfs(numbers, depth + 1, target, sum + numbers[depth]);
                //재귀함수 사용하여 해당 노드의 값을 뺀 뒤 다음 깊이 탐색
                dfs(numbers, depth + 1, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
            }
        }


//        public static int solution(int[] numbers, int target) {
//            int answer = 0;
//            answer = dfs(numbers, 0, 0, target);
//            return answer;
//        }
//        static int dfs(int[] numbers, int depth, int sum, int target) {
//            if(depth == numbers.length) {
//                if(sum == target) {
//                    return 1;
//                }
//                return 0;
//            }
//            return dfs(numbers, depth + 1, sum + numbers[depth], target) + dfs(numbers, depth + 1, sum - numbers[depth], target);
//        }
    }

    public static void main(String[] args) {
//        int[] numbers = {1, 1, 1, 1, 1};
//        int target = 3;

        int[] numbers = {4, 3, 2, 1};
        int target = 4;

        System.out.println(Solution.solution(numbers, target));

    }
}
