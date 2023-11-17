T = int(input())
c_list = []
for test_case in range(1, T + 1):
    A, B, C, D = map(int, input().split())
    X = [x for x in range(A, B + 1)]
    Y = [y for y in range(C, D + 1)]
    count = 0

    for x in X:
        if x in Y:
            count += 1

    if count > 0:
        count -= 1
    
    c_list.append(count)
    
for i in range(T):
    print(f'#{i + 1} {c_list[i]}')