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

        ViewModel obj;

        public wykres()
        {
            InitializeComponent();
            obj = new ViewModel();
            DataContext = obj;
        }

        private void btnClick(object sender, RoutedEventArgs e)
        {
            obj.Data[0].Total_new_cases = 200;
            
        }
        
    }
}
