def solution(players, callings):
    p_dict = dict(zip(players, [x for x in range(len(players))]))
    for x in callings:
        i = p_dict[x]
        p_dict[x] = i-1
        p_dict[players[i-1]] = i
        players[i-1:i+1] = players[i-1:i+1][::-1]
    return players