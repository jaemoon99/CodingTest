def solution(arr):
    res_list = [x for x in range(len(arr)) if arr[x] == 2]
    if res_list == []:
        return [-1]
    return arr[min(res_list):max(res_list) + 1]