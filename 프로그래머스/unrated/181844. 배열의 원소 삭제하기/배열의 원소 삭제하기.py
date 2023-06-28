def solution(arr, delete_list):
    for x in delete_list:
        if x in arr:
            arr.remove(x)
    return arr