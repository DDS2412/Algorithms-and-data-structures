using System;
using System.IO;
using System.Linq;
using System.Text;

namespace Task2
{
    public class Task2
    {
        private static int[] countingArr = new int[130];
        private static int[] resIndexs;

        static void Main(string[] args)
        {
            Solve();
        }

        private static void Solve()
        {
            using (var output = new StreamWriter("output.txt"))
            {
                string[] stdin = File.ReadAllLines("input.txt");

                int[] parameters = stdin[0].Split(' ').Select(x => int.Parse(x)).ToArray();

                resIndexs = RadixSort(stdin, Enumerable.Range(0, parameters[0] + 1).ToArray(), parameters[0], parameters[1], parameters[2]);           

                StringBuilder st = new StringBuilder();
                for (int i = 1; i < resIndexs.Length; i++)
                {
                    st.Append(resIndexs[i]);
                    st.Append(" ");
                }

                output.Write(st);
            }
        }

        private static int[] RadixSort(string[] array, int[] indexes, int n, int m, int k)
        {
            for (int i = 0; i < k; i++)
            {
                resIndexs = new int[indexes.Length];
                indexes = SortCounting(array, indexes, m - i);

                resIndexs = null;

                if (i % 100000 == 0)
                    GC.Collect();
            }

            return indexes;
        }

        private static int[] SortCounting(string[] array, int[] indexes, int phase)
        {
            for (int i = 0; i < countingArr.Length; i++)
            {
                countingArr[i] = 0;
            }

            for (int i = 0; i < array[phase].Length; i++)
                countingArr[array[phase][i]]++;
            for (int i = 98; i <= 125; i++)
                countingArr[i] += countingArr[i - 1];

            int charValue, countedIndex;

            for (int i = array[phase].Length; i > 0; i--)
            {
                charValue = array[phase][indexes[i] - 1];
                countedIndex = countingArr[charValue];
                resIndexs[countedIndex] = indexes[i];
                countingArr[charValue]--;
            }

            return resIndexs;
        }
    }
}
