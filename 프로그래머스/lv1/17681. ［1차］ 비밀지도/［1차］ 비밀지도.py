def solution(n, arr1, arr2):
    answer = []
    for x in range(len(arr1)):
        value = bin(arr1[x] | arr2[x]).split("b")[1].replace("0", " ").replace("1", "#")
        answer.append(" "*(n - len(value)) + value)
    return answer