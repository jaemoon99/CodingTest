def palindrome(string):
    length = 1
    for i in range(100):
        for j in range(length, 101):
            for k in range(101 - j):
                word = string[i][k: k + j]
                if word == word[::-1]:
                    temp = len(word)
                    if length < temp:
                        length = temp
    return length


for test_case in range(10):
    T = int(input())
    arr = [list(map(str, input())) for _ in range(100)]
    trans_arr = list(map(list, zip(*arr)))
    row = palindrome(arr)
    col = palindrome(trans_arr)
    print(f'#{T} {max(row, col)}')