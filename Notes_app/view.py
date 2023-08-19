from datetime import datetime
import text

# Вывод главного меню в консоль
def main_menu() -> int:
    print(text.main_menu)
    while True:
        choice = input(text.input_choice)
        if choice.isdigit() and 0 < int(choice) < 10:
            return int(choice)

# Печать заметок
def print_notes(notes: list[dict[int, str, str, datetime]], error: str):
    if notes:
        print(' '*70 + "\033[4m\033[37m\033[44m{}\033[0m".format("Все заметки") + ' '*75)
        print('='*17 + "ID" + '='*30 + "Title" + '='*43 + "Body" + '='*40 + "Date" + '='*14 )
        for note in notes:
            print(f'{str(note.get("id")):>39} | {note.get("title"):>26} | {note.get("body"):<60} | {str(note.get("date")):>23} |')
        print('='*159)
    else:
        print_message(error)

# Печать сообщения        
def print_message(message: str):
    print('\n' + '='*len(message))
    print(message)
    print('='*len(message) + '\n')
 
# Метод для добавления заметки, вывод на экран сообщений для добавления атрибута заметки
def input_note(message) -> dict[str, str]:
    new = {}
    print(message)
    for key, txt in text.new_note.items():
        value = input(txt)
        if value:
            new[key] = value
    return new

# Поиск по ID
def input_search(message) -> int:
    id_ = int(input(message))
    return id_

# Поиск по дате
def input_date(message) -> str:
    date_ = str(input(message))
    return date_
