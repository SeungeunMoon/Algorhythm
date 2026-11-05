import java.util.*;

class Rec {
    int hour;
    int minutes;
    
    public Rec(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {

        HashMap<String,Integer> totalTime = new HashMap<>();
        HashMap<String, Rec> carInfos = new HashMap<>();
        
        for(String s: records) {
            String[] info = s.split(" ");
            int hour = Integer.parseInt(info[0].split(":")[0]);
            int minutes = Integer.parseInt(info[0].split(":")[1]);
            String number = info[1];
            String flag = info[2];
            
            if(flag.equals("IN")) {
                carInfos.put(number, new Rec(hour, minutes));
            } else {
                Rec r = carInfos.get(number);
                totalTime.put(number, totalTime.getOrDefault(number,0)+(hour-r.hour)*60 + (minutes-r.minutes));
                carInfos.remove(number);
            }
        }
        for(Map.Entry<String, Rec> entry: carInfos.entrySet()) {
            String number = entry.getKey();
            Rec r = entry.getValue();
            totalTime.put(number, totalTime.getOrDefault(number,0)+(23-r.hour)*60 + (59-r.minutes));
        }

        
        Map<String, Integer> sortedTotalTime = new TreeMap<>(totalTime);
        int[] answer = new int[totalTime.size()];
        int idx=0;
        
        for(Integer t: sortedTotalTime.values()) {
            int fee = fees[0];
            if(fee > t) {
                answer[idx++] = fees[1]; 
            }else {
                answer[idx++] = (int)Math.ceil((double)((t-fees[0]))/fees[2]) *fees[3] +fees[1];   
            }
        }
        
        
        
        return answer;
    }
}