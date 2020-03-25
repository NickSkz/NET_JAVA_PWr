using System;
using System.Collections.Generic;
using System.Text;

namespace FizzBuzz
{
    public class FizzBuzzer
    {

        //Method that checks if 5 and 3 are "sticked" to each other in the number
        private static Boolean threeFiveNeighbour(int item)
        {
            String stringItem = item.ToString();

            for(int i = 0; i < stringItem.Length - 1; ++i)
            {
                if((stringItem[i]  == '5' && stringItem[i + 1] == '3') || (stringItem[i] == '3' && stringItem[i + 1] == '5'))
                {
                    return true;
                }
            }

            return false;
        }

       
        //Method that verifies whether desired character (digit) appears in the number
        private static Boolean checkIfDesiredCharacter(int item, Char c)
        {
            String stringItem = item.ToString();

            foreach(var charac in stringItem)
            {
                if (charac.Equals(c))
                    return true;
            }
            
            return false;
        }
            

        //Main method, desribed in the 2nd part of lab's instruction
        public static List<String> Fizzbuzinho(List<int> listInt)
        {
            List<String> strLst = new List<String>();

            if(listInt == null)
            {
                throw new NullReferenceException("Int Array not provided for the method!");
            }

            foreach(var item in listInt)
            {
                if (item % 7 == 0)
                    strLst.Add("Buzzinga");
                else
                {
                    if (item % 15 == 0 || threeFiveNeighbour(item))
                    {
                        strLst.Add("FizzBuzz");
                    }
                    else if (item % 5 == 0 || checkIfDesiredCharacter(item, '5'))
                    {
                        strLst.Add("Buzz");
                    }
                    else if (item % 3 == 0)
                    {
                        strLst.Add("Fizz");
                    }
                    else
                    {
                        strLst.Add(item.ToString());
                    }
                }
            }

            return strLst;
        }
    }
}
