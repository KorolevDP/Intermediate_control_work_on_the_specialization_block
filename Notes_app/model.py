from datetime import datetime
import uuid
import json

class CollectionNotes:

    # Конструктор класса заметок
    def __init__(self, path: str = 'Notes.json'):
        self._notes: list[dict[int, str, str, datetime]] = []
        self._path = path
        self._id = id
        self._date = datetime
        
    # Считывание файла с заметками в переменную
    def open_notes(self):       
           with open(self._path, 'r', encoding='UTF-8') as file:
               self._notes = json.load(file)
               return self._notes

    # Сохранение данных из переменной в json-файл
    def save_notes(self):
         self.notes = json.dumps(self._notes)
         self.notes = json.loads(str(self.notes))        
         with open(self._path, 'w', encoding='utf-8') as file:
            json.dump(self.notes, file, indent=4, ensure_ascii=False)

    def load(self):
        return self._notes

    # Добавление новой заметки
    def add(self, new: dict[int, str, str, datetime]) -> str:
        new['id'] = uuid.uuid1().int
        new['date'] = datetime.now().strftime('%d.%m.%Y %H:%M:%S')  
        self._notes.append(new)
        return new.get('title') 
    
    # Поиск заметки по ID
    def search(self, id_) -> list[dict[int, str, str, datetime]]:
        result: list[dict[int, str, str, datetime]] = []
        for note in self._notes:
            if id_ == note['id']:
                result.append(note) 
                break
        return result

    # Выборка заметок по дате
    def selection_by_date(self, date_) -> list[dict[int, str, str, datetime]]:
        result: list[dict[int, str, str, datetime]] = []
        for note in self._notes:
            if date_ in note['date']:
                result.append(note)                 
        return result
     
    # Изменение заметки
    def change_note(self, new: dict, index: int) -> str:
        for note in self._notes:
            if index == note.get('id'):
                note['title'] = new.get('title', note.get('title'))                
                note['body'] = new.get('body', note.get('body'))
                note['date'] = datetime.now().strftime('%d.%m.%Y %H:%M:%S')
                return note.get('title')

    # Удаление заметки
    def delete_note(self, index: int) -> list[dict[int, str, str, datetime]]:
        for note in self._notes:
            if index == note.get('id'):
                self._notes.remove(note)
                break
        return note.get('title')
 