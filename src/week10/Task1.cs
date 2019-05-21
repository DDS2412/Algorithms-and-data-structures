using System;
using System.IO;

namespace Week10
{
    class Task1
    {
        static void Mzin1(string[] args)
        {
            using (StreamWriter sw = new StreamWriter("output.txt"))
            {
                string[] inputString = File.ReadAllLines("input.txt");
                int[] prefixFunction = getPrefixFunction(inputString[0]);

                for (int i = 0; i < prefixFunction.Length; i++)
                {
                    sw.Write(prefixFunction[i] + " ");
                }
            }
        }

        private static int[] getPrefixFunction(String text)
        {
            var prefixFunction = new int[text.Length]; 

            for (int i = 1; i < text.Length; i++)
            {
                int j = prefixFunction[i - 1]; //текущая длина префикса, который мы хотим продолжить
                 
                while (j > 0 && text[i] != text[j]) //пока мы не можем продолжить текущий префикс
                {
                    j = prefixFunction[j - 1]; //уменьшаем его длину до следующей возможной
                }

                //Теперь j - максимальная длина префикса, который мы можем продолжить,
                //или 0, если такового не существует.
                if (text[i] == text[j])
                {
                    prefixFunction[i] = j + 1;
                }
                else
                {
                    prefixFunction[i] = j;
                }
            }
            return prefixFunction;
        }
    }
}
