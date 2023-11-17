T = int(input())
for test_case in range(1, T + 1):
    N = input()
    sub_list = [int(x) for x in N]
    count = 0

    for x in range(2, max(sub_list) + 1):
        check = str(int(N) * x)

        if sorted(list(check)) == sorted(list(N)):

            for y in N:
                check = check.replace(y, "")

            if check == "":
                count += 1

    if count > 0:
        print(f'#{test_case} possible')
    else:
        print(f'#{test_case} impossible')
