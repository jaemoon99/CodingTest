T = int(input())
for test_case in range(1, T + 1):
    input_str = input()
    A, B = map(int, input_str.split())
    print(f'#{test_case} {(A + B) % 24}')