package chne.travelsky.flight;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlightApplication.class)
@WebAppConfiguration

public class FlightApplicationTests {
	@Value("${connection.name}")
	String name;

	@Value("${connection.url}")
	String url;

	@Test
	public void testPropertiesAnnoation(){
		System.out.println(name);
		System.out.println(url);
	}

}
