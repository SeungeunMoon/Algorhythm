import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, Integer> alps = Map.of(
            "zero", 0,
            "one" , 1,
            "two" , 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six" , 6,
            "seven",7,
            "eight", 8,
            "nine", 9
        );
    
        for(Map.Entry<String,Integer> entry: alps.entrySet()) {
            s = s.replace(entry.getKey(), entry.getValue().toString());
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}