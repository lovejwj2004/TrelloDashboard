package chne.trello.properties.test;

import chne.trello.TrelloDashboardApplication;
import chne.trello.config.ConfigValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by lovejwj2004 on 2016/6/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TrelloDashboardApplication.class)
@TestPropertySource(locations = "classpath:config/test.properties")
public class PropertiesTest {
    @Autowired
    ConfigValues config;

    @Test
    public void testPropertiesAnnoation(){
        System.out.println(config.getName());
    }
}
