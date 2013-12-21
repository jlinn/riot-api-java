package net.joelinn.riot.test;

import net.joelinn.riot.Region;
import org.junit.Before;

import java.io.IOException;
import java.util.Properties;

/**
 * Joe Linn
 * 12/10/13
 */
public abstract class BaseTest {
    private Properties properties;

    @Before
    public void setUpBefore(){
        properties = new Properties();
        try {
            properties.load(BaseTest.class.getResourceAsStream("/junit.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getApiKey(){
        return properties.getProperty("apiKey", "");
    }

    public Region getRegion(){
        return Region.valueOf(properties.getProperty("region", Region.NA.toString()).toUpperCase());
    }

    public long getSummonerId(){
        return Long.parseLong(properties.getProperty("summonerId", "2"));
    }

    public String getSummonerName(){
        return properties.getProperty("summonerName", "Udyr");
    }
}
