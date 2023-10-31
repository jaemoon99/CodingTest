def solution(arr1, arr2):
    for x in range(len(arr1)):
        for y in range(len(arr1[x])):
            arr1[x][y] = arr1[x][y] + arr2[x][y]
    return arr1