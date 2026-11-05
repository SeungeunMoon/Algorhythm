import java.util.*;

class Solution {
    class User {
        int reported;
        List<String> report;
        
        public User(int reported) {
            this.reported = reported;
            this.report = new ArrayList<>();
        }
        public void addReport(String name) {
            this.report.add(name);
        }
    }
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, User> users = new HashMap<>();
        for(String id: id_list) {
            users.put(id, new User(0));
        }
        
        for(String s:report) {
            String from = s.split(" ")[0];
            String to = s.split(" ")[1];
            
            if(users.get(from).report.contains(to)) continue;
            users.get(to).reported++;
            users.get(from).addReport(to);
        }
        
        List<String> blocked = new ArrayList<>();
        for(Map.Entry<String, User> entry: users.entrySet()) {
            if(entry.getValue().reported >= k) blocked.add(entry.getKey());
        }
        
        for(int i=0; i<id_list.length; i++) {
            User user = users.get(id_list[i]);
            for(String s: user.report) {
                if(blocked.contains(s)) {
                    answer[i] = answer[i]+1;
                }
            }
        }

        
        return answer;
    }
}