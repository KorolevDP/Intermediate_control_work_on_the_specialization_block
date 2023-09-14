package Model;

import Controller.iGetModel;

import java.util.List;

public class ModelList implements iGetModel {

    private List<Toys> toys;

    public ModelList(List<Toys> toys) {
        this.toys = toys;
    }

    public List<Toys> getAllToys(){
        return toys;
    }

    public void addNewToy(Toys newtoy) {
        this.getAllToys().add(newtoy);
    }

}
