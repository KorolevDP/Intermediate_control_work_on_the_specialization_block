package Model;

import Controller.iGetModel;

import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ModelPrQueue implements iGetModel {

    private PriorityQueue<Toys> toys;

    public ModelPrQueue(PriorityQueue<Toys> toys) {
        this.toys = toys;
    }

    public PriorityQueue<Toys> getAllToys(){
        return toys;
    }

    @Override
    public void deleteSelToy(Toys toy) {
        this.getAllToys().remove(toy);
    }

    @Override
    public PriorityQueue<Toys> getFoundToyById(int id) {
        return null;
    }

/*    public PriorityQueue<Toys> getFoundToyById(int id) {
        PriorityQueue<Toys> result = (PriorityQueue<Toys>) this.getAllToys().stream().filter(item -> Integer.valueOf(item.getToyId()).equals(id));
         .collect(Collectors.toList());
        return result;
    }*/


    public void addNewToy(Toys newtoy) {
        this.getAllToys().add(newtoy);
    }
}
