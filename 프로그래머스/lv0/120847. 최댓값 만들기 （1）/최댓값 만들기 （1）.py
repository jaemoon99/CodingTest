def solution(numbers):
    n_max = max(numbers)
    numbers.remove(n_max)
    return n_max*max(numbers)