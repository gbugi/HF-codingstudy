package HF_Study;

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
        System.out.println(list1);
        System.out.println(list2);

        for(int i=0; i<n; i++){
            // 배열에 삽입하는 과정에서 만약 자리수가 n자리가 아니면 부족한 부분만큼 0을 채워넣어줌
            answer[i]= String.format("%0"+n+"d", (list1.get(i) + list2.get(i)))
                    .replace("1", "#")
                    .replace("2", "#")
                    .replace("0", " ");
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    // 10진수를 2진수로 변환해주는 메서드
    static Long DecimalToBinary(int number) {
        int count = 0;
        long binary_num = 0L;

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

public class programmers1_2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[]{9,20,28,18,11}, new int[]{30,1,21,7,28});
        solution.solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});
    }
}
