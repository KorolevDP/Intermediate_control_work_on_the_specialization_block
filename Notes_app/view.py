import text

def main_menu() -> int:
    print(text.main_menu)
    while True:
        choice = input(text.input_choice)
        if choice.isdigit() and 0 < int(choice) < 9:
            return int(choice)


def print_message(message: str):
    print('\n' + '='*len(message))
    print(message)
    print('='*len(message) + '\n')


def print_notes(notes: list[dict[str,str]], error: str):
    if notes:
        print('\n' + '=' * 71)
        for note in notes:
            print(f'{note.get("id"):>3}. {note.get("name"): < 20} | {note.get("body"):< 20} | {note.get("date"):15}')
        print('=' * 71 + '\n')
    else:
        print_message(error)


def input_note(message) -> dict[str, str]:
    new = {}
    print(message)
    for key, txt in text.new_note.items():
        value = input(txt)
        if value:
            new[key] = value
    return new

def input_search(message) -> str:
    return input(message)

