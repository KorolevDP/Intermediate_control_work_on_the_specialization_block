package Controller;

import View.View;

public class Controller {
    public void run() {
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = View.promt("Enter command:> ");
            com = Commands.valueOf(command.toUpperCase());

            switch (com) {
                case CREATE:
                    GenerateNewToy.createNewToy();

                case READ:

                case ADD:


                case EXIT:                                                               // выход
                    getNewIteration = false;
                    System.out.println("Exit from program ");
                    break;

                    Model.saveAllStudentsHmToFile(model.getAllHashStudents());

                    view.printAllHashStudents(model.getAllHashStudents());
                    break;
            }
        }
    }

}
