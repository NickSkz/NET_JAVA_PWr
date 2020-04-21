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
            JsonObject countryInfo = JsonConvert.DeserializeObject<JsonObject>(trueJson);

            //Show in logs basic data
            Logger.log.Info("Country: " + countryInfo.countrydata[0].info.title);
            Logger.log.Info("New Cases Today: " + countryInfo.countrydata[0].total_new_cases_today);
            Logger.log.Info("New Deaths Today: " + countryInfo.countrydata[0].total_new_deaths_today);
            Logger.log.Info("Total Cases: " + countryInfo.countrydata[0].total_cases);
            Logger.log.Info("Total Deaths: " + countryInfo.countrydata[0].total_deaths);

            return countryInfo;
        }
    }
}
