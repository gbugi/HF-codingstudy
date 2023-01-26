public class programmers6_1 {
    //Programmers_다음 큰 숫자_lv2

    static class Solution {
        public static int solution(int n) {
            int a = Integer.bitCount(n);

            do {
                n++;
            } while (a != Integer.bitCount(n));

            return n;
        }


        //효율성 테스트 out
        /*
        public static int solution(int n) {
            //int answer = 0;
            String binaryN = Integer.toBinaryString(n);
            int one = (int)countChar(binaryN, '1');
            while(true) {
                n++;
                String binaryNewN = Integer.toBinaryString(n);
                int one_new = (int)countChar(binaryNewN, '1');
                if(one_new==one) break;
            }

            return n;
        }

        public static long countChar(String str, char ch) {
            return str.chars()
                    .filter(c -> c == ch)
                    .count();
        }

    */
    }

    public static void main(String[] args) {
        int n = 78;
        System.out.println(Solution.solution(n));
    }

}
