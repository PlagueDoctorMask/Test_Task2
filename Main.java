package FinalTest_Task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random random = new Random();
    public static void main(String[] args) {
        Toy toy1 = new Toy(1, "Car", 4, 49);
        Toy toy2 = new Toy(2, "Doll", 4, 49);
        Toy toy3 = new Toy(3, "Coin", 1, 2);
        Start(toy1, toy2, toy3);
    }

    public static void Start(Toy toy1, Toy toy2, Toy toy3){
        System.out.println("These are the toys, you can win\n"+toy1.toString()+"\n"+toy2.toString()+"\n"+toy3.toString());
        System.out.println("");
        int limit = toy1.GetQuantity()+toy2.GetQuantity()+toy3.GetQuantity()-1;
        try{
            System.out.println("choose the number of toys, the limit is "+limit);
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (num > limit) {
                throw new Exception("You have exceeded the limit");
            }
            Deque<Toy> ToysQueue = new ArrayDeque<>();
            for (int i = 0; i < num; i++) {
                Put(ToysQueue, toy1, toy2, toy3);
            }
            System.out.println("");
            System.out.println("preparing the queue....");
            System.out.println("");
            for (int i = 0; i < num; i++) {
                prepareFile(ToysQueue.getFirst());
                Get(ToysQueue);
            }
            System.out.println("");
            System.out.println("You can also find your toys in");
        }
        catch(InputMismatchException e){
            System.out.println("you can enter only type integer");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void Put(Deque<Toy> ToysQueue, Toy toy1, Toy toy2, Toy toy3) throws Exception{
        int chance = random.nextInt(101);
        if ((chance == 1 || chance == 100)&&toy3.GetQuantity()!=0) {
            ToysQueue.addFirst(toy3);
            toy3.SetQuantity(toy3.GetQuantity()-1);
        }
        else{
            if (chance%2==0 && toy1.GetQuantity()!=0) {
                ToysQueue.addFirst(toy1);
                toy1.SetQuantity(toy1.GetQuantity()-1);
            }
            else{
                if (toy2.GetQuantity()!=0) {
                    ToysQueue.addFirst(toy2);
                    toy2.SetQuantity(toy2.GetQuantity()-1);
                }
                else{
                    throw new Exception("Unknown error, try again");
                }
            }
        }
    }

    public static void Get(Deque<Toy> ToysQueue){
        System.out.println("You have won "+ToysQueue.poll().GetName());
    }

    static void prepareFile(Toy toy){
        try(FileWriter fileWriter = new FileWriter("toys.txt", true)){
            fileWriter.write(toy.GetName()+" ");
            fileWriter.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
