using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Runtime.CompilerServices;
using System.Text;

namespace MainApp
{
    class Sales : INotifyPropertyChanged
    {
        private DateTime date;
        private int total_active_cases;
        private int total_new_cases;
        public event PropertyChangedEventHandler PropertyChanged;

        public DateTime Date
        {
            get {   return date;    }
            set
            {
                date = value;
                OnPropertyChanged();
            }
        }
        public int Total_active_cases
        {
            get {   return total_active_cases;    }
            set
            {
                total_active_cases = value;
                OnPropertyChanged();
            }
        }


        public int Total_new_cases
        {
            get {   return total_new_cases;    }
            set
            {
                total_new_cases = value;
                OnPropertyChanged();
            }
        }
        protected void OnPropertyChanged([CallerMemberName] string name = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
    }
}
