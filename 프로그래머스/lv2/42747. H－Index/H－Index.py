# H-Index = 전체 논문중 많이 인용된 순으로 정렬한 후, 피인용수가 논문수와 같아지거나 피인용수가 논문수보다 작아지기 시작하는 숫자
def solution(citations):
    
    # 전체 논문을 내림차순으로 정렬
    citations.sort(reverse=True)
    
    # 전체 논문 수만큼 순회
    for x in range(len(citations)):
        
        # 피인용수가 논문수 보다 작거나 같을 경우
        if x >= citations[x]:
            return x
        
    # 피인용수가 다 같을 경우 최대값은 논문의 개수
    return(len(citations))