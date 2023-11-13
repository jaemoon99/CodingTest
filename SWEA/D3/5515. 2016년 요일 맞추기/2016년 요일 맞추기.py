from datetime import datetime
 

T = int(input())
for test_case in range(1, T + 1):
    m, d = map(int, input().split())
    date = f'2016-{m}-{d}'
    print(f"#{test_case} {datetime.strptime(date, '%Y-%m-%d').weekday()}")
