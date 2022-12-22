def solution(survey, choices):
    answer = ''
    
    dict = {'RT':0,'CF':0,'JM':0,'AN':0}
    
    for i, s in enumerate(survey):
        if s in dict : 
            score = choices[i] * (-1) + 4
        else :
            score = choices[i] - 4
            s = s[::-1]
        dict[s] += score

    for k, v in dict.items():
        if v >= 0:
            result = k[0]
        else:
            result = k[1]
        answer += result
    return answer