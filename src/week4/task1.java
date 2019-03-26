package week4; 
import mooc.*; 
import week2.EdxIO;
  
public class task1 {     
        public static void main(String[] args){ 
            try (EdxIO io = EdxIO.create()) { 
                int n = io.nextInt();
                Stack stack = new Stack(n);
                StringBuilder st = new StringBuilder();
                for(int i = 0; i < n; i++){
                    char symbol = io.nextChar();
                    if(symbol == '+'){
                        stack.addElement(io.nextInt());
                    }
                    else{
                        if(!stack.isEmpty()){
                            st.append(stack.deleteElement());
                            st.append("\n");
                        }
                    }
                }
    
                io.print(st);
            }
        }
    
        static class Stack {
            private int mSize;
            private int[] stackArray;
            private int top;
         
            public Stack(int m) {
                this.mSize = m;
                stackArray = new int[mSize];
                top = -1;
            }
    
            public void addElement(int element) {
                stackArray[++top] = element;
            }
         
            public int deleteElement() {
                return stackArray[top--];
            }
    
            public boolean isEmpty() {
                return (top == -1);
            }
        }
} 
