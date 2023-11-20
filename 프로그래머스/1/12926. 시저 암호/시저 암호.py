def solution(s, n):
    answer = ''
    
    for x in s:
        if ord(x) <= 90 and ord(x) + n > 90:
            answer += chr(ord(x) + n - 26)
        elif ord(x) <= 122 and ord(x) + n > 122:
            answer += chr(ord(x) + n - 26)
        elif x == " ":
            answer += " "
        else:
            answer += chr(ord(x) + n)
        
    return answer