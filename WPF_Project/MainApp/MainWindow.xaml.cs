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
            List<String> vec = new List<String>{
                CountryJsonLink.addrPL,
                CountryJsonLink.addrDE,
                CountryJsonLink.addrCZ,
                CountryJsonLink.addrSK,
                CountryJsonLink.addrUA,
                CountryJsonLink.addrBY,
                CountryJsonLink.addrLT,
                CountryJsonLink.addrRU,
            };

            Random rndCountry = new Random();
            GetJSON.GetData(vec[rndCountry.Next(0, 8)]);
        }
    }
}
