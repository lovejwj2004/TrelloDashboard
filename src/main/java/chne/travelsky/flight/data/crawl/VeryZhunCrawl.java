package chne.travelsky.flight.data.crawl;

import chne.travelsky.flight.model.Flight;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lovejwj2004 on 2016/5/28.
 */
public class VeryZhunCrawl {
    private static final Logger logger = LogManager.getLogger(VeryZhunCrawl.class);
    private static String BASEURL = "http://www.variflight.com/flight/";
    private static String TOKEN = "AE71649A58c77";


    public static List<Flight> getFlightsByODAndDate(String od,String date){
        String url = generateURL(od,date);
        List<Flight> flights = null;
        try {
            logger.info("Segment Request URL:"+url);
            Document doc = Jsoup.connect(url).get();
            Elements flightList = doc.select("#list>li");
            flights = fetchFlightsInfo(flightList);
            logger.info("Flight Size:"+flights.size());
        }catch (IOException e){
            logger.error(e.getMessage());
        }

        return flights;
    }

    /**
     *
     * Below are private methods,not available for public only class function.
     */

    private static String generateURL(String od,String date){
        StringBuffer sb = new StringBuffer();
        sb.append(BASEURL);
        sb.append(od);
        sb.append(".html?");
        sb.append(TOKEN);
        sb.append("&fdate=");
        sb.append(date);
        return sb.toString();
    }

    private static List<Flight> fetchFlightsInfo(Elements flightElems){
        List<Flight> flights = new ArrayList<Flight>();
        for (Element flightElem : flightElems){
            Flight flight =  new Flight();
            flight.setFlightNum(flightElem.select("div > span.w260 > b > a:nth-child(2)").get(0).text());
            flight.setDepartureTime(flightElem.getElementsByAttribute("dplan").get(0).text());
            flight.setArrivalTime(flightElem.getElementsByAttribute("aplan").get(0).text());
            flights.add(flight);
        }
        return flights;
    }

}
