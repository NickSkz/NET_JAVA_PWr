using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Threading;

namespace MainApp
{
    class Timer
    {
        //Fields: seconds, flag which determines whether run() is working, TextBox - passed from UI (where data is displayed)
        public int seconds { get; set; }
        public Boolean isON { get; set; }
        public TextBox associatedTextBox { get; set; }

        //Pass flag + textbox
        public Timer(Boolean isON, TextBox textBox) => (this.isON, this.associatedTextBox ) = (isON, textBox);

        //Increment every second, use handler to deliver message to the UI thread
        public void run()
        {
            while (isON)
            {
                seconds += 1;
                
                Application.Current.Dispatcher.Invoke((Action)(() =>
                {
                    associatedTextBox.Text = "Seconds: " + seconds.ToString();
                }));

                Thread.Sleep(1000);
            }

        }

        //Show object in a nice form
        public override string ToString() => "Seconds: " + seconds.ToString();
    }
}
