def solution(n, words):
    p = [words[0][0]]
    print(p)
    for i, w in enumerate(words):
        if w not in p and p[-1][-1] == w[0]:
            p.append(w)
        else:
            return [i % n + 1, (i//n)+1]
    return [0, 0]