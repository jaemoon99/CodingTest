from collections import deque


for test_case in range(10):
    tc_num = int(input())
    password = deque(map(int, input().split()))
    
    count = 1
    while 1:
        if count == 6:
            count = 1
            
        password.append(password.popleft() - count)
        count += 1
        
        if 0 >= password[-1]:
            password[-1] = 0
            break
        
            
    print(f"#{tc_num}{''.join([' ' + str(x) for x in password])}")
    