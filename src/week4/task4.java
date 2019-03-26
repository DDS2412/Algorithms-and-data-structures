package week4; 
import mooc.*; 
  
public class task4 {     
        public static void main(String[] args){ 
            try (EdxIO io = EdxIO.create()) { 
                int n = io.nextInt();

                Queue queue = new Queue(n);
                Queue queueMin = new Queue(n);

                StringBuilder st = new StringBuilder();
                for(int i = 0; i < n; i++){
                    char symbol = io.nextChar();
                    switch(symbol){
                        case '+':{
                            int item = io.nextInt();
                            queue.addElement(item);

                            if(queueMin.isEmpty()){
                                queueMin.addElement(item);
                            } else {
                                queueMin.insertMin(item);
                            }

                            break;
                        }
                        case '-':{
                            if(!queue.isEmpty()){
                                if(queueMin.getFront() == queue.deleteElement()){
                                    queueMin.deleteElement();
                                }
                            }
                            
                            break;
                        }
                        default: {
                            st.append(queueMin.getFront());
                            st.append('\n');
                        }
                    }
                }
    
                io.print(st);
            }
        }
    
        static class Queue{
            private int[] queue;
            private int maxSize; // максимальное количество элементов в очереди 
            private int nElem;  // текущее количество элементов в очереди 
            private int front;
            private int rear;
        

        public Queue(int maxSize) {
            this.maxSize = maxSize;
            queue = new int[maxSize];
            rear = -1;
            front = 0;
            nElem = 0;
        }

        public void addElement(int elem) {
            if (rear == maxSize - 1) {  // циклический перенос
                rear = -1;
            }
            
            queue[++rear] = elem;  //увеличение Rear и вставка
            nElem++;  // увеличение количества элементов в очереди
        }
        
        public int deleteElement() {
            int temp = queue[front++]; // получаем первый элемент из очереди
                
                if (front == maxSize) { // циклический перенос
                    front = 0;
                }
                nElem--; // уменьшаем количество элементов в очереди 
                return temp;
                
        }

        public int getFront() {
            return queue[front];
        }
                    
        public int getRear() {
            return queue[rear];
        }                    

        public boolean isEmpty() {
            return (nElem == 0);
        }

        public void insertMin(int elem){
            if(nElem > 1 && queue[rear] > elem){
                 queue[front] = elem;
            }
            else{
                addElement(elem);
            }
        }
    }
} 
