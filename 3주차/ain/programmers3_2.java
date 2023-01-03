import java.util.HashMap;
import java.util.Map;

public class programmers3_2 {
    class Solution {
        public boolean solution(String[] phone_book) {
            Map<String, Integer> book = new HashMap<>();

            for(int i = 0; i < phone_book.length; i++) {
                book.put(phone_book[i], i);
            }

            for(String s : phone_book) {
                for(int i = 1; i < s.length(); i++) {
                    if(book.containsKey(s.substring(0, i))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}