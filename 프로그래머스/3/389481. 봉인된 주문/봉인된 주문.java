import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";

        Arrays.sort(bans, (a,b) -> {
            return Long.compare(alpToNum(a), alpToNum(b));
        });  
        
        int cnt = 0;
        for(int i =0; i < bans.length; i++) {
            if(alpToNum(bans[i]) - cnt > n) continue;
            cnt++;
        }
        answer = numToAlp(n+cnt);
        
        return answer;
    }
    
    public long alpToNum(String val) {
        
        String[] arr = val.split("");
        long converNum = 0;
        for(int i = 0; i < arr.length; i++) {
            converNum += ((int) arr[i].charAt(0) - 96) * Math.pow(26,(arr.length - i-1));
        }
        return converNum;
    }
    
    public String numToAlp(long num) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            num--;
            sb.append((char) ('a' + (num % 26)));
            num /= 26;
        }
        
        return sb.reverse().toString();
    }

    
}

