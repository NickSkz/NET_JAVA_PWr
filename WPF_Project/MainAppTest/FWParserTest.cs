using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace MainAppTest
{
    class FWParserTest
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void Top10ListTest()
        {
            FWMovieParser.FWParser.getHtml();
            Assert.AreEqual(10, FWMovieParser.FWParser.top10Movies.Count);
        }

        [Test]
        public void RankingTest()
        {
            FWMovieParser.FWParser.getHtml();
            Assert.AreEqual(true, FWMovieParser.FWParser.top10Movies[2].Contains('3'));
            Assert.AreEqual(true, FWMovieParser.FWParser.top10Movies[6].Contains('7'));
            Assert.AreEqual(true, FWMovieParser.FWParser.top10Movies[8].Contains('9'));
        }

    }
}
