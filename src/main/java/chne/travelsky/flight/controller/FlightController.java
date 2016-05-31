package chne.travelsky.flight.controller;

import chne.travelsky.flight.business.FlightService;
import chne.travelsky.flight.data.crawl.VeryZhunCrawl;
import chne.travelsky.flight.model.Flight;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by lovejwj2004 on 2016/5/28.
 */

@RestController
@RequestMapping("/air")
public class FlightController {
    @RequestMapping(value = "/{od}/{date}/flights",method = RequestMethod.GET)
    List<Flight> getFlightList(@PathVariable String od,@PathVariable String date){
        List<Flight> flights = new ArrayList<Flight>();
        flights = VeryZhunCrawl.getFlightsByODAndDate(od,date);
        return flights;
    }

    @RequestMapping(value = "/{od}/{date}/airlines",method = RequestMethod.GET)
    Set<String> getAirlines(@PathVariable String od, @PathVariable String date){
        Set<String> airlines = FlightService.getAirlineCollection(od,date);
        return airlines;
    }

}
