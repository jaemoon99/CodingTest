def solution(id_pw, db):
    db_dict = {}
    for x in db:
        db_dict[x[0]] = x[1]
    db_dict_keys = list(db_dict.keys())
    db_dict_values = list(db_dict.values())
    
    for x in db:
        if id_pw == x:
            return "login"
    
    if id_pw[0] in db_dict_keys and id_pw[1] in db_dict_values:
        if db_dict_keys.index(id_pw[0]) != db_dict_values.index(id_pw[1]):
            return "wrong pw"
    elif id_pw[0] in db_dict_keys and id_pw[1] not in db_dict_values:
        return "wrong pw"
    else:
        return "fail"