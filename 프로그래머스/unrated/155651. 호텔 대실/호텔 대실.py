# def solution(book_time):
#     for x in range(len(book_time)):
#         for y in range(len(book_time[x])):
#             book_time[x][y] = int(book_time[x][y].replace(":", ""))
#     book_time = sorted(book_time)
#     print(book_time)
#     queue = []
#     for x in range(len(book_time)):
#         count = 0
#         if len(queue) == 0:
#             queue.append(book_time[x])
#         else:
#             for y in range(len(queue)):
#                 a = queue[y][-1] + 10
#                 b = book_time[x][0]
#                 if queue[y][-1] + 10 <= book_time[x][0] or queue[y][-1] + 50 == book_time[x][0]:
#                     queue[y] = queue[y] + book_time[x]
#                     count += 1
#                     break
#             if count == 0:
#                 queue.append(book_time[x])
#     return len(queue)

def solution(book_time):
    for x in range(len(book_time)):
        for y in range(len(book_time[x])):
            book_time[x][y] = int(book_time[x][y].replace(":", ""))
    book_time = sorted(book_time)
    print(book_time)
    queue = []
    for x in range(len(book_time)):
        count = 0
        if len(queue) == 0:
            queue.append(book_time[x])
        else:
            for y in range(len(queue)):
                fir = queue[y][-1] + 10
                sec = book_time[x][0]
                if int(str(fir)[-2]) >= 6:
                    fir += 40
                if fir <= sec:
                    queue[y] = queue[y] + book_time[x]
                    count += 1
                    break
            if count == 0:
                queue.append(book_time[x])
    return len(queue)