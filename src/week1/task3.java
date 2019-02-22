package week1; 
import mooc.*; 
  
public class task3 { 
   public static void main(String[] args){ 
       try (EdxIO io = EdxIO.create()) { 

            int count = io.nextInt();
            long[] array = new long[count];

            for(int i = 0; i < count; i++){
                array[i] = io.nextLong();
            }
           
            sort(array, count, io);
            for (long item : array) {
                io.print(String.format("%d ", item));
            }
        }
    }

    private static void sort(long[] array, int count, EdxIO io){
        io.print(String.format("%d ", 1));

        for(int i = 1; i< count; i++){
            long key = array[i];
            int j = i-1;
            while(j >= 0 && array[j] > key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;

            io.print(String.format("%d ", j+2));
        }
        
        io.println("\n");        
    }

}
