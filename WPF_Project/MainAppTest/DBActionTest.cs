using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

using JsonProcessing;

namespace MainAppTest
{
    class DBActionTest
    {
        [SetUp]
        public void Setup()
        {

        }

        [Test]
        public void WrongLinkTest()
        {
            Assert.AreEqual("DB can only contain data from Poland :(", DataBaseProcessing.DbAction.putIntoDB("Efewfwefwfwefwe"));
            Assert.AreEqual("DB can only contain data from Poland :(", DataBaseProcessing.DbAction.putIntoDB(CountryJsonLink.addrBY));
            Assert.AreEqual("DB can only contain data from Poland :(", DataBaseProcessing.DbAction.putIntoDB(CountryJsonLink.addrRU));
            Assert.AreNotEqual("DB can only contain data from Poland :(", DataBaseProcessing.DbAction.putIntoDB(CountryJsonLink.addrPL));
        }


    }
}
