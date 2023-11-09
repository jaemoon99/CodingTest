T = int(input())
'''
총 사용량 W리터
A사 리터당 P원
B사 R리터이하 Q원, 이상 리터당 S 원
'''
for test_case in range(1, T + 1):
    input_data = input()
    P, Q, R, S, W = map(int, input_data.split())
    a_company = P * W
    b_company = 0
    if R >= W:
        b_company = Q
    else:
        b_company = (W - R) * S + Q
    print(f'#{test_case} {min(a_company, b_company)}')
