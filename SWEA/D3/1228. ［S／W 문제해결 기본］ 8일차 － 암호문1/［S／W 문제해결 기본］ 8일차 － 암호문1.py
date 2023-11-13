for test_case in range(1, 11):
    plain_len = int(input())
    plain_text = list(input().split())
    count = int(input())
    command = list(input().split())

    for x in range(len(command)):
        if command[x] == "I":
            start = int(command[x + 1])
            c = int(command[x + 2])
            plain_text = plain_text[:start] + command[x + 3: x + 3 + c] + plain_text[start:]

    print(f'#{test_case}{"".join([" " + x for x in plain_text[:10]])}')