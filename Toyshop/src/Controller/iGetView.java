package Controller;

import Model.Toys;
import java.util.PriorityQueue;

public interface iGetView {

    void printAllToys(PriorityQueue<Toys> toys);

    String promt(String msg);
}
