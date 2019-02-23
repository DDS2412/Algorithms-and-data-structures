package week1; 
import mooc.*;
  
public class task4 { 
    public static void main(String[] args){ 
        try (EdxIO io = EdxIO.create()) { 
 
             int count = io.nextInt();
             
             Pair[] pairs = new Pair[count];
 
             for(int i = 0; i < count; i++){
                 pairs[i] = new Pair(io.nextDoublePrecise(), i);
             }
            
             sort(pairs, count, io);

             io.print(String.format("%d ", pairs[0].Key+1));
             io.print(String.format("%d ", pairs[count/2].Key+1));
             io.print(String.format("%d ", pairs[count-1].Key+1));
         }
     }
 
     private static void sort(Pair[] pairs, int count, EdxIO io){
         for(int i = 1; i< count; i++){
            Pair item = pairs[i];
            int j = i-1;

            while(j >= 0 && pairs[j].Value > item.Value){
                pairs[j+1] = pairs[j];
                j--;
             }

             pairs[j+1] = item;
         }
     }

    private static class Pair{
        public double Value;
        public int Key;

        public Pair(double value, int key){
            Value = value;
            Key = key;
        }
    }
} 