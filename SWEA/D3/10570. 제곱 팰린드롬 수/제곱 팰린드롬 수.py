T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a, b = map(int, input().split())
    count = 0
    for x in range(a, b + 1):
        if str(x) == str(x)[::-1] and str(x ** (1/2)).replace(".0", "") == str(x ** (1/2)).replace(".0", "")[::-1]:
            count += 1
    print(f'#{test_case} {count}')