def solution(numbers):
    answer = []
    for x in range(0, len(numbers)): # 각각 인덱스끼리 만날 수 있게 중첩 for문 사용
        for y in range(0, len(numbers)):
            if x != y: # 다른 인덱스일 경우
                answer.append(numbers[x] + numbers[y]) # 추가
    return  sorted(list(set(answer))) # 같은 숫자가 있을 수 있기 때문에 중복제거 후 정렬