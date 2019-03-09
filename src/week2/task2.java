package week2; 

import mooc.*; 
import java.util.Arrays;
  
public class task2 { 
    public static void main(String[] args){ 
        try (EdxIO io = EdxIO.create()) { 
           int count = io.nextInt(); 
           int[] array = new int[count];

           for(int i = 0; i < count; i++){
                array[i] = io.nextInt();
           }

           LongCount inversionСount = new LongCount();
           int[] res = sortMerge(0,array, inversionСount);

           io.print(inversionСount.count);
        } 
    } 

    private static int[] sortMerge(int startIndex, int[] arr, LongCount inversionСount) {

        int len = arr.length;
        if(len == 1){
            return arr;
        }

        int[] leftArr = sortMerge(startIndex, Arrays.copyOfRange(arr, 0, len/2), inversionСount);
        int[] rightArr = sortMerge(len/2 + startIndex, Arrays.copyOfRange(arr, len/2, len),
         inversionСount);
        
        return merge(startIndex, leftArr, rightArr, inversionСount);
    }

    private static int[] merge(int startIndex, int[] arr1, int[] arr2,LongCount inversionСount) {
        int i = 0, j = 0, currCount = 0;

        int[] res = new int[arr1.length + arr2.length];

        while(i < arr1.length || j < arr2.length){

            if(j == arr2.length || (i < arr1.length && arr1[i] <= arr2[j])){
                res[currCount++] = arr1[i++];
            }
            else{
                if(i< arr1.length){
                    inversionСount.count += arr1.length - i;
                }
                
                res[currCount++] = arr2[j++];
            }
        }
    
        return res;
    }

    public static class LongCount{        
        public LongCount(){
            count = 0;
        }
        public long count;
    }
} 
