using Syncfusion.UI.Xaml.Charts;
using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace MainApp
{
    /// <summary>
    /// Logika interakcji dla klasy wykres.xaml
    /// </summary>
    public partial class wykres : Window
    {
        
        public wykres()
        {
            InitializeComponent();
        }

        private void btnClick(object sender, RoutedEventArgs e)
        {
            DataBaseProcessing.HistoricalDataDBContext  db = DataBaseProcessing.DbAction.getData();
            foreach (var data in db.Datas)
            {
                dane.Content += data.Total_active_cases.ToString() + "  ";
                ViewModel.Dodajrecord(data.Date, data.Total_active_cases, data.Total_new_cases_today);
            }
            
        }
    }
}
