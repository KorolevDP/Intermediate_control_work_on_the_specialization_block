package Controller;

import Model.Toys;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Интерфейс вьюхи
 */
public interface iGetView {

    void printAllToys(List<Toys> toys);
    void printQueueToys(PriorityQueue<Toys> toysPr);
    void printOneToy(Toys toy);
    void printMsg(String msg);

    String promt(String msg);
}
