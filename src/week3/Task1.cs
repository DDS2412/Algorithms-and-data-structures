using System;
using System.IO;
using System.Linq;

namespace Task1
{
    public class Program
    {
        private const int w = 32;
        private const int d = 8;

        static void Main(string[] args)
        {
            Solve();
        }

        private static void Solve()
        {
            int[] mainArr;
            using (var input = new StreamReader("input.txt"))
            {
                int[] arr1;

                int mArrItem;

                var argArr = input.ReadLine().Split(' ').Select(t => int.Parse(t)).ToArray();

                arr1 = input.
                    ReadLine().
                    Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).
                    Select(t => int.Parse(t)).
                    ToArray();

                GC.Collect();

                mainArr = new int[argArr[0] * argArr[1]];

                var t2 = input.ReadLine().Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                for (int i = 0, counter = 0; i < argArr[0] * argArr[1]; i+= argArr[0], counter++)
                {
                    mArrItem = int.Parse(t2[counter]);

                    for(int j = 0; j < argArr[0]; j++)
                    {
                        mainArr[i + j] = mArrItem * arr1[j];
                    }   
                }
                t2 = null;
                arr1 = null;

                GC.Collect();
            }

            using (var output = new StreamWriter("output.txt"))
            {
                GC.Collect();
                output.WriteLine(radixSort(mainArr));
            }

        }

        private static long radixSort(int[] a)
        {
            int[] b = null;

            long sum = 0;
            for (int p = 0; p < w / d; p++)
            { 
                int[] c = new int[1 << d];
                // the next three for loops implement counting-sort
                b = new int[a.Length];
                for (int i = 0; i < a.Length; i++)
                    c[(a[i] >> d * p) & ((1 << d) - 1)]++;
                for (int i = 1; i < 1 << d; i++)
                    c[i] += c[i - 1];
                for (int i = a.Length - 1; i >= 0; i--)
                {
                    b[--c[(a[i] >> d * p) & ((1 << d) - 1)]] = a[i];
                }

                a = b;

                GC.Collect();
            }

            for (int i = 0; i < a.Length; i += 10)
            {
                sum += b[i];
            }

            return sum;
        }
    }
}
