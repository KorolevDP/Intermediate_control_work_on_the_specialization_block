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
                view.print_contacts(my_note, text.collection_notes_empty)

            case 4:
                note = view.input_note(text.input_new_note)
                name = my_col_notes.add(note)
                view.print_message(text.new_note_successfull(name))

            case 5:
                key_word = view.input_search(text.input_search)
                result = my_col_notes.search(key_word)
                view.print_notes(result, text.empty_search(key_word))

            case 6:
                key_word = view.input_search(text.input_change)
                result = my_col_notes.search(key_word)
                if result:
                    if len(result) != 1:
                        view.print_notes(result, '')
                        current_id = view.input_search(text.input_index)
                    else:
                        current_id = result[0].get('id')
                    view.print_notes(result, '')
                    new_note = view.input_note(text.change_note)
                    name = my_col_notes.change_note(new_note, current_id)
                    view.print_message(text.change_succsessful(name))
                else:
                    view.print_message(text.empty_search(key_word))

            case 7:

                key_word = view.input_search(text.input_delete)
                result = my_col_notes.search(key_word)
                if result:
                    if len(result) != 1:
                        view.print_notes(result, '')
                        current_id = view.input_search(text.input_index)
                    else:
                        current_id = result[0].get('id')
                    view.print_notes(result, '')
                    name = my_col_notes.delete_note(current_id)
                    view.print_message(text.delete_succsessful(name))
                else:
                    view.print_message(text.empty_search(key_word))

            case 8:
                break