from datetime import datetime

T = int(input())
for test_case in range(1, T + 1):
    day, hour, minute = map(int, input().split())
    d1 = datetime(2011, 11, 11, 11, 11)
    d2 = datetime(2011, 11, day, hour, minute)
    
    if int((d2 - d1).total_seconds() // 60) >= 0:
    	print(f'#{test_case} {int((d2 - d1).total_seconds() // 60)}')
    else:
        print(f'#{test_case} -1')