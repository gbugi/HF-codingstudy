def solution(survey, choices):
    answer = ''
    
    dict = {'RT':0,'CF':0,'JM':0,'AN':0}
    
    for i, s in enumerate(survey):
        score = choices[i] - 4
        if s in dict : 
            dict[s] += score
        else :
            s = s[::-1]
            dict[s] -= score
            
    for k, v in dict.items():
        if v <= 0:
            result = k[0]
        else:
            result = k[1]
        answer += result
    return answer
