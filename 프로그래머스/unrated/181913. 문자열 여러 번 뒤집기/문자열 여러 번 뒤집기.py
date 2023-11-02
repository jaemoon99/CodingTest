def solution(my_string, queries):
    answer = ''
    for x in queries:
        my_string = my_string[:x[0]] + my_string[x[0]:x[1] + 1][::-1] + my_string[x[1] + 1:]
    return my_string