import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int[] lefts = new int[progresses.length];
        
        for(int i = 0; i < progresses.length; i++) {
            lefts[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int longest = lefts[0];
        int cnt = 1;
        for(int i = 1; i < lefts.length; i++) {
            if(longest < lefts[i]) {
                longest = lefts[i];
                result.add(cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        if(cnt > 0) result.add(cnt);

        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
    return answer;
        
    }
}

