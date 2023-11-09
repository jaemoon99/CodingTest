T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    input_data = input()
    if input_data == input_data[::-1]:
        print(f'#{test_case} 1')
    else:
        print(f'#{test_case} 0')