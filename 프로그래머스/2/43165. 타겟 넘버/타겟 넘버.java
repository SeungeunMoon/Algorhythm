import java.util.*;

class Solution {
    static int n, answer, target;
    static int[] numbers;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        n = numbers.length;
        Solution.target = target;
        Solution.numbers = numbers;
        
        dfs(0,0);
        
        return answer;
    }
    
    void dfs(int depth,int total) {
        
        if(depth == n) {
            if(total == target) answer++;
            return;
        }
        
            
        dfs(depth+1, total+numbers[depth]);

        dfs(depth+1, total-numbers[depth]);
        
        
    }
    
}