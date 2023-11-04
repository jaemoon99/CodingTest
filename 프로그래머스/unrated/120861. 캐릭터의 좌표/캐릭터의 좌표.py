def solution(keyinput, board):
    answer = [0, 0]
    board = [(board[0] - 1) // 2, (board[1] - 1) // 2]
    for x in keyinput:
        if x == "left":
            if abs(answer[0] - 1) <= abs(board[0]):
                answer[0] -= 1
        elif x == "right":
            if abs(answer[0] + 1) <= abs(board[0]):
                answer[0] += 1
        elif x == "up":
            if abs(answer[1] + 1) <= abs(board[1]):
                answer[1] += 1
        elif x == "down":
            if abs(answer[1] - 1) <= abs(board[1]):
                answer[1] -= 1
    return answer