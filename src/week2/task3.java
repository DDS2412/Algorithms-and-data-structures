package week2; 

import mooc.*; 
  
public class task3 {
    public static void main(String[] args){ 
            try(EdxIO io = EdxIO.create()) {
                int count = io.nextInt(); 
                int[] arr = new int[count];
    
                for(int i = 0; i < count; i++){
                     arr[i] = i + 1;
    
                     int m = i / 2;
    
                     swap(arr, i, m);
                }
    
                // Поиск индекса элемента 2
                int index2 = 0;
                while (index2 < arr.length - 1 && arr[index2] != 2) { 
                    index2++; 
                }
    
                // Поиск индекса элемента 1
                int index1 = arr.length - 1;
                while (index1 > 0 && arr[index1] != 1) { index1--; }
    
                swap(arr, index1, index2);
    
                StringBuilder st = new StringBuilder();
    
                for(int i =0; i < count; i++){
                    st.append(arr[i] + " ");
                }
    
                io.print(st.toString());
            }
    } 

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
} 
