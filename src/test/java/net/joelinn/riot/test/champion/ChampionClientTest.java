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

    @Before
    public void setUp(){
        client = new ChampionClient(getApiKey(), getRegion());
    }

    @Test
    public void testGetChampions(){
        ChampionList champs = client.getChampions();

        boolean dragonFound = false;
        for(Champion champ : champs.champions){
            if(champ.name.equals("Shyvana") && champ.id == 102){
                dragonFound = true;
            }
        }
        TestCase.assertTrue(dragonFound);
    }
}
