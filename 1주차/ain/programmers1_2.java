public class programmers1_2 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        int[][] mapArr1 = binaryFunc(n, arr1);
        int[][] mapArr2 = binaryFunc(n, arr2);

        for(int i = 0; i < n; i++) {
            StringBuffer answerStr = new StringBuffer();
            for(int j = 0; j < n; j++) {
                if(mapArr1[i][j] == 1 || mapArr2[i][j] == 1){
                    answerStr.append("#");
                }else {
                    answerStr.append(" ");
                }
            }
            answer[i] = answerStr.toString();
        }

        return answer;
    }

    public static int[][] binaryFunc(int n, int[] arr) {
        int[][] mapArr = new int [n][n];
        for(int i = 0; i < n; i++) {
            int binary = arr[i];
            for(int j = n-1; j >= 0; j--) {

                if(binary >= 1) {
                    mapArr[i][j] = binary % 2;
                    binary /= 2;
                }else {
                    mapArr[i][j] = 0;
                }

            }
        }

        return mapArr;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 29, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = solution(n, arr1, arr2);
        for(String str : answer) {
            System.out.println(str);
        }
    }
}
