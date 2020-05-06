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
using JsonProcessing;
using System.Text.RegularExpressions;

namespace MainApp
{
    /// <summary>
    /// Logika interakcji dla klasy Obliczenia.xaml
    /// </summary>
    public partial class Obliczenia : Window
    {
        private String Country;
        public Obliczenia()
        {
            InitializeComponent();
        }


        private void btn_count(object sender, RoutedEventArgs e)
        {
            int NumOfP= Int32.Parse(perDay.Text); // liczba ludzi spotykanych jednego dnia
            //int PerInContry;
            JsonObject CountryData = GetJSON.GetData(Country);
            int TotalCases= CountryData.countrydata[0].total_cases;
            Chance.Content = TotalCases/NumOfP;

        }
        private static readonly Regex _regex = new Regex("[^0-9.-]+"); //regex that matches disallowed text
        private static bool IsTextAllowed(string text)
        {
            return !_regex.IsMatch(text);
        }
        private void PrevText(object sender, TextCompositionEventArgs e)
        {
            e.Handled = !IsTextAllowed(e.Text);
        }

        private void lb_SelectionChanged(object sender, SelectionChangedEventArgs e)
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

            Country=vec[lb.SelectedIndex];
        }
    }
   
}
