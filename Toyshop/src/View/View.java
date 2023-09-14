package View;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import Controller.iGetView;
import Model.Toys;

public class View implements iGetView {

    public void printAllToys(List<Toys> toys){
        System.out.println("=====================Список_игрушек======================");
        for (Toys toy: toys)
        {
            System.out.println(toy);
        }
        System.out.println("==========================================================");
    }

    public void printQueueToys(PriorityQueue<Toys> toys){
        System.out.println("=====================Очередь_игрушек======================");
        for (Toys toy: toys)
        {
            System.out.println(toy);
        }
        System.out.println("==========================================================");
        System.out.println(toys.getClass());
        System.out.println("==========================================================");
    }

    public void printOneToy(Toys toy) {
        System.out.println("\n" + toy);
    }

    /**
     * Метод для ввода значений с клавиатуры
     * @param message
     * @return
     */
    public  String promt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public void printMsg(String msg){
        System.out.println(msg);
    }

}
