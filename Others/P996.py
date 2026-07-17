#Hit the Lottery
N = int(input())

cnt = 0

# greedy
while(N != 0):

    if(N>=100):
        cnt += (N//100)
        N %= 100
    elif N >= 20:
        cnt += (N// 20)
        N %= 20
    elif N >= 10:
        cnt += (N //10)
        N %= 10
    elif N>= 5:
        cnt += (N //5)
        N %= 5
    else:
        cnt += N
        N = 0
        
print(cnt)


