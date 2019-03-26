package week4; 
import mooc.*; 
import week2.EdxIO;
  
public class task3 {     
        public static void main(String[] args){ 
            try (EdxIO io = EdxIO.create()) { 
                int n = io.nextInt();

                Stack stack = new Stack(n);

                StringBuilder st = new StringBuilder();

                for(int i = 0; i < n; i++){
                    char[] line = io.next().toCharArray();
                    boolean isCorrect = true;

                    for(int j = 0; j < line.length; j++){
                        switch(line[j]){
                            case '(': {
                                stack.addElement(line[j]);
                                break;
                            }
                            case '[': {
                                stack.addElement(line[j]);
                                break;
                            }
                            case ')': {
                                if(stack.isEmpty() || stack.readTop() != '('){
                                    isCorrect = false;
                                } else {
                                    stack.deleteElement();
                                }
                                break;
                            }
                            default :{
                                if(stack.isEmpty() || stack.readTop() != '['){
                                    isCorrect = false;
                                } else {
                                    stack.deleteElement();
                                }
                            }
                        }
                    }

                    st.append(isCorrect && stack.isEmpty() ? "YES\n" : "NO\n");

                    stack.refresh();
                }
                
                io.print(st);
            }
        }
    
        static class Stack {
            private int mSize;
            private char[] stackArray;
            private int top;
         
            public Stack(int m) {
                this.mSize = m;
                stackArray = new char[mSize];
                top = -1;
            }
    
            public void addElement(char element) {
                stackArray[++top] = element;
            }
         
            public char deleteElement() {
                return stackArray[top--];
            }
    
            public boolean isEmpty() {
                return (top == -1);
            }

            public void refresh(){
                top = -1;
            }

            public char readTop() {
                return stackArray[top];
            }
        }
} 
