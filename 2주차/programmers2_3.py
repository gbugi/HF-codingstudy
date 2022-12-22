from collections import deque

def solution(priorities, location):
    answer = 0
    max_pri = max(priorities)
    prior_dq = deque()
    num_dq = deque()
    
    for i, p in enumerate(priorities):
        prior_dq.append(p)
        num_dq.append(i)
        
        
    while True:
        max_pri = max(prior_dq)
        p = prior_dq.popleft()
        n = num_dq.popleft()
        if p == max_pri:
            answer += 1
            if n == location :
                break
        else:
            prior_dq.append(p)
            num_dq.append(n) 

    return answer