def solution(babbling):
    answer = 0
    note = ["aya", "ye", "woo", "ma"]
    for i, x in enumerate(babbling):
        for y in note:
            if y in x:
                babbling[i] = babbling[i].replace(y, ".")
    for i, x in enumerate(babbling):
        babbling[i] = babbling[i].replace(".", "")
    return babbling.count("")