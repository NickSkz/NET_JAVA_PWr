using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net;
using System.Text;

using LoggerSpace;

/*Nuget Packages*/
using Newtonsoft.Json;

namespace JsonProcessing
{
    class GetJSON
    {
        public static JsonObject GetData(string desiredCountry)
        {
            //use WebClient object (recieve data from URL),
            var client = new WebClient();
            //Get raw JSON, Deserialize it into object
            String trueJson = client.DownloadString(desiredCountry);

            JsonObject countryInfo;

            try
            {
                countryInfo = JsonConvert.DeserializeObject<JsonObject>(trueJson);
            }
            catch(Exception e)
            {
                countryInfo = null;
                Logger.log.Error(e.Message);
            };

            return countryInfo;
        }
    }
}
