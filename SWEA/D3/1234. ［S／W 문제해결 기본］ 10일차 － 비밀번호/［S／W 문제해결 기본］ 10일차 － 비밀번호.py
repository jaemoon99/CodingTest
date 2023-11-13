for test_case in range(1, 11):
    N, password = input().split()
    password = list(password)
    check = []

    for x in range(len(password)):

        if x == 0 or len(check) == 0:
            check.append(password[x])
        else:
            if check[-1] == password[x]:
                check.pop()
            else:
                check.append(password[x])
    password = check

    print(f'#{test_case} {"".join(password)}')