import java.util.*;

class Solution {
    
    static int idx;
    
    static class Node implements Comparable<Node> {
        int id,x,y;
        Node leftNode, rightNode;

        public Node(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    
        @Override
        public int compareTo(Node o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }
            return Integer.compare(o.y, this.y);
        }
        
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        
        List<Node> nodes = new ArrayList<>();
        
        for(int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        Collections.sort(nodes);
        
        Node root = nodes.get(0);
        
        for(int i = 1; i < nodes.size(); i++) {
            insertNode(root, nodes.get(i));
        }
        
        answer = new int[2][nodes.size()];
        
        
        idx = 0;
        preOrder(root, answer[0]);
        
        idx = 0;
        postOrder(root, answer[1]);

        return answer;
    }
    
    public void insertNode(Node parent, Node child) {
        if(child.x < parent.x) {
            if(parent.leftNode == null) parent.leftNode = child;
            else insertNode(parent.leftNode, child);
        } else {
            if(parent.rightNode == null) parent.rightNode = child;
            else insertNode(parent.rightNode, child);
        } 
    }
    
    public void preOrder(Node n, int[] arr){
        if(n != null){
            arr[idx++] = n.id;
            preOrder(n.leftNode, arr);
            preOrder(n.rightNode, arr);   
        }
    }
    
    public void postOrder(Node n, int[] arr){
        if(n != null) {
            postOrder(n.leftNode, arr);
            postOrder(n.rightNode, arr);
            arr[idx++] = n.id;
        }
    }
}