# def solution(citations):
#     citations.sort(reverse=True)
#     for x , citation in enumerate(citations):
#         if x >= citation:
#             return x
#     return len(citations)

def solution(citations):
    citations.sort(reverse=True)
    for x in range(len(citations)):
        if x >= citations[x]:
            return x
    return(len(citations))