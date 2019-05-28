package stepik.greedy_algorithm;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    class Item implements Comparable<Item> {
        int cost;
        int weight;
        
        public Item(int cost, int weight){
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public int compareTo(Item o) {
            double r1 = (double)cost / weight;
            double r2 = (double)o.cost / o.weight;
            return -Double.compare(r1, r2);
        }
    }

    private void run() throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int W = input.nextInt();
        Item[] items = new Item[n];
        for(int i =0; i < n; i++){
            items[i] = new Item(input.nextInt(),input.nextInt());
        }

        Arrays.sort(items);
        double res = 0;
        for(Item item : items){
            if(item.weight <= W){
                res += item.cost;
                W -= item.weight;
            } else{
                res += (double)item.cost * W / item.weight;
                break;
            }
        }

        System.out.println(res);
    }
    public static void main(String[] args) throws FileNotFoundException {
        new Task2().run();
    }
}