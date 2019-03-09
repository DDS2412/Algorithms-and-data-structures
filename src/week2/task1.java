package week2; 

import mooc.*;
import java.util.Arrays;

public class task1 {     
    public static void main(String[] args){ 
        try (EdxIO io = EdxIO.create()) { 
           int count = io.nextInt(); 
           int[] array = new int[count];

           for(int i = 0; i < count; i++){
                array[i] = io.nextInt();
           }
           StringBuilder st = new StringBuilder();
           int[] res = sortMerge(0,array, io, st);
           if(st.length() > 0){
            io.print(st.toString());
           }
          for(int i = 0; i < res.length; i++){
            io.print(String.format("%d ", res[i]));
           }
        } 
    } 

    private static int[] sortMerge(int startIndex, int[] arr, EdxIO io, StringBuilder st) {
        int len = arr.length;
        if(len == 1){
            return arr;
        }

        int[] leftArr = sortMerge(startIndex, Arrays.copyOfRange(arr, 0, len/2), io, st);
        int[] rightArr = sortMerge(len/2 + startIndex, Arrays.copyOfRange(arr, len/2, len), io, st);
        
        return merge(startIndex, leftArr, rightArr, io, st);
    }

    private static int[] merge(int startIndex, int[] arr1, int[] arr2, EdxIO io,StringBuilder st) {
        int i = 0, j = 0, currCount = 0;
        
        int[] res = new int[arr1.length + arr2.length];

        while(i < arr1.length || j < arr2.length){
            if(j == arr2.length || (i < arr1.length && arr1[i] <= arr2[j])){
                res[currCount++] = arr1[i++];
            }
            else{
                res[currCount++] = arr2[j++];
            }
        }

        st.append(String.format("%d %d %d %d\n", startIndex + 1, startIndex + arr1.length +   arr2.length, res[0], res[arr1.length + arr2.length - 1]));

        
    
        return res;
    }
} 
