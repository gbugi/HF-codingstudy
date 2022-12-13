class Solution {
    public String solution(int[] food) {
        int total = 0;
        for(int data : food) {
            if(data/2 != 0 && data%2 == 0) {
                total += data;
            } else if(data/2 != 0 && data%2 == 1) {
                total += data-1;
            }
        }

        if(total%2 == 0) {
            total+=1;
        }

        int[] answer_arr = new int[total]; //초기값 0으로 세팅

        int last_index = 0;
        int temp_index = 0;
        for(int i = 1; i <food.length; i++) {
            int cnt = food[i] / 2;
//            System.out.println("cnt : " + cnt);
            if(cnt != 0) {
               for(int j = last_index; j < last_index + cnt; j++){
                   answer_arr[j] = i;
                   answer_arr[total-1-j] = i;
                   if(j==0) temp_index = 1;
                   else temp_index = j+1;
//                   System.out.println(Arrays.toString(answer_arr));
               }
               last_index = temp_index;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int a : answer_arr) {
            sb.append(String.valueOf(a));
        }

        String answer = sb.toString();
        return answer;
    }
}
