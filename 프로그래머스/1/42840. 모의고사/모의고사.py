def solution(answers):
    answer = []
    
    a = [1, 2, 3, 4, 5]
    b = [2, 1, 2, 3, 2, 4, 2, 5]
    c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    point = [0, 0, 0]
    
    
    for i in range(len(answers)):
        if a[i%5] == answers[i]:
            point[0] += 1
        if b[i%8] == answers[i]:
            point[1] += 1
        if c[i%10] == answers[i]:
            point[2] += 1

    
    maxNum = max(point)
    
    for i in range(len(point)):
        if(maxNum == point[i]):
            answer.append(i+1)
        
    
    return answer