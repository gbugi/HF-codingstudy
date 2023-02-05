def solution(n):
    answer = n
    cnt = bin(n).count('1')              
    while True:                             
        answer += 1
        answercnt = bin(answer).count('1')
        if answercnt == cnt:
            break
    return answer