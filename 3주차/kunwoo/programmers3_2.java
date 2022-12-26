package HF_Study.programmers3;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        Set<String> phone = new HashSet<>();
        for(String p : phone_book) phone.add(p);

        for(String p : phone_book) {
            for(int i = 1; i < p.length(); i++){
                if(phone.contains(p.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}