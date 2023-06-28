def solution(myString):
    return [0 if x == "" else len(x) for x in list(myString.split('x')) ]