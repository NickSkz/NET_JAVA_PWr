using System;
using System.Collections.Generic;
using System.Net;
using System.Text;

/*Nuget Packages*/
using Newtonsoft.Json;

namespace JsonProcessing
{
    class GetJSON
    {
        public static String getData(string desiredCountry)
        {
            //use WebClient object (recieve data from URL),
            using (var client = new WebClient())
            {
                //Get raw JSON, Deserialize it into object
                String trueJson = client.DownloadString(desiredCountry);
                JsonObject countryInfo = JsonConvert.DeserializeObject<JsonObject>(trueJson);
                return (Convert.ToString(countryInfo.countrydata[0].total_cases));

            }
        }
    }
}
