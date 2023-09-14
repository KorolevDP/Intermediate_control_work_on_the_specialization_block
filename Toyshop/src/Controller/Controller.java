package Controller;

import Model.Toys;
import View.Text;

import java.io.FileWriter;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Controller {

    private iGetModel model;
    private iGetView view;
    private Text txt;

    private List<Toys> listToys = new ArrayList<>();
    PriorityQueue<Toys> toysPriorityQueue = new PriorityQueue<>();

    public Controller(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Добавление списка игрушек в приоритетную очередь
     */
    private boolean addListToQueue() {
        toysPriorityQueue.clear();
        toysPriorityQueue.addAll(model.getAllToys());
        if (toysPriorityQueue.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод розыгрыша игрушки случайным образом.
     * @return выбранная игрушка
     */
    public Toys drawToy() {

        // проверяем наличие игрушек в магазине
        if (toysPriorityQueue.isEmpty()) {
            view.printMsg(txt.noToysInShop);
        }

        double totalWeight = 0;

        //считаем сумму весов всех игрушек
        for (Toys toy : toysPriorityQueue) {
            totalWeight += toy.getToyDropFrequency();
        }

        // генерируем случайное число от 0 до общей суммы весов
        Random rnd = new Random();
        double randomNumber = rnd.nextDouble() * totalWeight;

        // находим грушку в соответствии сгенерированного числа
        double currentWeight = 0;
        Toys chosenToy = null;

        for (Toys toy : toysPriorityQueue) {
            currentWeight += toy.getToyDropFrequency();

            if (randomNumber <= currentWeight) {
                chosenToy = toy;
                break;
            }
        }

        // выводим результат розыгрыша
        if (chosenToy != null) {
            System.out.println(txt.startWith + "id = " + chosenToy.getToyId() + "; name = " + chosenToy.getToyName() + "; weight = " + chosenToy.getToyDropFrequency());
        } else {
            view.printMsg(txt.empty);
        }
        return chosenToy;
    }

    private boolean testEmpty(List<Toys> listToys) {
        if (listToys.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Добавление игрушки в список
     *
     * @param id
     * @param toyname
     * @param toyWeight
     */
    public void addToy(int id, String toyname, double toyWeight) {
        if (!toyname.isEmpty() && toyWeight > 0) {
            Toys newtoy = new Toys(id, toyname, toyWeight);
            model.addNewToy(newtoy);
        } else {
            view.printMsg(txt.error);
        }
    }

    /**
     * Метод изменения веса игрушки
     * @param id
     * @param weight
     */
    public void setToyWeight(int id, double weight) {
        for (Toys toy : listToys) {
            if (toy.getToyId() == id) {
                toy.setToyDropFrequency(weight);
                view.printOneToy(toy);
                break;
            }
        }
    }

    /**
     * Сохранение выбранной игрушки в файл
     * @param fileName
     * @param toy
     */
    public void saveToyToFile(String fileName, Toys toy) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write("Название: " + toy.getToyName() + "; вес: " + toy.getToyDropFrequency() + "; id: " + toy.getToyId());
            fw.append('\n');
            fw.flush();
        } catch (Exception e) {
            view.printMsg(e.getMessage());
        }
    }

    public void update() {
        listToys = model.getAllToys();
        if (testEmpty(listToys)) {
            view.printAllToys(listToys);
        } else {
            view.printMsg(txt.noToysInShop);
        }
    }

    /**
     * Метод запуска программы с выбором функций
     */
    public void run() {
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {

            String command = view.promt(txt.menu + '\n' + txt.enterCommand);
            com = Commands.valueOf(command.toUpperCase());

            switch (com) {

                case ADD:
                    String toyname = view.promt(txt.enterName);
                    try {
                        int id = Integer.parseInt(view.promt(txt.enterId));
                        double toyweight = Double.parseDouble(view.promt(txt.enterWeight));
                        addToy(id, toyname, toyweight);
                    } catch (Exception e) {
                        System.out.println(e.getClass().getCanonicalName());
                    }
                    break;

                case SETWEIGHT:
                    update();
                    Integer id = Integer.parseInt(view.promt(txt.enterId));
                    double toyweight = Double.parseDouble(view.promt(txt.enterWeight));
                    setToyWeight(id, toyweight);
                    break;

                case PRINT:
                    update();
                    break;

                case PRINTQ:
                    view.printQueueToys(toysPriorityQueue);
                    break;

                case ADDTOQUEUE:
                    addListToQueue();
                    view.printQueueToys(toysPriorityQueue);
                    break;

                case GETTOYFROMQUEUE:
                    Toys getToy = drawToy();
                    saveToyToFile("Result.txt", getToy);
                    break;

                case EXIT:                                                               // выход
                    getNewIteration = false;
                    view.printMsg(txt.exitFromProgramm);
                    break;

                default:
                    getNewIteration = false;
                    view.printMsg(txt.exitFromProgramm);
                    break;
            }
        }
    }
}