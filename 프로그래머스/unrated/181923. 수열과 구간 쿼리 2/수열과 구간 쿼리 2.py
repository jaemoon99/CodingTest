def solution(arr, queries):
    answer = []
    for query in queries:
        i_list = [arr[x] for x in range(query[0], query[1] + 1)]
        i_list = [x for x in i_list if x > query[-1]]
        if i_list == []:
            answer.append(-1)
        else:
            answer.append(min(i_list))
    return answer