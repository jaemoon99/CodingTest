def solution(todo_list, finished):
    ans_dict = dict(zip(todo_list, finished))
    return [x for x in todo_list if ans_dict[x] is False]