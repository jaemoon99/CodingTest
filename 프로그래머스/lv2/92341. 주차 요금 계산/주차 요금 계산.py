import math
def solution(fees, records):
    answer = []
    
    # 빈 딕셔너리 생성
    dic = dict()
    
    # fees 배열을 각 변수에 저장
    base_time, base_fee, unit_time, unit_fee = fees
    
    # records 순회
    for record in records:
        
        # 공백을 기준으로 분리
        time, number, info = record.split(' ')
        
        # 시간과 분으로 분리
        h, m = time.split(':')
        
        # 차량번호가 딕셔너리에 있는 경우
        if number in dic:
            
            # 시간을 분으로 환산하여 추가
            dic[number].append([int(h) * 60 + int(m)])
            
        # 딕셔너리에 없는 경우
        else:
            
            # 시간을 분으로 환산하여 새로 추가
            dic[number] = [[int(h) * 60 + int(m)]]
    
    # 차량 번호를 기준으로 정렬
    sort_dic = dict(sorted(dic.items()))
    
    # 각 값만 리스트로 추출
    vlists = list(sort_dic.values())
    
    # 차량 순회
    for vlist in vlists:
        
        # 방문시간 총합
        sum = 0
        
        # 방문시간의 개수가 짝수인 경우
        if len(vlist) % 2 == 0:
            
            # 0부터 2칸씩 순회(in)
            for x in range(0, len(vlist), 2):
                
                # 홀수 인덱스에서 짝수 인덱스 뺄셈(out - in) 
                sum += vlist[x + 1][0] - vlist[x][0]
                
            # 총 방문시간이 기본시간 미만인 경우    
            if sum - base_time < 0:
                
                # 기본요금
                answer.append(base_fee)
                
            # 총 방문시간이 기본시간을 넘을 경우
            else:
                
                # 공식 계산
                answer.append(base_fee + math.ceil((sum - base_time) / unit_time) * unit_fee)
                
        # 방문시간 개수가 홀수인 경우
        else:
            # 마지막 전까지 2칸씩 순회(맨 마지막은 out을 하지 않는 경우기 때문)
            for x in range(0, len(vlist) - 1, 2):
                
                # 홀수 인덱스에서 짝수 인덱스 뺄셈(out - in)
                sum += vlist[x + 1][0] - vlist[x][0]
                
            # 맨 마지막(in만 한 경우) 계산
            sum += (23 * 60 + 59) - (vlist[-1][0])
            
            # 총 방문시간이 기본시간 미만인 경우
            if sum - base_time < 0:
                
                # 기본요금
                answer.append(base_fee)
            
            # 총 방문시간이 기본시간 이상인 경우
            else:
                
                #공식 계산
                answer.append(base_fee + math.ceil((sum - base_time) / unit_time) * unit_fee)

    return answer