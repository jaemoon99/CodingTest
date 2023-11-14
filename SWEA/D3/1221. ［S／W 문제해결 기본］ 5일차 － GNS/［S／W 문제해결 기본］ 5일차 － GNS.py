s_to_i = {
    "ZRO": "0", "ONE": "1", "TWO": "2", "THR": "3", "FOR": "4", "FIV": "5", "SIX": "6", "SVN": "7", "EGT": "8", "NIN": "9"
}

i_to_s = {
    "0": "ZRO", "1": "ONE", "2": "TWO", "3": "THR", "4": "FOR", "5": "FIV", "6": "SIX", "7": "SVN", "8": "EGT", "9": "NIN"
}

T = int(input())
for test_case in range(1, T + 1):
    num, count = input().split()
    num_list = list(input().split())

    num_list = sorted([s_to_i[x] for x in num_list])

    print(f'{num}{"".join([" " + i_to_s[str(x)] for x in num_list])}')