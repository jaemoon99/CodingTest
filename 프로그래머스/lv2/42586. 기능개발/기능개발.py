import math
def solution(progresses, speeds):
    progresses = [100 - x for x in progresses]
    middle_list = [math.ceil(progresses[x] / speeds[x]) for x in range(len(progresses))]
    answer = []
    count = 1
    standard = middle_list[0]
    for x in range(1, len(middle_list)):
        if middle_list[x] == standard:
            count += 1
        elif middle_list[x] > standard:
            standard = middle_list[x]
            answer.append(count)
            count = 1
        else:
            count += 1
    answer.append(count)
    return answer