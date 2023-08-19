import view
import model
import text

my_col_notes = model.CollectionNotes()

def start():

    while True:
        choice = view.main_menu()

        match choice:

            case 1:
                my_col_notes.open_notes()
                view.print_message(text.load_successful)

            case 2:
                my_col_notes.save_notes()
                view.print_message(text.save_successful)

            case 3:
                my_note = my_col_notes.load()
                view.print_notes(my_note, text.collection_notes_empty)

            case 4:
                note = view.input_note(text.input_new_note)
                title = my_col_notes.add(note)
                view.print_message(text.new_note_successfull(title))

            case 5:
                id_ = view.input_search(text.input_search)
                result = my_col_notes.search(id_)
                view.print_notes(result, text.empty_search(id_))

            case 6:
                date_ = view.input_date(text.input_date)
                result = my_col_notes.selection_by_date(date_)
                view.print_notes(result, text.empty_search_date(date_))

            case 7:
                id_ = view.input_search(text.input_change)
                result = my_col_notes.search(id_)
                if result:
                    view.print_notes(result, '')
                    new_note = view.input_note(text.change_note)
                    title = my_col_notes.change_note(new_note, id_)
                    view.print_message(text.change_succsessful(title))
                else:
                    view.print_message(text.empty_search(id_))

            case 8:
                id_ = view.input_search(text.input_delete)
                result = my_col_notes.search(id_)
                if result:
                     current_id = result[0].get('id')
                     view.print_notes(result, '')
                     title = my_col_notes.delete_note(current_id)
                     view.print_message(text.delete_succsessful(title))
                else:
                    view.print_message(text.empty_search(id_))

            case 9:
                break