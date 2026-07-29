import java.util.*;

class Solution {
    
    class Job implements Comparable<Job> {
        int id, start, duration;
        
        public Job(int id, int start, int duration) {
            this.id = id;
            this.start = start;
            this.duration = duration;
        }
        
        @Override
        public int compareTo(Job o) {
            if(this.duration == o.duration) {
                if(this.start == o.start) {
                    return Integer.compare(this.id, o.id);
                }
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.duration, o.duration);
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int total = 0;
        
        PriorityQueue<Job> sortedJobs = new PriorityQueue<>((a, b) -> {
                if (a.start == b.start) {
                    return Integer.compare(a.duration, b.duration);
                }
                return Integer.compare(a.start, b.start);
            });
        
        for(int i =0; i < jobs.length; i++) {
            sortedJobs.add(new Job(i, jobs[i][0], jobs[i][1]));
        }
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        pq.add(sortedJobs.poll());
        time = pq.peek().start;
        
        while(!pq.isEmpty() || !sortedJobs.isEmpty()) {
            if(pq.isEmpty()) {
                Job cur = sortedJobs.poll();
                time = cur.start + cur.duration;
                total += cur.duration;
            } else {
                Job cur = pq.poll();
                time += cur.duration;
                total += (time - cur.start);
            }
            while(!sortedJobs.isEmpty() && sortedJobs.peek().start <= time){
                pq.add(sortedJobs.poll());
            }
        }
        answer = total / jobs.length;
        
        return answer;
    }
}