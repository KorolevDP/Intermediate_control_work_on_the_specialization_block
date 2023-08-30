package Controller;

import java.util.PriorityQueue;
import Model.Toys;

public class AddPrizeToy {

    public static PriorityQueue<Toys> addPrizeToyToQueue(Toys toy1, PriorityQueue<Toys> toysPrQueue){
        toysPrQueue.add(toy1);
        return toysPrQueue;
    }
}
