def solution(wallpaper):
    answer = []
    # x좌표와 y좌표를 담을 집합을 선언(집합을 선언하는 이유 중복되는 좌표를 제거하기 위해)
    x_set, y_set = set(), set()
    
    # y축 순회
    for x in range(len(wallpaper)):
        
        # x축 순회
        for y in range(len(wallpaper[x])):
            
            # 현재 좌표의 값이 '#'이면 집합에 각 좌표 삽입
            if '#' in wallpaper[x][y]:
                x_set.add(x)
                y_set.add(y)
    # 맨 앞쪽과 맨 뒤쪽 좌표는 최솟값과 최댓값 + 1이기 때문에 min, max를 이용하여 반환
    return [min(x_set), min(y_set), max(x_set) + 1, max(y_set) + 1]