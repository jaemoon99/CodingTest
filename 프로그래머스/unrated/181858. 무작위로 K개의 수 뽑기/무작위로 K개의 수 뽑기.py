def solution(arr, k):
    random_list = []
    for x in arr:
        if x not in random_list:
            random_list.append(x)
    if len(random_list) > k:
        return random_list[:k]
    else:
        return random_list + ([-1] * (k - len(random_list)))