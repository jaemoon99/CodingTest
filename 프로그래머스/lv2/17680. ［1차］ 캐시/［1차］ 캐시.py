def solution(cacheSize, cities):
    answer = 0
    queue = []
    
    # 캐시 크기가 0일 경우
    if cacheSize == 0:
        return 5*len(cities)
    
    # 도시 개수만큼 순회
    for x in range(len(cities)):
        
        # 큐의 길이가 캐시크기보다 작고 현재 도시가 큐 안에 있는 경우
        if cacheSize > len(queue) and cities[x].lower() in queue:
            answer += 1
            queue.remove(cities[x].lower())
            queue.append(cities[x].lower())
            
        # 큐의 길이가 캐시크기보다 작고 현재 도시가 큐 안에 없는 경우
        elif cacheSize > len(queue):
            answer += 5
            queue.append(cities[x].lower())
            
        # 큐가 꽉 차고 현재 도시가 큐 안에 있는 경우
        elif cities[x].lower() in queue:
            answer += 1
            queue.remove(cities[x].lower())
            queue.append(cities[x].lower())
            
        # 큐가 꽉 차고 현재 도시가 큐 안에 없는 경우
        else:
            answer += 5
            queue.remove(queue[0])
            queue.append(cities[x].lower())
    return answer