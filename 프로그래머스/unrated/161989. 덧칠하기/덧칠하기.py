def solution(n, m, section): # n은 총 개수, m은 롤러 길이, section은 칠해야 할 번지 수
    wall_range = section[0] + m - 1
    count = 1
    for x in section:
        if x > wall_range:
            wall_range = (x+m-1)
            count += 1
    return count