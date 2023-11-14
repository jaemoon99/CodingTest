atoz = 'abcdefghijklmnopqrstuvwxyz'
T = int(input())
for test_case in range(1, T + 1):
    sub_atoz = input()
    count = 0
    
    for x in range(0, len(sub_atoz)):
        if atoz[x] != sub_atoz[x]:
            print(f'#{test_case} {x}')
            count += 1
            break
            
    if count == 0:
        print(f'#{test_case} {len(sub_atoz)}')
