package week2; 
import mooc.*; 
  
public class task4 { 
   public static void main(String[] args){ 
       try (EdxIO io = EdxIO.create()) { 
           int n = io.nextInt();
           int[] arr = new int[n];

           int start = io.nextInt() - 1;
           int end = io.nextInt() - 1;
           int A = io.nextInt();
           int B = io.nextInt();
           int C = io.nextInt();
           arr[0] = io.nextInt();
           arr[1] = io.nextInt();

           for (int i = 2; i < n; i++) {
            arr[i] = A * arr[i - 2] + B * arr[i - 1] + C;
           }

           StringBuilder st = new StringBuilder();
           
           searchItems(arr, start, end, 0, arr.length - 1, 0, arr.length - 1, st);

           io.print(st.toString());
       } 
   } 

   private static void searchItems(int[] array, int kIndex, int kIndexEnd,
        int startIndex, int endIndex, int absStart, int absEnd, StringBuilder st){

    if(endIndex < startIndex){
        return;
    }

    int middleIndex = startIndex + (endIndex - startIndex) / 2;
    int start = startIndex, end = endIndex;

    while(start < end){
        while((array[start] <= array[middleIndex]) && start < middleIndex) { start++; }
            
        while((array[middleIndex] <= array[end]) && end > middleIndex) { end--; } 
        
        if(start < end){
            swap(array, start, end);
            // Задание новых границ
            if(start == middleIndex){
                middleIndex = end;
            }
            else if(end == middleIndex){
                middleIndex = start;
            }
        }
    }

    if(middleIndex == kIndex){
        st.append(array[middleIndex] + " ");
        if(kIndex == kIndexEnd){
            return;
        }
        else{
            searchItems(array, kIndex + 1, kIndexEnd, 
            middleIndex + 1, absEnd, absStart, absEnd, st);
        }
    } 
    else if(middleIndex < kIndex){
        absStart = middleIndex + 1;
        searchItems(array, kIndex, kIndexEnd, 
            middleIndex + 1, endIndex, absStart, absEnd, st);
    }
    else{
        if(middleIndex > kIndexEnd){
            absEnd = middleIndex - 1;
        }
        searchItems(array, kIndex, kIndexEnd, 
            absStart, middleIndex - 1, absStart, absEnd, st);
    }
   }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
} 
