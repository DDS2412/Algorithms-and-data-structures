package week1; 
import mooc.*; 
  
public class task2 { 
   public static void main(String[] args){ 
       try (EdxIO io = EdxIO.create()) { 
           long nextA = io.nextLong();
           long nextB = io.nextLong();
           
           io.println((long)(nextA + nextB * nextB )); 
       } 
   } 
} 
