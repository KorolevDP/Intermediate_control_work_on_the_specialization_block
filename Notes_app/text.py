# -*- coding: cp1251 -*-

main_menu = '''\nГлавное меню:
    1. Открыть файл
    2. Сохранить файл
    3. Показать заметки
    4. Добавить заметку
    5. Найти заметку
    6. Выборка заметок по дате
    7. Изменить заметку
    8. Удалить заметку
    9. Выход\n''' 


input_choice = 'Выберите пункт меню: '

load_successful = 'Набор заметок успешно открыт'

save_successful = 'Набор заметок успешно сохранен'

collection_notes_empty = 'Набор заметок пуст или не загружен'

input_new_note = 'Введите данные новой заметки:'

new_note = {'title': 'Введите заголовок заметки: ',                 
            'body': 'Введите тело заметки: '}

def new_note_successfull(title: str):
    return f'Заметка "{title}" успешно добавлена'

input_search = "Введите ID для поиска: "

input_date = "Введите дату для выборки: "

def empty_search(id_) -> str:
    return f'Заметка содержащая ID "{id_}" не найдена'

def empty_search_date(date_) -> str:
    return f'Заметка содержащая дату "{date_}" не найдена'

input_change = "Какую заметку будем менять (ID): "
input_index = "Введите индекс заметки: "

change_note = 'Введите новые данные или оставьте поле пустым, чтобы не менять: '

def change_succsessful(title: str) -> str:
    return f'Заметка "{title}" успешно изменена'

input_delete = "Какую заметку будем удалять (ID): "

def delete_succsessful(title: str) -> str:
    return f'Заметка "{title}" успешно удалена'