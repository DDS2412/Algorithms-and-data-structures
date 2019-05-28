using System;

class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        Int64[] febonache = new Int64[n+1];
        febonache[0] = 0; febonache[1] = 1;
        for (int i = 2; i <= n; i++) febonache[i] = febonache[i - 1] + febonache[i - 2];

        Console.WriteLine(febonache[n]);
    }
}
