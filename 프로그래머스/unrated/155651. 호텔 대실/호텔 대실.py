def solution(book_time):
    queue = []
    
    # book_time에 있는 모든 ":" 제거
    for x in range(len(book_time)):
        for y in range(len(book_time[x])):
            book_time[x][y] = int(book_time[x][y].replace(":", ""))
    
    # 오름차순으로 정렬
    book_time = sorted(book_time)
    
    # book_time 길이만큼 순회
    for x in range(len(book_time)):
        
        # 입실을 한지 안한지 확인하는 변수
        check = 0
        
        # 첫 번째 입실시간인 경우
        if len(queue) == 0:
            queue.append(book_time[x])
            
        # 첫 번째 입실시간이 아닌 경우
        else:
            
            # 입실한 방만큼 순회
            for y in range(len(queue)):
                
                # fir = 이전 팀 퇴실시간
                # sec = 현재 팀 입실시간
                fir = queue[y][-1] + 10
                sec = book_time[x][0]
                
                # 시간 전처리 ex). 1060 -> 1100
                if int(str(fir)[-2]) >= 6:
                    fir += 40
                    
                # 입실이 가능한 경우
                if fir <= sec:
                    
                    # 입실 체크
                    check += 1
                    queue[y] = queue[y] + book_time[x]
                    break
                    
            # 기존 방에 입실을 하지 못한 경우
            if check == 0:
                
                # 새로운 방 배정
                queue.append(book_time[x])
                
    # 방 개수 리턴
    return len(queue)