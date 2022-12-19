def solution(food):
    answer = ''
    for i, item in enumerate(food):
        num = (food[i]//2)
    arr = ''.join([str(num) * (item//2) for num, item in enumerate(food)])
    answer = arr +'0'+ arr[::-1]
    return answer