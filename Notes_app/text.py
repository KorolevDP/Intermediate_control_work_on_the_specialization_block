# -*- coding: cp1251 -*-

main_menu = '''\n������� ����:
    1. ������� ����
    2. ��������� ����
    3. �������� �������
    4. �������� �������
    5. ����� �������
    6. �������� �������
    7. ������� �������
    8. �����\n'''

input_choice = '�������� ����� ����: '

load_successful = '����� ������� ������� ������'

save_successful = '����� ������� ������� ��������'

collection_notes_empty = '����� ������� ���� ��� �� ��������'

input_new_note = '������� ������ ����� �������:'

new_note = {'name': '������� ��������� �������: ',                 
               'body': '������� ���� �������: '}

def new_note_successfull(name: str):
    return f'������� {name} ������� ���������'

input_search = "������� �������� �������� ��� ������: "

def empty_search(word) -> str:
    return f'������� ���������� ����� "{word}" �� �������'

input_change = "����� ������� ����� ������: "
input_index = "������� ������ �������: "

change_note = '������� ����� ������ ��� �������� ���� ������, ����� �� ������: '

def change_succsessful(name: str) -> str:
    return f'������� {name}������� ��������'

input_delete = "����� ������� ����� �������: "

def delete_succsessful(name: str) -> str:
    return f'������� {name} ������� �������'