n = 10 ** 6 + 1
data = [1] * n
data[0], data[1] = 0, 0

for i in range(2, n) :
    if data[i] == 1 :
        for j in range(i * 2, n, i) :
            data[j] = 0

for i in range(n) :
    if data[i] == 1 :
        print(i, end=' ')