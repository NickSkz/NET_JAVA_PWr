using System;
using System.Collections.Generic;
using System.Text;
using System.Collections;

namespace JsonProcessing
{
    //Class with consts containing URL to specific country's data
    static class CountryJsonLink
    {
        //Dictionary Button Name - Adress - created to dispose of redundant onClick methods
        public static readonly Dictionary<string, string> abbreviationMap = new Dictionary<string, string>()
        {
            { "Poland", addrPL },
            { "Germany", addrDE },
            { "Czechia", addrCZ },
            { "Slovakia", addrSK },
            { "Ukraine", addrUA },
            { "Belarus", addrBY },
            { "Lithuania", addrLT },
            { "Russia", addrRU },
        };

        public const String addrPL = "https://api.thevirustracker.com/free-api?countryTotal=PL";
        public const String addrDE = "https://api.thevirustracker.com/free-api?countryTotal=DE";
        public const String addrCZ = "https://api.thevirustracker.com/free-api?countryTotal=CZ";
        public const String addrSK = "https://api.thevirustracker.com/free-api?countryTotal=SK";
        public const String addrUA = "https://api.thevirustracker.com/free-api?countryTotal=UA";
        public const String addrBY = "https://api.thevirustracker.com/free-api?countryTotal=BY";
        public const String addrLT = "https://api.thevirustracker.com/free-api?countryTotal=LT";
        public const String addrRU = "https://api.thevirustracker.com/free-api?countryTotal=RU";

    }
}
