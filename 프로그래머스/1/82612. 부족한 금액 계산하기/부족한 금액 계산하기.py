def solution(price, money, count):
    whole_price = sum([price * x for x in range(1, count + 1)])
    if money - whole_price >= 0:
        return 0
    return abs(money - whole_price)