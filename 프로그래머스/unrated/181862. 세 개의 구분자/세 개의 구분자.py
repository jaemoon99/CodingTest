def solution(myStr):
    myStr = myStr.replace("a", " ").replace("b", " ").replace("c", " ")
    answer = [x for x in myStr.split(" ") if x != ""]
    if answer == []:
        answer.append("EMPTY")
    return answer