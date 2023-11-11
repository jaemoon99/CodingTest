T = int(input())
answer = []
for test_case in range(1, T + 1):
    count = 0
    check_list = list(str(test_case))
    for x in check_list:
        if int(x) % 3 == 0 and int(x) != 0:
            count += 1
    if count > 0:
        answer.append("-" * count)
    else:
        answer.append(test_case)
print(''.join([str(x) + " " for x in answer]).rstrip())