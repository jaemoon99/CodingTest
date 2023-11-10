T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    matrix = []
    for _ in range(N):
        input_row = list(map(str, input().split()))
        matrix.append(input_row)
    
    matrix_90 = []
    matrix_180 = []
    matrix_270 = []
    
    for x in range(N):
        append_data = ''
        for y in range(N):
            append_data += matrix[y][x]
        matrix_90.append(append_data[::-1])
        matrix_270.append(append_data)
    
    for x in matrix[::-1]:
        matrix_180.append(''.join(x[::-1]))
        
    matrix_270 = matrix_270[::-1]
    
    print(f'#{test_case}')
    for x in range(N):
        print(f'{matrix_90[x]} {matrix_180[x]} {matrix_270[x]}')
            
            