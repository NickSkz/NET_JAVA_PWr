using NUnit.Framework;
using System.Collections.Generic;
using FizzBuzz;

namespace FizzBuzzTester
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void FizzBuzzTest()
        {
            List<int> exampleNumbers = new List<int>()
            {
                0, 1, 4, 5, 15, 2, 30, 52, 513,
                13452, 63166, 7272, 4263635, 777777777
            };

            List<string> expectedRes = new List<string>()
            {
                "FizzBuzz", "1", "4", "Buzz", "FizzBuzz", "2", "FizzBuzz", "52", "Fizz",
                "Fizz", "63166", "Fizz", "Buzz", "Fizz"
            };

            Assert.AreEqual(expectedRes, FizzBuzzer.Fizzbuzinho(exampleNumbers));
        }
    }
}