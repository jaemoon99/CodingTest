T = int(input())
for test_case in range(1, T + 1):
    word = input()
    set_word = set(word)
    
    for x in set_word:
        if word.count(x) % 2 == 0:
            word = word.replace(x, "")
        else:
            word = word.replace(x, "") + x
    
    if word == "":
        word = "Good"
    else:
        word = "".join(sorted(word))
        
    print(f'#{test_case} {word}')
    
    