ñlass CollectionNotes:

import json
import uuid
from datetime import datetime

    def __init__(self, id, title, body, date, path: str = 'Notes.json'):
        self._notes: list[dict[str,str]] = []
        self.id = id
        self.title = title
        self body = body
        self.date = date
        self.path = path    

    def open_notes(self):      
        with open(self._path, 'r', encoding='UTF-8') as file:
            data = json.load(file)
        for note in data:            
            new = {'id': note[0], 'name': note[1], 'phone': note[2], 'comment': note[3]}
            self._notes.append(new)

    def save_notes(self):
        with open(self._path, 'w', encoding='UTF-8') as file:
            json.dump(data, file, indent=4, separators=(',', ': '))

    def load(self):
        return self._notes

    def add(self, new: dict[str, str]) -> str:
        self.date = datetime.now().strftime('%d.%m.%Y %H:%M:%S')
        self.id = str(uuid.uuid4())
        self.notes.append(new)
        return new.get('name')

    def search(self, word: str) -> list[dict[str, str]]:
        result: list[dict[str, str]] = []
        for note in self._notes:
            for field in note.values():
                if word.lower() in field.lower():
                    result.append(note)
                    break
        return result

    def change_note(self, new: dict, index: int) -> str:
        for note in self._notes:
            if index == note.get('id'):
                note['name'] = new.get('name', note.get('name'))
                note['date'] = new.get('date', note.get('date'))
                note['body'] = new.get('body', note.get('body'))
                return note.get('name')

    def delete_note(self, index: int) -> list[dict[str, str]]:
        for note in self._notes:
            if index == note.get('id'):
                notes.remove(note)
                break
        return note.get('name')