for tc in range(int(input())):
    p, q = map(float, input().split())
    s1 = (1 - p) * q
    s2 = p * (1 - q) * q
    print(f'#{tc + 1}', "YES" if s2 > s1 else "NO")