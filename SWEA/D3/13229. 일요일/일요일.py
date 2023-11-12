day_dict = {
    "SUN": 0, "MON": 1, "TUE": 2, "WED": 3, "THU": 4, "FRI": 5, "SAT": 6 
}
T = int(input())
for test_case in range(1, T + 1):
    day = input()
    print(f'#{test_case} {7 - day_dict[day]}')