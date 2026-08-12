import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        
        for(String word: s.split(" ",-1)) {
            if(word.equals("")) {
                answer += " ";
            } else {
                String changed = Character.toUpperCase(word.charAt(0)) + word.substring(1,word.length()).toLowerCase() + " ";
                answer += changed;
            }
        }
        answer = answer.substring(0,answer.length()-1);
        return answer;
    }
}