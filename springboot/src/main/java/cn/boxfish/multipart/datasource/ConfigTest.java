package cn.boxfish.multipart.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by LuoLiBing on 15/7/21.
 */
@Component
@ConfigurationProperties(prefix = "db")
public class ConfigTest {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
