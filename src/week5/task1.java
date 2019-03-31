package week5; 

import mooc.*;

public class task1 { 
    static int[] arr;
    static int n;
   public static void main(String[] args){ 
        try (EdxIO io = EdxIO.create()) { 
            n = io.nextInt();
            arr = new int[n+1];
            boolean isHeap = true;

            for(int i = 1; i <= n; i++){
                arr[i] = io.nextInt();
            }

            for(int i = 1; i <= n; i++){
                isHeap &= isHeapify(i);
            }

            io.println(isHeap ? "YES" : "NO"); 
        } 
    }
    
    public static boolean isHeapify(int index){
        boolean isHeap = true;
        if(n >= index*2){
            isHeap &= arr[index] <= arr[index*2];

            if(n - 1 >= index*2){
                isHeap &= arr[index] <= arr[index*2 + 1];
            }
        }

        return isHeap;
    }
} 
