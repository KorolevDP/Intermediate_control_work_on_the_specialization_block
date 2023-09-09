package View;

import java.util.PriorityQueue;
import java.util.Scanner;

import Controller.iGetView;
import Model.Toys;

public class View implements iGetView {

    public void printAllToys(PriorityQueue<Toys> toys){
        System.out.println("=====================Очередь_игрушек======================");
        for (Toys toy: toys)
        {
            System.out.println(toy);
        }
        System.out.println("==========================================================");
    }

    public  String promt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
