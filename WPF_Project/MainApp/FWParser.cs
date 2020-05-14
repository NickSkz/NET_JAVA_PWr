using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Linq;

using HtmlAgilityPack;

using LoggerSpace;
using System.Threading.Tasks;

namespace FWMovieParser
{
    public class FWParser
    {
        public static List<string> top10Movies;

        //Parse IMDB TOP Netflix Movies
        public static async void getHtml()
        {
            var url = "https://www.imdb.com/list/ls056789192/";

            var httpClient = new HttpClient();

            String html;
            try
            {
                html = await httpClient.GetStringAsync(url);
            }
            catch(HttpRequestException e)
            {
                html = await httpClient.GetStringAsync("example.com");
                Logger.log.Error("GetStringAsync Error: " + e.Message);
            }
            catch(Exception e)
            {
                html = await httpClient.GetStringAsync("example.com");
                Logger.log.Error("GetStringAsync Error: " + e.Message);
            }
            finally
            {
                Logger.log.Info("GetStringAsync invoked!");
            }

            var htmlDocument = new HtmlDocument();
            htmlDocument.LoadHtml(html);

            var MovieList = htmlDocument.DocumentNode.Descendants("div")
                .Where(n => n.GetAttributeValue("class", "")
                .Equals("lister list detail sub-list")).ToList();

            var ProductListItems = MovieList[0].Descendants("h3")
                .Where(n => n.GetAttributeValue("class", "")
                .Contains("lister-item-header"));

            var ListOfMovies = ProductListItems.ToList();
            top10Movies = new List<string>();

            for(int i = 0; i < 10; ++i)
            {
                top10Movies.Add(ListOfMovies[i].InnerText.Replace("\n", string.Empty).Trim(' '));
            }
        }
    }
}
