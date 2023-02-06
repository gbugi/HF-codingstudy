def solution(k, tangerine):
    tmp_list = []
    tangerine.sort()
    cnt = 1
    for i in range(len(tangerine)):
        if i == len(tangerine)-1 :
            tmp_list.append([tangerine[i], cnt])
        elif tangerine[i] == tangerine[i + 1]:
            cnt += 1
        else :
            tmp_list.append([tangerine[i], cnt])
            cnt = 1
    tmp_list.sort(key = lambda x:-x[1])  
    
    total = 0
    result = 0

    for info in tmp_list:
        total += info[1]
        result += 1
        if k <= total :
            break       


    answer = result
    return answer

