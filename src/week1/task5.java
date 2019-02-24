package week1; 
import mooc.*;

public class task5 { 

    private static long[] array;
    public static void main(String[] args){ 
        try (EdxIO io = EdxIO.create()) { 
 
             int count = io.nextInt();
             array = new long[count];
 
             for(int i = 0; i < count; i++){
                 array[i] = io.nextLong();
             }

            qSort(io);

             for (long item : array) {
                 io.print(String.format("%d ", item));
             }
         }
     }
 
     private static void qSort(EdxIO io){
         int startIndex = 0;
         int endIndex = array.length - 1;
         doSort(startIndex, endIndex, io);

         displayEndOfSwap(io);
     }

     private static void doSort(int startIndex, int endIndex, EdxIO io){
        if(startIndex >= endIndex){
            return;
        }

        int start = startIndex, end = endIndex;
        // Выбор индекса опорного элемента
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        while(start < end){
            while((array[start] <= array[middleIndex]) && start < middleIndex) { start++; }
                
            while((array[middleIndex] <= array[end]) && end > middleIndex) { end--; } 
            
            if(start < end){
                swap(start, end, io);
                // Задание новых границ
                if(start == middleIndex){
                    middleIndex = end;
                }
                else if(end == middleIndex){
                    middleIndex = start;
                }
            }
        }

        doSort(startIndex, middleIndex, io);
        doSort(middleIndex+1, endIndex, io);
     }

     private static void swap(int firstItemIndex, int secodItemIndex, EdxIO io){
         long tmp = array[firstItemIndex];
         array[firstItemIndex] = array[secodItemIndex];
         array[secodItemIndex] = tmp;

         displaySwapPair(firstItemIndex+1, secodItemIndex+1, io);
     }

     private static void displaySwapPair(int firstItemIndex, int secodItemIndex, EdxIO io){
        io.println(String.format("Swap elements at indices %d and %d.", firstItemIndex, secodItemIndex));    
     }

     private static void displayEndOfSwap(EdxIO io){
        io.println("No more swaps needed.");
     }
} 
