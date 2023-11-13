T = int(input())
for test_case in range(1, T + 1):
    S = input()
    set_s = list(set(S))
    
    if len(set_s) == 2:
        if S.count(set_s[0]) == S.count(set_s[1]):
            print(f'#{test_case} Yes')
        else:
            print(f'#{test_case} No')
    else:
        print(f'#{test_case} No')