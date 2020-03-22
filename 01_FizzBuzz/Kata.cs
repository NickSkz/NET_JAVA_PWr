using System;
using System.Text;
using System.Numerics;
using System.Collections.Generic;

public class Kata
{

    //Sollution code to 4kyu Kata: https://www.codewars.com/kata/525f4206b73515bffb000b21/csharp
    public static string Add(string a, string b)
    {
        return (BigInteger.Parse(a) + BigInteger.Parse(b)).ToString();
    }



    //Sollution code to 6kyu Kata: https://www.codewars.com/kata/54b42f9314d9229fd6000d9c
    public static string DuplicateEncode(string word)
    {
        var wasThereMap = new Dictionary<char, int>();
        StringBuilder outputStr = new StringBuilder("");

        foreach (var item in word)
        {
            if (wasThereMap.ContainsKey(Char.ToLower(item)))
            {
                ++wasThereMap[Char.ToLower(item)];
            }
            else
            {
                wasThereMap.Add(Char.ToLower(item), 1);
            }
        }

        foreach (var item in word)
        {
            if (wasThereMap[Char.ToLower(item)] > 1)
                outputStr.Append(")");
            else
                outputStr.Append("(");
        }

        return outputStr.ToString();
    }



    //Sollution code to 6kyu Kata: https://www.codewars.com/kata/5ce399e0047a45001c853c2b
    public static int[] PartsSums(int[] ls)
    {
        int[] sumsArray = new int[ls.Length + 1];

        int sum = 0;
        foreach (var item in ls)
        {
            sum += item;
        }

        for (int i = 0; i < sumsArray.Length; ++i)
        {
            sumsArray[i] = sum;
            if (i < sumsArray.Length - 1)
                sum -= ls[i];
        }

        return sumsArray;
    }



    //Sollution code to 6kyu Kata: https://www.codewars.com/kata/541c8630095125aba6000c00/csharp
    public int DigitalRoot(long n)
    {
        if (n.ToString().Length == 1)
            return (int)n;

        String strN = n.ToString();
        int sum = 0;
        foreach (var item in strN)
        {
            sum += (int)Char.GetNumericValue(item);
        }

        return DigitalRoot(sum);
    }


}
