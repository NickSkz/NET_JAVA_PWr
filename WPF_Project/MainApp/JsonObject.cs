using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace JsonProcessing
{
    //Format defined by API - coutry data is the key to all of this
    class JsonObject
    {
        public List<CountryInfo> countrydata { get; set; }
        public String stat { get; set; }

        //Override hashcode + equals to compare elements 
        public override bool Equals(Object obj)
        {
            if (obj == null)
                return false;

            JsonObject other = (JsonObject)obj;

            if (!countrydata.SequenceEqual(other.countrydata)) 
                return false;
            if (!stat.Equals(other.stat))
                return false;

            return true;
        }

        public override int GetHashCode() => HashCode.Combine(countrydata, stat);
    }
}
