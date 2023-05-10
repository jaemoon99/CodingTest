def solution(my_string):
    answer = ''
    list = ['a', 'e', 'i', 'o', 'u']
    for x in my_string:
        if x not in list:
            answer += x
    return answer
