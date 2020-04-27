using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

using log4net;

using JsonProcessing;
using LoggerSpace;
using DataBaseProcessing;

using System.Threading;

namespace MainApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        //isRunning flag + Timer - that's executed on another thread
        Boolean isRunning;
        Timer secondsTimer;


        public MainWindow()
        {
            InitializeComponent();

            //Set flag
            isRunning = true;
            Logger.log.Info("Hello There!");
        }


        private void btnOknoObl(object sender, RoutedEventArgs e)
        {
            Obliczenia nowosc = new Obliczenia();
            nowosc.ShowDialog();
        }
        private void btnOknoWykr(object sender, RoutedEventArgs e)
        {
            wykres nowosc = new wykres();
            nowosc.ShowDialog();
        }


        protected override void OnClosed(EventArgs e)
        {
            isRunning = false;

            //TODO : EXTREMELY DANGEROUS PIECE OF CODE
            //THIS IS TEMPORARY SOLUTION
            //PROBLEM: Timer thread wants to execute UI Dispatcher even though its already gone (Timer thread closes after UI Thread)
            Thread.Sleep(300);

            base.OnClosed(e);
        }

        private void logCountryInfo(object sender, RoutedEventArgs e)
        {
            DbAction.putIntoDB(CountryJsonLink.addrPL);
            DbAction.showFromDB();
        }

        //On Country button click
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            //Write Category Label only once - dont waste resources
            if(leftLabel.Content.Equals(""))
                showCategories();

            //Use query to get desired country based, on button content
            Button btnClicked = (Button)sender;
            JsonObject countryJSON = GetJSON.GetData(string.Join(",", CountryJsonLink.abbreviationMap.Where(n => n.Key.Equals(btnClicked.Content)).Select(n => n.Value).ToArray()));

            //Write all the data from API
            rightLabel.FontWeight = FontWeight.FromOpenTypeWeight(150);
            rightLabel.Content = countryJSON.countrydata[0].info.title + "\n" +
                                countryJSON.countrydata[0].total_new_cases_today + "\n" +
                                countryJSON.countrydata[0].total_new_deaths_today + "\n" +
                                countryJSON.countrydata[0].total_cases + "\n" +
                                countryJSON.countrydata[0].total_deaths + "\n" +
                                countryJSON.countrydata[0].total_unresolved + "\n" +
                                countryJSON.countrydata[0].total_recovered + "\n" +
                                countryJSON.countrydata[0].total_active_cases + "\n" +
                                countryJSON.countrydata[0].total_serious_cases + "\n" +
                                countryJSON.countrydata[0].total_danger_rank + "\n";

        }

        //Show categories of data
        private void showCategories()
        {
            leftLabel.FontWeight = FontWeight.FromOpenTypeWeight(400);
            leftLabel.Content = "Country: \n" +
                                "New Cases Today: \n" +
                                "New Deaths Today: \n" +
                                "Total Cases: \n" +
                                "Total Deaths: \n" +
                                "Total Unresolved Cases: \n" +
                                "Total Recovered: \n" +
                                "Total Active Cases: \n" +
                                "Total Serious Cases: \n" +
                                "Total Danger Rank: ";
        }
    }
}
