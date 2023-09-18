def solution(board, k):
    answer = 0
    for x in range(len(board)):
        for y in range(len(board[x])):
            if k >= x+y:
                answer += board[x][y]
    return answer