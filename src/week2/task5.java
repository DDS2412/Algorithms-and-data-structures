package week2; 
import java.util.ArrayList;
import java.util.List;

import mooc.*; 
  
public class task5 { 
   public static void main(String[] args){ 
       try (EdxIO io = EdxIO.create()) { 
           int n = io.nextInt();
           int k = io.nextInt();

           int[] arr = new int[n];

           for(int i =0; i < n; i++){
               arr[i] = io.nextInt();
           }

           ArrayList<ArrayList> a = new ArrayList<ArrayList>();
           for(int i = 0; i < k; i++){
               a.add(new ArrayList());
               for (int j = i; j < arr.length; j += k){
                    a.get(i).add(arr[j]);
               }
               int[] intArr = new int[a.get(i).size()];
               for(int j = 0; j < a.get(i).size(); j++){
                   intArr[j] = (int)a.get(i).get(j);
               }

               doSort(intArr, 0, intArr.length - 1);
               
               ArrayList arrList = new ArrayList();
               for(int j = 0; j < intArr.length;j++){
                   arrList.add(intArr[j]);
               }

               a.set(i, arrList);
           }
           
           io.print(isSorted(arr, a, k) ? "YES" : "NO");
       }
   } 

    private static void doSort(int[] array, int startIndex, int endIndex){
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

   doSort(array, startIndex, middleIndex);
   doSort(array, middleIndex+1, endIndex);
}

   private static void swap(int[] arr, int i, int k){
     int temp = arr[i];
     arr[i] = arr[i+k];
     arr[i+k] = temp;
   }

   private static boolean isSorted(int[] arr, ArrayList<ArrayList> arrs, int k){
       for(int i = 1; i < arr.length;i++){
            int arrsIndex = i % k;
            int index = i / k;

            if(arr[i - 1] > (int)arrs.get(arrsIndex).get(index)){
                return false;
            }
            else{
                arr[i] = (int)arrs.get(arrsIndex).get(index);
            }
       }
       return true;
   }
} 
