def solution(s):
    answer = []
    num = 0
    count = 0
    
    for i in range(0, 150000):
        
        if s == '1' :
            break
            
        count += s.count('0')
        s = bin(len(s) - s.count('0'))[2:]
        num += 1
        
    return [num, count]