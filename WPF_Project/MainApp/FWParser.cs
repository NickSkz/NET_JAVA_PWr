using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Linq;

using HtmlAgilityPack;


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
            var html = await httpClient.GetStringAsync(url);

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
