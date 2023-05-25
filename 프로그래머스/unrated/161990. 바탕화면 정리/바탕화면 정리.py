def solution(wallpaper):
    answer = []
    x_set, y_set = set(), set()
    for x in range(len(wallpaper)):
        for y in range(len(wallpaper[x])):
            if '#' in wallpaper[x][y]:
                x_set.add(x)
                y_set.add(y)
    return [min(x_set), min(y_set), max(x_set) + 1, max(y_set) + 1]