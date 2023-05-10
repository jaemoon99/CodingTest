def solution(rsp):
    dictionary = {
        '2' : '0',
        '0' : '5',
        '5' : '2'
    }
    return ''.join([dictionary[x] for x in rsp])