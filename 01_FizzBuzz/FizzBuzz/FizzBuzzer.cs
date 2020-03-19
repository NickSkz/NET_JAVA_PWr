using System;
using System.Collections.Generic;
using System.Text;

namespace FizzBuzz
{
    public class FizzBuzzer
    {
        public static List<String> Fizzbuzinho(List<int> listInt)
        {
            List<String> strLst = new List<String>();

            foreach(var item in listInt)
            {
                if(item % 15 == 0)
                {
                    strLst.Add("FizzBuzz");
                }
                else if(item % 3 == 0)
                {
                    strLst.Add("Fizz");
                }
                else if(item % 5 == 0)
                {
                    strLst.Add("Buzz");
                }
                else
                {
                    strLst.Add(item.ToString());
                }
            }

            return strLst;
        }
    }
}
