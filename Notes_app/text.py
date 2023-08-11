# -*- coding: cp1251 -*-

main_menu = '''\nГлавное меню:
    1. Открыть файл
    2. Сохранить файл
    3. Показать заметки
    4. Добавить заметку
    5. Найти заметку
    6. Изменить заметку
    7. Удалить заметку
    8. Выход\n'''

input_choice = 'Выберите пункт меню: '

load_successful = 'Набор заметок успешно открыт'

save_successful = 'Набор заметок успешно сохранен'

collection_notes_empty = 'Набор заметок пуст или не загружен'

input_new_note = 'Введите данные новой заметки:'

new_note = {'name': 'Введите заголовок заметки: ',                 
               'body': 'Введите тело заметки: '}

def new_note_successfull(name: str):
    return f'Заметка {name} успешно добавлена'

input_search = "Введите значение атрибута для поиска: "

def empty_search(word) -> str:
    return f'Заметка содержащая слово "{word}" не найдена'

input_change = "Какую заметку будем менять: "
input_index = "Введите индекс заметки: "

change_note = 'Введите новые данные или оставьте поле пустым, чтобы не менять: '

def change_succsessful(name: str) -> str:
    return f'Заметка {name}успешно изменена'

input_delete = "Какую заметку будем удалять: "

def delete_succsessful(name: str) -> str:
    return f'Заметка {name} успешно удалена'