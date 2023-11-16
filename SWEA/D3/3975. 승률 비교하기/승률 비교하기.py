lst = []
T = int(input())
for tc in range(T):
    lst.append(tuple(map(int, input().split())))

for tc in range(T):
    A, B, C, D = lst[tc]
    ALICE = A / B
    BOB = C / D

    if ALICE > BOB:
        print(f'#{tc + 1} ALICE')
    elif ALICE < BOB:
        print(f'#{tc + 1} BOB')
    else:
        print(f'#{tc + 1} DRAW')