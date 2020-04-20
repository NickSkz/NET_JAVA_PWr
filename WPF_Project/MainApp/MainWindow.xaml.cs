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
using System.Numerics;

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

        //Timer Thread
        Thread timerThread;

        public MainWindow()
        {
            InitializeComponent();

            //Set flag
            isRunning = true;
            Logger.log.Info("Hello There!");

            //create timer
            secondsTimer = new Timer(isRunning, TimerTextBox) ;

            //Run the timer loop on another thread, delegate - quasi pointer to function
            ThreadStart timerThreadStart = delegate { secondsTimer.run(); };
            timerThread = new Thread(timerThreadStart);
            timerThread.Start();
        }


        //TEMPORARY - Analyze random country's data
        private void Button_Click(object sender, RoutedEventArgs e)
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

            Logger.log.Info("-_______-");
            JsonTextBox.Text = GetJSON.GetData(vec[rndCountry.Next(0, 8)]).countrydata[0].info.title;
        }

        protected override void OnClosed(EventArgs e)
        {
            //Stop timer's run loop
            isRunning = false;
            secondsTimer.isON = isRunning;

            //TODO : EXTREMELY DANGEROUS PIECE OF CODE
            //THIS IS TEMPORARY SOLUTION
            //PROBLEM: Timer thread wants to execute UI Dispatcher even though its already gone (Timer thread closes after UI Thread)
            Thread.Sleep(300);

            base.OnClosed(e);
        }
    }
}
