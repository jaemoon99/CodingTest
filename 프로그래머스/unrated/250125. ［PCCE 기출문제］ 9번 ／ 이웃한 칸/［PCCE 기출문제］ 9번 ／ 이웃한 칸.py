def solution(board, h, w):
    answer = 0
    x_y = ((1, 0), (0, 1), (-1, 0), (0, -1))
    color = board[h][w]
    
    for i, j in x_y:
        if len(board) > h+i >= 0 and len(board) > w+j >= 0 and color == board[h+i][w+j]:
            answer += 1
            
    return answer