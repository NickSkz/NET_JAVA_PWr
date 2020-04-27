using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Text;

using JsonProcessing;
using LoggerSpace;

using System.Linq;

namespace DataBaseProcessing
{

    //Model database single object
    public class HistoricalData
    {
        public int Id { get; set; }
        public DateTime Date { get; set; }
        public string Name { get; set; }
        public int Total_active_cases { get; set; }    //FROM YESTERDAY!!! - total_active_cases - total_new_cases_today
        public int Total_new_cases_today { get; set; } //FRO YESTERDAY!!! - total_active cases - total_active_cases_from_last_record (the day before)


        public override string ToString()
        {
            return $"Record Id: {Id}, Date: {Date}, Name: {Name}," +
                $" Total Active Cases: {Total_active_cases}, Total New Cases Today {Total_new_cases_today}";
        }

    }

    //Create DbContext
    public class HistoricalDataDBContext : DbContext
    {
        public DbSet<HistoricalData> Datas { get; set; }
    }


    //Perform action connected with DB
    public class DbAction
    {
        //Insert record
        public static void putIntoDB(string countryAddr)
        {
            //Assumption: Only data form PL
            if (!countryAddr.Equals(CountryJsonLink.addrPL))
            {
                Logger.log.Error("DB can only contain data from Poland :(");
                return;
            }

            JsonObject countryPL = GetJSON.GetData(countryAddr);

            //Create new data object
            var todayPoland = new HistoricalData
            {
                Date = DateTime.Now,
                Name = countryPL.countrydata[0].info.title,
                Total_active_cases = countryPL.countrydata[0].total_active_cases - countryPL.countrydata[0].total_new_cases_today, //Take from yesterday
                Total_new_cases_today = countryPL.countrydata[0].total_new_cases_today

            };

            //Perform on DB
            using (var db = new HistoricalDataDBContext())
            {
                var record = db.Datas.OrderByDescending(n => n.Id).FirstOrDefault();

                //If Table == empty add first
                if(record == null)
                {
                    db.Datas.Add(todayPoland);
                    db.SaveChanges();
                    return;
                }

                //Insert only if data from the following day does not exist
                if (!record.Date.Date.Equals(DateTime.Now.Date))
                {
                    db.Datas.Add(todayPoland);
                    db.SaveChanges();
                }
            }
        }

        //Show with the help of overridden ToString()
        public static void showFromDB()
        {
            using (var db = new HistoricalDataDBContext())
            {
                foreach (var data in db.Datas)
                {
                    Logger.log.Info(data);
                }
            }
        }

    }
    
}

