num_dic = {
        '0001101': '0',
        '0011001': '1',
        '0010011': '2',
        '0111101': '3',
        '0100011': '4',
        '0110001': '5',
        '0101111': '6',
        '0111011': '7',
        '0110111': '8',
        '0001011': '9'
}
T = int(input())
for test_case in range(1, T + 1):
    row, columns = map(int, input().split())
    ciphertext = [input() for _ in range(row)]

    num_list = []
    for x in ciphertext:
        if len(set(x)) == 2:
            password = "0" * (56 - len(x.strip("0"))) + x.strip("0")
            for y in range(0, len(password), 7):
                num_list.append(num_dic[password[y:y + 7]])

    num_list = num_list[:8]
    
    if (sum([int(x) for x in num_list[::2]]) * 3 + sum([int(y) for y in num_list[1::2]])) % 10 == 0:
        print(f'#{test_case} {sum([int(x) for x in num_list])}')
    else:
        print(f'#{test_case} 0')
