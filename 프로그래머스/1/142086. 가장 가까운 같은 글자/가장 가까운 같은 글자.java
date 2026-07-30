import java.util.*;
//map

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        HashMap<String,Integer> maps = new HashMap<>();
        int idx = 0;
        
        for(String tk: s.split("")) {
            if(maps.get(tk) == null) {
                answer[idx] = -1;
            } else {
                answer[idx] = idx - maps.get(tk);
            }
            maps.put(tk,idx++);
        }
        
        return answer;
    }
}