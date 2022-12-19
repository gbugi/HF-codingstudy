def solution(n, arr1, arr2):
    answer = []
    
    for i in range(0, n) :
        a = bin(arr1[i])[2:].zfill(n)
        b = bin(arr2[i])[2:].zfill(n)
        
        result = ''
        for j in range(0,n):
            print(a[j])
            if int(a[j]) + int(b[j]) > 0:
                result += '#'
            else:
                result += ' '
        answer.append(result)
    return answer