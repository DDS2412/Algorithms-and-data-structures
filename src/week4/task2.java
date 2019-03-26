package week4; 
import mooc.*; 
import week2.EdxIO;
  
public class task2 {     
        public static void main(String[] args){ 
            try (EdxIO io = EdxIO.create()) { 
                int n = io.nextInt();
                boolean[] resArr = new boolean[n];

                Queue queue = new Queue(n);

                StringBuilder st = new StringBuilder();
                for(int i = 0; i < n; i++){
                    char symbol = io.nextChar();
                    if(symbol == '+'){
                        queue.addElement(io.nextInt());
                    }
                    else{
                        if(!queue.isEmpty()){
                            st.append(queue.deleteElement());
                            st.append("\n");
                        }
                    }
                }
    
                io.print(st);
            }
        }
    
        static class Queue {
            private int mSize;
            private int[] queueArray;
            private int top;
         
            public Queue(int m) {
                this.mSize = m;
                queueArray = new int[mSize];
                top = this.mSize;
            }
    
            public void addElement(int element) {
                queueArray[--top] = element;
            }
         
            public int deleteElement() {
                return queueArray[top++];
            }
    
            public boolean isEmpty() {
                return (top == this.mSize);
            }
        }
} 
