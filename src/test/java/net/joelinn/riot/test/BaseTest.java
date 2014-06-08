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
    protected static final long THE_ODD_ONE = 60783;
    protected static final long PHREAK = 7428;
    protected static final long C9_METEOS = 390600;
    protected static final long XPECIAL = 19199530;

    protected static final String TSM = "TEAM-e4936d7b-b80e-4367-a76c-5ccf7388c995";
    protected static final String C9 = "TEAM-9baaf74e-ea61-4ebc-82d9-b013d29399fa";

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
