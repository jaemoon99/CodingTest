def solution(numLog):
    numlog_dict = dict(zip(['1', '10', '-1', '-10'], ['w', 'd', 's', 'a']))
    return ''.join([numlog_dict[str(numLog[x + 1] - numLog[x])] for x in range(len(numLog) - 1) ])