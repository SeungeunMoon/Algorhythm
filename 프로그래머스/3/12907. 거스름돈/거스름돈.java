import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int unit: money) {
            
            for(int i =1; i<= n; i++) {
                if (i >= unit){
                    dp[i] += dp[i-unit];
                }
            }
            
        }
        
        answer = dp[n]%1000000007;
        
        return answer;
    }
}