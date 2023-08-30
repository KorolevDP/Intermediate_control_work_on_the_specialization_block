package View;

import java.util.PriorityQueue;
import java.util.Scanner;

import Model.Toys;

public class View {

    public static void printPriorityQueueToys(PriorityQueue<Toys> toys){
        System.out.println("=====================Очередь_игрушек======================");
        for (Toys toy: toys)
        {
            System.out.println(toy);
        }
        System.out.println("==========================================================");
    }

    public static void printPrizeToy(PriorityQueue<Toys> toys){
        System.out.println(toys.peek());
    }


    public static String promt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
