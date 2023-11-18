def solution(board):
    answer = set()
    bombs = set()
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j] == 1:
                bombs.add((i, j))
                bombs.add((i + 1, j + 1))
                bombs.add((i - 1, j - 1))
                bombs.add((i + 1, j - 1))
                bombs.add((i - 1, j + 1))
                bombs.add((i, j + 1))
                bombs.add((i, j - 1))
                bombs.add((i + 1, j))
                bombs.add((i - 1, j))
    
    for k, l in bombs:
        if len(board) > k > -1 and len(board) > l > -1:
            answer.add((k, l))
            
    return len(board) * len(board) - len(answer)