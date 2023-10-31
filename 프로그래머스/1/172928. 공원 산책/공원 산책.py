def solution(park, routes):
    start_place = []

    for x in range(len(park)):
        park[x] = list(park[x])

    for x in range(len(park)):
        for y in range(len(park[x])):
            if park[x][y] == "S":
                start_place.append(x)
                start_place.append(y)

    for x in routes:
        count = 0
        x_point = start_place[0]
        y_point = start_place[1]

        if x[0] == "E":
            for y in range(1, int(x[-1]) + 1):
                if y_point == len(park[0]) - 1:
                    count += 1
                else:
                    if park[x_point][y_point + 1] == "X":
                        count += 1
                    else:
                        y_point += 1
            if count == 0:
                start_place[1] = y_point

        elif x[0] == "S":
            for y in range(1, int(x[-1]) + 1):
                if x_point == len(park) - 1:
                    count += 1
                else:
                    if park[x_point + 1][y_point] == "X":
                        count += 1
                    else:
                        x_point += 1
            if count == 0:
                start_place[0] = x_point

        elif x[0] == "W":
            for y in range(1, int(x[-1]) + 1):
                if y_point == 0:
                    count += 1
                else:
                    if park[x_point][y_point - 1] == "X":
                        count += 1
                    else:
                        y_point -= 1
            if count == 0:
                start_place[1] = y_point

        elif x[0] == "N":
            for y in range(1, int(x[-1]) + 1):
                if x_point == 0:
                    count += 1
                else:
                    if park[x_point - 1][y_point] == "X":
                        count += 1
                    else:
                        x_point -= 1
            if count == 0:
                start_place[0] = x_point

    return start_place