package chne.travelsky.flight.business;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * Created by lovejwj2004 on 2016/5/30.
 */
public class FlightServiceTest {
    @Test
    public void testGetAirlineCollection(){
        Set<String> airlines = FlightService.getAirlineCollection("HAK-CSX","20160530");
        Assert.assertEquals(true,airlines.size()>0);
    }
}
