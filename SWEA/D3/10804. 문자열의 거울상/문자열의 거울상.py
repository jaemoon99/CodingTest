bdpq_dict = {
    "b": "d", "d": "b", "p": "q", "q": "p"
}
T = int(input())
for test_case in range(1, T + 1):
    text = input()
    print(f'#{test_case} {"".join([bdpq_dict[x] for x in text[::-1]])}')
    