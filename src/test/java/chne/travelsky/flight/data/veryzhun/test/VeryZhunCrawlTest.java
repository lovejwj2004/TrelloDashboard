package chne.travelsky.flight.data.veryzhun.test;

import chne.travelsky.flight.data.veryzhun.VeryZhunCrawl;
import chne.travelsky.flight.model.Flight;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by lovejwj2004 on 2016/5/29.
 */
public class VeryZhunCrawlTest {

    @Test
    public void testGetFlightsByODAndDate(){
        List<Flight> flights =  VeryZhunCrawl.getFlightsByODAndDate("HAK-CSX","20160530");
        Assert.assertEquals(true,flights.size()>0);
    }
}
