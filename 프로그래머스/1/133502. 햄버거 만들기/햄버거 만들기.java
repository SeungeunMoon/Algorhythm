import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        
        StringBuilder sb = new StringBuilder();
        
        int answer = 0;
        int n = ingredient.length;
        
        for(int i = 0; i < n; i++) {
            
            sb.append(ingredient[i]);
            
            if(sb.length() > 3 && sb.substring(sb.length()-4, sb.length()).contentEquals("1231")) {
                answer++;
                sb.delete(sb.length()-4, sb.length());
            }
        }
        
        return answer;
    }
}

