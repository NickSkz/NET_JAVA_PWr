using System;

namespace FizzBuzz
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                FizzBuzzer.Fizzbuzinho(null);
            }
            catch(NullReferenceException e)
            {
                Console.WriteLine(e);
            }
        }
    }
}
