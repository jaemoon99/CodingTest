def solution(k, score):
    answer = []
    sub = []
    
    for x in score:
        sub.append(x)
        sub = sorted(sub)
        
        if len(sub) >= k:
            answer.append(sub[-k])
        else:
            answer.append(sub[0])
        
        
    return answer