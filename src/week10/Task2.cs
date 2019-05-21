using System;
using System.IO;

namespace Week10
{
    class Task2
    {
        static void Main2(string[] args)
        {
            using (StreamWriter sw = new StreamWriter("output.txt"))
            {
                string[] inputString = File.ReadAllLines("input.txt");
                int[] zFunction = getZFunction(inputString[0]);

                for (int i = 1; i < zFunction.Length; i++)
                {
                    sw.Write(zFunction[i] + " ");
                }
            }
        }

        private static int[] getZFunction(String text)
        {
            var lenght = text.Length;
            var zFunction = new int[lenght];

            for(int i = 1, l = 0, r = 0; i  < lenght; i++)
            {
                if(i <= r)
                {
                    zFunction[i] = Math.Min(r - i + 1, zFunction[i - l]);
                }
                while(i+zFunction[i] < lenght && text[zFunction[i]] == text[i+ zFunction[i]]) { zFunction[i]++; }
                if(i + zFunction[i] - 1 > r)
                {
                    l = i;
                    r = i + zFunction[i] - 1;
                }
            }

            return zFunction;
        }
    }
}
