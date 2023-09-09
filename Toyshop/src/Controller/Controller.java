package Controller;

import Model.Toys;
import View.Text;

import java.util.PriorityQueue;


public class Controller {

    private iGetModel model;
    private iGetView view;
    private FileActions fa;

    private Text txt;

    private PriorityQueue<Toys> prQueueToys = new PriorityQueue<>();

    public Controller(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;

        fa = new FileActions("Result.txt");
    }

/*    public static PriorityQueue<Toys> addToyToQueue(Toys toy, PriorityQueue<Toys> prQueueToys){
        prQueueToys.add(toy);
        return prQueueToys;
    }*/

    private Toys delFirstElemQueue() {
        Toys elem = prQueueToys.poll();
        if (prQueueToys.size() > 0) {
            System.out.println(txt.startWith + "id= " + elem.getToyId() + " name=" + elem.getToyName());
        } else {
            System.out.println(txt.empty);
        }
        return elem;
    }

    private boolean testEmpty(PriorityQueue<Toys> toys) {
        if (toys.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addToy(int id, String toyname, double toyWeight) {
        if (!toyname.isEmpty() && toyWeight > 0) {
            Toys newtoy = new Toys(id, toyname, toyWeight);
            model.addNewToy(newtoy);
        } else {
            System.out.println(txt.error);
        }
    }

    public void editWeightToy(int id) {
        PriorityQueue<Toys> result = new PriorityQueue<>();
        result = searchToyById(id, model);
        if (result.size() > 0) {
            for (Toys toy : result) {
                System.out.println("id=" + toy.getToyId() + "name=" + toy.getToyName());
                double toyWeight = Double.parseDouble(view.promt(txt.enterWeight));
            }
        } else {
            System.out.println("================================");
            System.out.println(txt.error);
            System.out.println("================================");
        }
    }

    public void deleteToy(int id, iGetModel model) {
        PriorityQueue<Toys> result = model.getFoundToyById(id);
        if (result.size() > 0) {
            for (Toys item : result) {
                model.deleteSelToy(item);
            }
        } else {
            System.out.println("================================");
            System.out.println(txt.emptySearch);
            System.out.println("================================");
        }
    }

    public void update(PriorityQueue<Toys> toys) {
        if (testEmpty(toys)) {
            view.printAllToys(toys);
        } else {
            System.out.println(txt.noToysInShop);
        }
    }

    public PriorityQueue<Toys> searchToyById(int id, iGetModel model) {
        return model.getFoundToyById(id);
    }

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

                case EDIT:
                    try {
                        int id = Integer.parseInt(view.promt(txt.enterId));
                        editWeightToy(id);

                    } catch (Exception e) {
                        System.out.println(e.getClass().getCanonicalName());
                    }
                    break;

                case PRINT:
                    view.printAllToys(prQueueToys);

                case DELETE:
                    try {
                        int id = Integer.parseInt(view.promt(txt.idForDell));
                        deleteToy(id, model);
                        view.printAllToys(prQueueToys);
                    } catch (Exception e) {
                        System.out.println(e.getClass().getCanonicalName());
                    }
                    break;

                case SEARCH:
                    int id = Integer.parseInt(view.promt(txt.enterId));
                    searchToyById(id, model);
                    break;

                case GETTOY:
                    Toys toy = delFirstElemQueue();
                    fa.saveToyToFile(toy);

                case EXIT:                                                               // выход
                    getNewIteration = false;
                    System.out.println(txt.exitFromProgramm);
                    break;

                default:
                    getNewIteration = false;
                    System.out.println(txt.exitFromProgramm);
                    break;
            }
        }
    }
}