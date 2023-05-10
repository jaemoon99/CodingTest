def solution(my_string):
    answer = [] 
    for y in [x for x in my_string]:
        if y not in answer:
            answer.append(y)
    return ''.join(x for x in answer)