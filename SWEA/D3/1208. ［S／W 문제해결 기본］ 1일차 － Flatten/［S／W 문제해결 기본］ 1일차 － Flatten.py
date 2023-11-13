for test_case in range(1, 11):
    count = int(input())
    box_h = sorted(list(map(int, input().split())))
    
    for x in range(count):
        box_h[0] += 1
        box_h[-1] -= 1
        box_h = sorted(box_h)
    
    print(f'#{test_case} {box_h[-1] - box_h[0]}')