t = int(input())
for tc in range(1, t + 1) :
    n = int(input())
    data = list(map(int, input().split()))
    max_value = data[0]

    for i in range(n-1) :
        if data[i] >= 0 and (data[i] + data[i+1]) >= 0 :
            data[i+1] += data[i]
        if data[i+1] > max_value :
            max_value = data[i+1]

    print('#%d %d' % (tc, max_value))