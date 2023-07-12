# def solution(priorities, location):
#     # dic = dict(zip([str(x) for x in range(len(priorities))], priorities))
#     # sort_dic = dict(sorted(dic.items(), key=lambda x: x[1], reverse = True))
#     # index = next((index for index, key in enumerate(sort_dic) if key == str(location)), None)

from collections import deque

def solution(priorities, location):
    q = deque(priorities)
    answer = 0
    while q:
        m = max(q)
        l = q.popleft()
        location -= 1 
        if l != m:
            q.append(l)
            if location < 0:
                location = len(q) -1
        else:
            answer += 1
            if location < 0:
                break
            
    return answer