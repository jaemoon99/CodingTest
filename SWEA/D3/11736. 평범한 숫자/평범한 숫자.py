T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    num_list = list(map(int, input().split()))
    
    count = 0
    for x in range(2, N):
        if num_list[x - 1] != max(num_list[x - 2:x + 1]) and num_list[x - 1] != min(num_list[x - 2:x + 1]):
            count += 1
     
    print(f'#{test_case} {count}')