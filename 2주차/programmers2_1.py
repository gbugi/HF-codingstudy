def solution(ingredient):
    answer = 0
    # ingredient = "".join(map(str, ingredient))
    igd = []
    
    for i in ingredient :
        igd.append(i)
        
        if len(igd) >= 4 :
            if igd[-1] == 1 and igd[-2] == 3 and igd[-3] == 2 and igd[-4] == 1:
                igd.pop()
                igd.pop()
                igd.pop()
                igd.pop()
                answer += 1
    return answer