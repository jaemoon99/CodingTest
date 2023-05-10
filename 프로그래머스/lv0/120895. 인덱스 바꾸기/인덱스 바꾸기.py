def solution(my_string, num1, num2):
    answer = ''
    m_string = list(my_string)
    m_string[num1], m_string[num2] = m_string[num2], m_string[num1]
    for x in (m_string):
        answer += x
    return answer