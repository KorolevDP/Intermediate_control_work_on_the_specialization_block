# -*- coding: cp1251 -*-

main_menu = '''\n������� ����:
    1. ������� ����
    2. ��������� ����
    3. �������� �������
    4. �������� �������
    5. ����� �������
    6. ������� ������� �� ����
    7. �������� �������
    8. ������� �������
    9. �����\n''' 


input_choice = '�������� ����� ����: '

load_successful = '����� ������� ������� ������'

save_successful = '����� ������� ������� ��������'

collection_notes_empty = '����� ������� ���� ��� �� ��������'

input_new_note = '������� ������ ����� �������:'

new_note = {'title': '������� ��������� �������: ',                 
            'body': '������� ���� �������: '}

def new_note_successfull(title: str):
    return f'������� "{title}" ������� ���������'

input_search = "������� ID ��� ������: "

input_date = "������� ���� ��� �������: "

def empty_search(id_) -> str:
    return f'������� ���������� ID "{id_}" �� �������'

def empty_search_date(date_) -> str:
    return f'������� ���������� ���� "{date_}" �� �������'

input_change = "����� ������� ����� ������ (ID): "
input_index = "������� ������ �������: "

change_note = '������� ����� ������ ��� �������� ���� ������, ����� �� ������: '

def change_succsessful(title: str) -> str:
    return f'������� "{title}" ������� ��������'

input_delete = "����� ������� ����� ������� (ID): "

def delete_succsessful(title: str) -> str:
    return f'������� "{title}" ������� �������'