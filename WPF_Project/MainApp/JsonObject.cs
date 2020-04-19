using System;
using System.Collections.Generic;
using System.Text;

namespace JsonProcessing
{
    //Format defined by API - coutry data is the key to all of this
    class JsonObject
    {
        public List<CountryInfo> countrydata { get; set; }
        public String stat { get; set; }
    }
}
