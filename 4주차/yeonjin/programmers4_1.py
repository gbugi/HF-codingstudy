def solution(n):
    answer = 0
    if n == 1: 
        answer = 1

    for k in range(1, n):
        num = n + (k*k - k) / 2 
        a = (n/k) + (1-k)/2
        if a > 0 :
            if num > 0 and num % k == 0:
                answer += 1
    return answer

