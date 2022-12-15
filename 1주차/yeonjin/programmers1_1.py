def solution(id_list, report, k):
    answer = []
    report = set(report)
    re_cnt = {id : 0 for id in id_list}
    re_set = {id : [] for id in id_list}
           
#     susp_list = [re.split(' ')[1] for re in report]
#     fin_list = [re for re in report if susp_list.count(re.split(' ')[1]) >= k]
    
    for re in report : 
        x, y = re.split(' ')
        re_cnt[y] += 1
        re_set[x].append(y)

    for i in id_list:
        num = 0
        for j in re_set[i]:
            if re_cnt[j] >= k:
                num += 1
        answer.append(num)
    
    return answer