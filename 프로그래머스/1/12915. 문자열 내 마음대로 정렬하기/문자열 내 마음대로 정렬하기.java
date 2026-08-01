import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings, (a,b) -> {
            
            if(String.valueOf(a.charAt(n)).compareTo(String.valueOf(b.charAt(n))) == 0) {
                return a.compareTo(b);
            }
            return String.valueOf(a.charAt(n)).compareTo(String.valueOf(b.charAt(n)));
        });
        
        answer = strings;
        
        
        return answer;
    }
}