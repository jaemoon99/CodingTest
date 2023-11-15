T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    S = input()
    
    if S.replace(S[:len(S)//2], "") == "":
        print(f'#{test_case} Yes')
    else:
        print(f'#{test_case} No')