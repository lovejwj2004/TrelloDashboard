package chne.trello.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by lovejwj2004 on 2016/6/5.
 */
@Component
@ConfigurationProperties(prefix="connection",locations = "classpath:config/test.properties")
public class ConfigValues {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String name;
    private String url;
}
