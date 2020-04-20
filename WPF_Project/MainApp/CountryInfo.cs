using System;
using System.Collections.Generic;
using System.Text;

namespace JsonProcessing
{
    //Format defined by JSON file
    class CountryInfo
    {
        //Info used by external web service
        public Info info { get; set; }

        //Main data about country
        public int total_cases { get; set; }
        public int total_recovered { get; set; }
        public int total_unresolved { get; set; }
        public int total_deaths { get; set; }
        public int total_new_cases_today { get; set; }
        public int total_new_deaths_today { get; set; }
        public int total_active_cases { get; set; }
        public int total_serious_cases { get; set; }
        public int total_danger_rank { get; set; }

        //Internal class to read data used by web service
        public class Info
        {
            public int ourid { get; set; }
            public string title { get; set; }
            public string code { get; set; }
            public string source { get; set; }

            //Override hashcode + equals to compare elements 
            public override bool Equals(object obj)
            {
                if (obj == null)
                    return false;

                Info other = (Info)obj;

                if (!ourid.Equals(other.ourid))
                    return false;
                if (!title.Equals(other.title))
                    return false;
                if (!code.Equals(other.code))
                    return false;
                if (!source.Equals(other.source))
                    return false;

                return true;
            }

            public override int GetHashCode() => HashCode.Combine(ourid, title, code, source);

        }

        //Override hashcode + equals to compare elements 
        public override bool Equals(object obj)
        {
            if (obj == null)
                return false;

            CountryInfo other = (CountryInfo)obj;

            if (!info.Equals(other.info))
                return false;
            if (!total_recovered.Equals(other.total_recovered))
                return false;
            if (!total_unresolved.Equals(other.total_unresolved))
                return false;
            if (!total_deaths.Equals(other.total_deaths))
                return false;
            if (!total_new_cases_today.Equals(other.total_new_cases_today))
                return false;
            if (!total_new_deaths_today.Equals(other.total_new_deaths_today))
                return false;
            if (!total_active_cases.Equals(other.total_active_cases))
                return false;
            if (!total_serious_cases.Equals(other.total_serious_cases))
                return false;
            if (!total_danger_rank.Equals(other.total_danger_rank))
                return false;

            return true;
        }

        public override int GetHashCode() => HashCode.Combine(
            total_recovered, total_unresolved, total_deaths,
            total_new_cases_today, total_new_deaths_today, total_active_cases,
            total_serious_cases, total_danger_rank
            );
 
    }
}
