package chne.travelsky.flight.business;

import chne.travelsky.flight.data.veryzhun.VeryZhunCrawl;
import chne.travelsky.flight.model.Flight;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lovejwj2004 on 2016/5/30.
 */
public class FlightService {
    private static final Logger logger = LogManager.getLogger(FlightService.class);

    public static Set<String> getAirlineCollection(String od, String date){
        Set<String> airlines = new HashSet<String>();
        List<Flight> flights = new ArrayList<Flight>();
        flights = VeryZhunCrawl.getFlightsByODAndDate(od,date);
        for (Flight flight : flights){
            airlines.add(flight.getFlightNum().substring(0,2));
        }
        logger.info("Airlines:"+airlines);
        return airlines;
    }
}
