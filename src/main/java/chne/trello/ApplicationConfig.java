package chne.trello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by lovejwj2004 on 2016/6/2.
 *
 * 为了能够通过@Value注解访问属性文件，我们必须定义一个用来配置PropertySourcesPlaceholderConfigurere的类
 */
@Configuration
@PropertySource("classpath:config/test.properties")
@ComponentScan
public class ApplicationConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
