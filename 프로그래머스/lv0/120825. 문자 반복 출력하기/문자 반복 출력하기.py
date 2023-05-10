def solution(my_string, n):

    list = []
    answer = ""

    for x in my_string:
        for y in range(n):
            list.append(x)
    
    for i in list:
        answer += i
    return answer