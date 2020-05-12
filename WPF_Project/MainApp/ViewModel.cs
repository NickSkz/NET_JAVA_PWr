using Syncfusion.UI.Xaml.Charts;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Runtime.CompilerServices;
using System.Text;

namespace MainApp
{
    class ViewModel
    {
        public ObservableCollection<Sales> Data { get; set; }
        public ViewModel()
        {
            Data = new ObservableCollection<Sales>()
            {
                new Sales { Date=new DateTime(2008, 6, 1, 7, 47, 0), Total_active_cases=201, Total_new_cases=100},
                new Sales { Date=new DateTime(2009, 6, 1, 7, 47, 0), Total_active_cases=301, Total_new_cases=100},
                new Sales { Date=new DateTime(2010, 6, 1, 7, 47, 0), Total_active_cases=501, Total_new_cases=200},
            };
        }

       

        //public static void Dodajrecord(DateTime date, int active_cases, int new_cases)
        //{
        /*= new List<Sales>
    {
        new Sales {Date = new DateTime(2012, 6, 1, 7, 47, 0), Total_active_cases = 501, Total_new_cases = 200 },
        new Sales {Date = new DateTime(2017, 6, 1, 7, 47, 0), Total_active_cases = 201, Total_new_cases = 100 },
        new Sales {Date = new DateTime(2020, 6, 1, 7, 47, 0), Total_active_cases = 201, Total_new_cases = 50 },
        new Sales {Date = new DateTime(2023, 6, 1, 7, 47, 0), Total_active_cases = 501, Total_new_cases = 0 },
    };*/

        //}
    }
}
