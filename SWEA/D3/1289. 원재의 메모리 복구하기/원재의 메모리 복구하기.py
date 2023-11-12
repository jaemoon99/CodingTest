T = int(input())
for test_case in range(1, T + 1):
    memory = list(input())
    count = 0
    
    if memory[0] == "1":
        count += 1
        
    for x in range(len(memory) - 1):
        if memory[x] != memory[x + 1]:
            count += 1

    print(f'#{test_case} {count}')