T = 10
for test_case in range(1, T + 1):
    case_count = int(input())
    ciphertexts = list(input().split())
    command_count = int(input())
    command_list = list(input().split())

    for x in range(len(command_list)):

        if command_list[x] == "I":
            start = int(command_list[x + 1])
            count = int(command_list[x + 2])
            insert_list = []

            for y in range(1, count + 1):
                insert_list.append(command_list[x + 2 + y])

            ciphertexts = ciphertexts[:start + 1] + insert_list + ciphertexts[start + 1:]

        elif command_list[x] == "D":
            start = int(command_list[x + 1])
            count = int(command_list[x + 2])

            ciphertexts = ciphertexts[:start + 1] + ciphertexts[:start + 2 + count]

        elif command_list[x] == "A":
            count = int(command_list[x + 1])

            append_list = []
            for y in range(1, count + 1):
                append_list.append(command_list[x + 1 + y])

            ciphertexts += append_list

    ciphertexts = ciphertexts[1:11]

    print(f'#{test_case}{"".join([" " + z for z in ciphertexts])}')