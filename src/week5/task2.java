package week5; 

import mooc.*; 
  
public class task2 { 
    public static void main(String[] args){ 
        try (EdxIO io = EdxIO.create()) { 
            int n = io.nextInt();
            MinHeap heap = new MinHeap(n);
            StringBuilder st = new StringBuilder();

            for(int i = 0; i < n; i++){
                switch(io.nextChar()){
                    case 'A' :{
                        heap.addElem(io.nextInt());
                        break;
                    }
                    case 'X' :{
                        heap.deleteElem(st);
                        break;
                    }
                    case 'D' :{
                        heap.insert(io.nextInt(), io.nextInt());
                        break;
                    }
                }
            }

            io.print(st);
        } 
    }

    static class MinHeap {
        private HeapItem[] innerArr;
        private int size;
        private int top;
        private boolean isSorted;
        private int minIndex;

        public MinHeap(int size){
            this.size = size;
            this.innerArr = new HeapItem[size];
            this.top = -1;
            this.minIndex = this.top;
            this.isSorted = false;
        }
    
        public void addElem(int newElem){
            this.minIndex = ++top;
            HeapItem item = new HeapItem(top, newElem);
            innerArr[top] = item;

            if(isSorted)
                isSorted = !isSorted;
        }
    
        public void deleteElem(StringBuilder st){
            if(!isEmpty()){
                if(isSorted){
                    st.append(String.format("%d\n", innerArr[minIndex].value));
                } else {
                    buildMaxHeap();
                    isSorted = true;
                    
                    st.append(String.format("%d\n", innerArr[minIndex].value));
                }

                top--;
                minIndex = top;
            } else {
                st.append("*\n");
            }

            for(int i = 0; i < top + 1; i++){
                innerArr[i].heapIndex = i;
            }
        }
    
        public void insert(int index, int value) {
            if(top + 1 >= index){
                innerArr[index - 1].value = value;
                isSorted = false;
            }
        }

        private void buildMaxHeap(){
            for(int index = top/2; index >= 0; index--){
                setMaxHeapify(index);
            }
        }
    
        private void setMaxHeapify(int index){
            int lagestIndex, leftIndex, rightIndex;
    
            leftIndex = getLeftIndex(index);
            rightIndex = getRightIndex(index);
    
            if(isExistLeftElem(index) &&
             innerArr[innerArr[leftIndex].heapIndex].value >
              innerArr[innerArr[index].heapIndex].value) {
                lagestIndex = leftIndex;
            } else {
                lagestIndex = index;
            }
    
            if(isExistRightElem(index) &&
                innerArr[innerArr[rightIndex].heapIndex].value >
                innerArr[innerArr[lagestIndex].heapIndex].value) {
                    lagestIndex = rightIndex;
                }
            
            if(lagestIndex != index){
                swap(index, lagestIndex);
                setMaxHeapify(lagestIndex);
            }
        }
    
        private int getLeftIndex(int index) { return index * 2 + 1; }
    
        private int getRightIndex(int index) { return (index + 1) * 2; }
    
        private boolean isExistLeftElem(int index) { return top >= index * 2 + 1; }
    
        private boolean isExistRightElem(int index) { return top >= (index + 1) * 2; }
    
        private void swap(int index1, int index2) {
            int tmp = innerArr[index1].heapIndex;
            innerArr[index1].heapIndex = innerArr[index2].heapIndex;
            innerArr[index2].heapIndex = tmp;
            if(innerArr[index1].value < innerArr[minIndex].value)
                minIndex = index1;
        }
    
        private boolean isEmpty() { return top < 0; }

        class HeapItem{
            public int index;
            public int heapIndex;
            public int value;

            public HeapItem(int index, int value){
                this.index = index;
                this.heapIndex = index;
                this.value = value;
            }
        }
    }    
} 

