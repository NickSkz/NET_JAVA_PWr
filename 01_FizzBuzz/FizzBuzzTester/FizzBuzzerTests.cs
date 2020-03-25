using NUnit.Framework;
using System.Collections.Generic;
using FizzBuzz;
using System;

namespace FizzBuzzTester
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }


        //Test specified for verifying especially Fizz detection.
        [Test]
        public void FizzTest()
        {
            List<int> numbers = new List<int>() { 3, 6, 9, 12 };
            List<string> expectedResults = new List<string>() { "Fizz", "Fizz", "Fizz", "Fizz" };
            var actualResluts = FizzBuzzer.Fizzbuzinho(numbers);
            CollectionAssert.AreEqual(expectedResults, actualResluts);
        }

        //Test specified for verifying especially Buzz detection.
        [Test]
        public void BuzzTest()
        {
            List<int> numbers = new List<int>() { 1, 5, 10, 52, 61, 559 };
            List<string> expectedResults = new List<string>() { "1", "Buzz", "Buzz", "Buzz", "61", "Buzz" };
            var actualResluts = FizzBuzzer.Fizzbuzinho(numbers);
            CollectionAssert.AreEqual(expectedResults, actualResluts);
        }

        //Test specified for verifying especially Buzzinga detection.
        [Test]
        public void BuzzingaTest()
        {
            List<int> numbers = new List<int>() { 5, 7, 15, 21, 24, 35, 40, 105, 231, 551, 700 };
            List<string> expectedResults = new List<string>() { "Buzz", "Buzzinga", "FizzBuzz", "Buzzinga", "Fizz", 
                "Buzzinga", "Buzz", "Buzzinga", "Buzzinga", "Buzz", "Buzzinga" };
            CollectionAssert.AreEqual(expectedResults, FizzBuzzer.Fizzbuzinho(numbers));
        }

        //Test specified for verifying especially FizzBuzz detection.
        [Test]
        public void FizzBuzzTest()
        {
            List<int> numbers = new List<int>() { 5, 7, 15, 24, 30, 31, 45, 335, 357, 359, 514, 533, 124351};
            List<string> expectedResults = new List<string>() { "Buzz", "Buzzinga", "FizzBuzz", "Fizz", "FizzBuzz", "31", 
                "FizzBuzz", "FizzBuzz", "Buzzinga", "FizzBuzz", "Buzz", "FizzBuzz", "FizzBuzz"};
            CollectionAssert.AreEqual(expectedResults, FizzBuzzer.Fizzbuzinho(numbers));
        }


        //Main, more realistic Test for the method.
        [Test]
        public void TestAlle()
        {
            List<int> exampleNumbers = new List<int>()
            {
                0, 1, 4, 5, 15, 2, 30, 52, 414,
                13452, 63166, 7272, 4263635, 777777777, 530021
            };

            List<string> expectedRes = new List<string>()
            {
                "Buzzinga", "1", "4", "Buzz", "FizzBuzz", "2", "FizzBuzz", "Buzz", "Fizz",
                "Buzz", "63166", "Fizz", "FizzBuzz", "Buzzinga", "FizzBuzz"
            };

            Assert.AreEqual(expectedRes, FizzBuzzer.Fizzbuzinho(exampleNumbers));
        }

        //Test if exception is thrown after sending null to the method
        [Test]
        public void testNullList()
        {
            Assert.Throws<NullReferenceException>(() => FizzBuzzer.Fizzbuzinho(null));
        }
    }
}