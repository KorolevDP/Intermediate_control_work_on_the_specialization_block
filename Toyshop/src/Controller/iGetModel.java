package Controller;

import Model.Toys;

import java.util.PriorityQueue;

public interface iGetModel {

    public PriorityQueue<Toys> getAllToys();

    public void deleteSelToy(Toys std);

    public PriorityQueue<Toys> getFoundToyById(int id);

    void addNewToy(Toys newToy);
}
