T = int(input())
for test_case in range(1, T + 1):
    card_dict = {
        "S" : 13, "D": 13, "H": 13, "C": 13
	}
    
    card = input()
    card_list = [card[x:x + 3] for x in range(0, len(card), 3)]
    
    if len(card_list) == len(set(card_list)):
        for x in card_list:
            card_dict[x[0]] -= 1
        print(f'#{test_case}{"".join([" " + str(x) for x in list(card_dict.values())])}')
    else:
        print(f'#{test_case} ERROR')