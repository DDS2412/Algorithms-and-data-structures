using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace Week9
{
    class Task2
    {
        static void Main(string[] args)
        {
            using (StreamWriter sw = new StreamWriter("output.txt"))
            {
                string text =  File.ReadAllText("input.txt").Replace(" ", string.Empty);

                if(text.Length < 3)
                {
                    sw.WriteLine("0");
                }
                else
                {
                    var rightDictionary = text
                        .GroupBy(s => s)
                        .ToDictionary(s => s.Key, s => new Symbol(0, s.Count()));

                    var leftDictionary = new Dictionary<char, Symbol>();

                    long totalCount = 0;
                    for(int i = 0; i < text.Length; i++)
                    {
                        char curSymbol = text[i];
                        Symbol symbol = rightDictionary[curSymbol];
                        symbol.rightEntry--;

                        foreach(var entry in leftDictionary)
                        {
                            totalCount += entry.Value.NumbersPalindromes;
                        }
                        symbol.leftEntry++;
                        leftDictionary[curSymbol] = symbol;
                    }

                    sw.WriteLine(totalCount);
                }
            }
        }

        private class Symbol
        {
            public long leftEntry, rightEntry;

            public Symbol(long leftEntry, long rightEntry)
            {
                this.leftEntry = leftEntry;
                this.rightEntry = rightEntry;
            }

            public long NumbersPalindromes { get => this.leftEntry * this.rightEntry;  }
        }
    }
}
