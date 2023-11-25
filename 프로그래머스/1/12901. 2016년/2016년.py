from datetime import datetime

day_dic = {"0": "MON", "1": "TUE", "2": "WED", "3": "THU", "4": "FRI", "5": "SAT", "6": "SUN"}
def solution(a, b):
    day = datetime(2016, int(a), int(b))
    return day_dic[str(day.weekday())]