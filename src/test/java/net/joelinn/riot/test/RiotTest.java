package net.joelinn.riot.test;

import junit.framework.TestCase;
import net.joelinn.riot.Region;
import net.joelinn.riot.Riot;
import net.joelinn.riot.champion.ChampionClient;
import org.junit.Before;
import org.junit.Test;

/**
 * Joe Linn
 * 12/18/13
 */
public class RiotTest extends BaseTest{
    protected Riot client;

    @Before
    public void setUp(){
        client = new Riot(getApiKey(), getRegion());
    }

    @Test
    public void testGetClient(){
        TestCase.assertEquals(ChampionClient.class, client.champion().getClass());
    }

    @Test
    public void testSetRegion(){
        client.setRegion(Region.BR);
        TestCase.assertEquals(Region.BR, client.game().getRegion());

        client.setRegion(Region.EUNE);
        TestCase.assertEquals(Region.EUNE, client.game().getRegion());
    }
}
