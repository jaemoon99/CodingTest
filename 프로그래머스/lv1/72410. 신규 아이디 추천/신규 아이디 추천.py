def solution(new_id):
    answer = ''
    remove_string = ['~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '=', '+', '[', '{', ']', '}', ':', '?', ',', '<', '>', '/']
    # step 1
    step1 = new_id.lower()
    # step 2
    step2 = list(step1)
    for x in range(0, len(step2)):
        if step2[x] in remove_string:
            step2[x] = ""
    # step 3
    step3 = list("".join(step2))
    for x in range(0, len(step3)):
        if x == len(step3) - 1:
            break
        elif step3[x] == '.' and step3[x + 1] == '.':
            step3[x] = ""
    # step 4
    step4 = "".join(step3).strip('.')
    # step 5
    step5 = list("".join(step4).strip('.'))
    if step5 == []:
        step5.append('a')
    for x in range(0, len(step5)):
        if step5[x] == ' ':
            step5[x] = 'a'
    # step 6
    if len(step5) >= 16:
        step6 = list("".join(step5[:15]).strip('.'))
    else:
        step6 = list("".join(step5).strip('.'))
    # step 7
    step7 = "".join(step6)
    while 1:
        if len(step7) >= 3:
            return step7
        else:
            step7 += step7[-1]