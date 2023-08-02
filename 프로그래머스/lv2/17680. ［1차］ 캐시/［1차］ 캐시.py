def solution(cacheSize, cities):
    answer = 0
    queue = []
    if cacheSize == 0:
        return 5*len(cities)
    for x in range(len(cities)):
        if cacheSize > len(queue) and cities[x].lower() in queue:
            answer += 1
            queue.remove(cities[x].lower())
            queue.append(cities[x].lower())
        elif cacheSize > len(queue):
            answer += 5
            queue.append(cities[x].lower())
        elif cities[x].lower() in queue:
            answer += 1
            queue.remove(cities[x].lower())
            queue.append(cities[x].lower())
        else:
            answer += 5
            queue.remove(queue[0])
            queue.append(cities[x].lower())
    return answer