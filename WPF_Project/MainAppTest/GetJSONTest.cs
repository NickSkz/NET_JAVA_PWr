using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

using JsonProcessing;
using System.Net;
using Newtonsoft.Json;

namespace MainAppTest
{
    class GetJSONTest
    {
        [SetUp]
        public void Setup()
        {

        }

        //Test that verifies whether URL for specific country changed, or is unavalible.
        [Test]
        public void GetCountryLinkTest()
        {
            Assert.AreEqual("Poland", GetJSON.GetData(CountryJsonLink.addrPL).countrydata[0].info.title);
            Assert.AreEqual("Germany", GetJSON.GetData(CountryJsonLink.addrDE).countrydata[0].info.title);
            Assert.AreEqual("Czechia", GetJSON.GetData(CountryJsonLink.addrCZ).countrydata[0].info.title);
            Assert.AreEqual("Slovakia", GetJSON.GetData(CountryJsonLink.addrSK).countrydata[0].info.title);
            Assert.AreEqual("Ukraine", GetJSON.GetData(CountryJsonLink.addrUA).countrydata[0].info.title);
            Assert.AreEqual("Belarus", GetJSON.GetData(CountryJsonLink.addrBY).countrydata[0].info.title);
            Assert.AreEqual("Lithuania", GetJSON.GetData(CountryJsonLink.addrLT).countrydata[0].info.title);
            Assert.AreEqual("Russia", GetJSON.GetData(CountryJsonLink.addrRU).countrydata[0].info.title);
        }


        //Test that verifies if GetData() deserializes info from JSON in the desired way.
        [Test]
        public void GetCountryInfoTest()
        {
            JsonObject countryInfo;

            //Dispose WebClient resource immediately  
            using (var client = new WebClient())
            {
                String trueJson = client.DownloadString(CountryJsonLink.addrDE);
                countryInfo = JsonConvert.DeserializeObject<JsonObject>(trueJson);
            }

            Assert.AreEqual(countryInfo, GetJSON.GetData(CountryJsonLink.addrDE));
        }
    }
}
