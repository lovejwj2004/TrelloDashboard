package chne.travelsky.flight.controller;

import chne.travelsky.flight.business.veryzhun.SegmentUtils;
import chne.travelsky.flight.model.Flight;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lovejwj2004 on 2016/5/28.
 */

@RestController
@RequestMapping("/air")
public class FlightController {
    @RequestMapping(value = "/{od}/{date}/flights",method = RequestMethod.GET)
    List<Flight> getFlightList(@PathVariable String od,@PathVariable String date){
        List<Flight> flights = new ArrayList<Flight>();
        flights = SegmentUtils.getFlightsByODAndDate(od,date);
        return flights;
    }

}
