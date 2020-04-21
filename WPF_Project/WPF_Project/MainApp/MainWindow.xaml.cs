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


namespace MainApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            //log.Info("Hello There!");
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
    }
}
