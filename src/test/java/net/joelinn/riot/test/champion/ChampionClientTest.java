package net.joelinn.riot.test.champion;

import junit.framework.TestCase;
import net.joelinn.riot.champion.dto.Champion;
import net.joelinn.riot.champion.ChampionClient;
import net.joelinn.riot.champion.dto.ChampionList;
import net.joelinn.riot.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * Joe Linn
 * 12/10/13
 */
public class ChampionClientTest extends BaseTest{
    protected ChampionClient client;

    protected static final long SHYVANA_ID = 102;

    @Before
    public void setUp(){
        client = new ChampionClient(getApiKey(), getRegion());
    }

    @Test
    public void testGetChampions(){
        ChampionList champs = client.getChampions();

        boolean dragonFound = false;
        for(Champion champ : champs.champions){
            if(champ.id == SHYVANA_ID){
                dragonFound = true;
            }
        }
        TestCase.assertTrue(dragonFound);
    }

    @Test
    public void testGetChampion(){
        Champion shyvana = client.getChampion(SHYVANA_ID);
        TestCase.assertEquals(SHYVANA_ID, shyvana.id);
    }
}
