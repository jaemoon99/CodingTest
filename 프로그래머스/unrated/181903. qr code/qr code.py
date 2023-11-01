def solution(q, r, code):  
    return ''.join([content for index, content in enumerate(code) if index % q == r])
