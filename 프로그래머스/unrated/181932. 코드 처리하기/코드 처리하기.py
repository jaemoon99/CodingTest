def solution(code):
    answer = ''
    mode = 0
    
    for x in range(len(code)):
        if mode == 0:
            if code[x] == "1":
                mode = 1 - mode
            else:
                if x % 2 == 0:
                    answer += code[x]
        
        elif mode == 1:
            if code[x] == "1":
                mode = 1- mode
            else:
                if x % 2 == 1:
                    answer += code[x]
            
    if answer == "":
        return "EMPTY"
    else:
        return answer