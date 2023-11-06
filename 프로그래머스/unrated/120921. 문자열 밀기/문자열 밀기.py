def solution(A, B):
    count = 0
    if A == B:
        return 0
    else:
        while 1:
            A = A[-1] + A[:-1]
            count += 1
            if A == B:
                return count
            elif count == len(A):
                return -1