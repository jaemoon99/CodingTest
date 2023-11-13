T = int(input())
for test_case in range(1, T + 1):
    S = input()
    print(f'#{test_case} {S.count("(|") + S.count("|)") + S.count("()")}')