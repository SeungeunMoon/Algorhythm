from collections import deque

def solution(n, computers):
    answer = 0
    
    visited = [False for _ in range(n+1)]
    
    for i in range(1, n+1):
        
        if visited[i]:
            continue
        
        answer += bfs(i,n, computers,visited)
    
    return answer

def bfs(x, n, computers, visited):

    q = deque([x])
    visited[x] = True
    
    while q:
        curr = q.popleft()
        
        for i in range(1,n+1):
            if (not visited[i]) and computers[curr-1][i-1]:
                visited[i] = True
                q.append(i)
    
    print(visited)
    
    return 1
    
    