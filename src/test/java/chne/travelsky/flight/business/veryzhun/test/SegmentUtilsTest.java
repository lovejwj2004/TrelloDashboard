package chne.travelsky.flight.business.veryzhun.test;

import chne.travelsky.flight.business.veryzhun.SegmentUtils;
import chne.travelsky.flight.model.Flight;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by lovejwj2004 on 2016/5/29.
 */
public class SegmentUtilsTest {

    @Test
    public void testGetFlightsByODAndDate(){
        List<Flight> flights =  SegmentUtils.getFlightsByODAndDate("HAK-CSX","20160530");
        Assert.assertEquals(true,flights.size()>0);
    }
}
