package week8;

import mooc.EdxIO;

import java.util.LinkedList;

public class task1 {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            long n = io.nextLong();

            StringBuilder st = new StringBuilder();
            Set set = new Set(65537);

            for(long i = 0; i < n; i++){
                switch (io.nextChar()){
                    case 'A' : {
                        set.add(io.nextLong());

                        break;
                    } case 'D': {
                        set.delete(io.nextLong());

                        break;
                    } case '?' : {
                        st.append(set.find(io.nextLong(), false) ? "Y\n" : "N\n") ;

                        break;
                    }
                }
            }

            io.print(st);
        }
    }

    static class Set
    {
        private LinkedList<Long>[] _array;
        private int _divider;

        public Set(int primeNumber)
        {
            _divider = primeNumber;
            _array = new LinkedList[_divider * 2 - 1];
        }

        private long Hash(long number)
        {
            return number % _divider + 65536;
        }

        private boolean isListExists(long number)
        {
            return _array[(int) Hash(number)] == null ? false : true;
        }

        public void add(long number)
        {
            if (!isListExists(number))
            {
                _array[(int) Hash(number)] = new LinkedList<Long>();
                _array[(int) Hash(number)].addFirst(number);
            }
            else
            {
                if (!find(number,true))
                {
                    _array[(int) Hash(number)].addFirst(number);
                }
            }

        }

        public boolean find(final long number, boolean isListChecked)
        {
            if (isListChecked || isListExists(number))
            {
                return _array[(int) Hash(number)].contains(number);
            }
            return false;
        }

        public void delete(long number)
        {
            if (find(number, false))
            {
                _array[(int) Hash(number)].removeFirstOccurrence(number);
            }
        }
    }
}
