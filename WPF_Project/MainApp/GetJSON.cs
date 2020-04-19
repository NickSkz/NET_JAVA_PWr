using System;
using System.Collections.Generic;
using System.Net;
using System.Text;

namespace JsonProcessing
{
    class GetJSON
    {
        public static String getData()
        {
            var client = new WebClient();
            return client.DownloadString("https://api.thevirustracker.com/free-api?countryTotal=PL");
        }
    }
}
