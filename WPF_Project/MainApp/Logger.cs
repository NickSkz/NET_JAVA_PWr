using System;
using System.Collections.Generic;
using System.Text;

namespace LoggerSpace
{
    //Logger object used to print to Logs (debug window + file .log)
    static class Logger
    {
        public static readonly log4net.ILog log =
            log4net.LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);
    }
}
