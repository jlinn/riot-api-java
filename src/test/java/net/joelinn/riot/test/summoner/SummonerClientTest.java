package net.joelinn.riot.test.summoner;

import junit.framework.TestCase;
import net.joelinn.riot.summoner.*;
import net.joelinn.riot.summoner.dto.*;
import net.joelinn.riot.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * Joe Linn
 * 12/14/13
 */
public class SummonerClientTest extends BaseTest{
    protected SummonerClient client;

    @Before
    public void setUp(){
        client = new SummonerClient(getApiKey(), getRegion());
    }

    @Test
    public void testGetMasteries(){
        long summonerId = getSummonerId();
        MasteryPages masteries = client.getMasteries(summonerId);

        TestCase.assertEquals(summonerId, masteries.summonerId);
    }

    @Test
    public void testGetRunes(){
        RunePages runes = client.getRunes(getSummonerId());

        TestCase.assertEquals(getSummonerId(), runes.summonerId);
    }

    @Test
    public void testGetSummoner(){
        Summoner summoner = client.getSummoner(getSummonerName());

        TestCase.assertEquals(summoner.id, client.getSummoner(summoner.id).id);
    }

    @Test
    public void testGetSummonerNames(){
        SummonerNameList summonerNames = client.getSummonerNames(getSummonerId(), 1, 3);

        boolean summonerFound = false;
        for(SummonerName name : summonerNames.summoners){
            if(name.id == getSummonerId()){
                summonerFound = true;
            }
        }
        TestCase.assertTrue(summonerFound);
    }
}
