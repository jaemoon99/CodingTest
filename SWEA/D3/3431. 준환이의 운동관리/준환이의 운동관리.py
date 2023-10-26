T = int(input())
# U >= X >= L
for test_case in range(1, T + 1):
    input_str = input()
    L, U, X = map(int, input_str.split())
    if X > U:
        print(f'#{test_case} -1')
    elif U >= X and X >= L:
        print(f'#{test_case} 0')
    else:
        print(f'#{test_case} {L - X}')