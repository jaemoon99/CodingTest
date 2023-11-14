for test_case in range(1, 11):
    len_plain = int(input())
    plain_text = list(input().split())
    command_count = int(input())
    commands = list(input().split())
    for x in range(len(commands)):
        if commands[x] == "I":
            start = int(commands[x + 1])
            count = int(commands[x + 2])
            plain_text = plain_text[:start] + commands[x + 3:x + 3 + count] + plain_text[start:]

        elif commands[x] == "D":
            start = int(commands[x + 1])
            count = int(commands[x + 2])
            plain_text = plain_text[:start] + plain_text[start + count:]

    print(f'#{test_case}{"".join([" " + x for x in plain_text[:10]])}')