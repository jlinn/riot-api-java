package net.joelinn.riot.test.summoner;

import junit.framework.TestCase;
import net.joelinn.riot.ApiException;
import net.joelinn.riot.summoner.*;
import net.joelinn.riot.summoner.dto.*;
import net.joelinn.riot.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

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
        Map<String, MasteryPages> masteries = client.getMasteries(summonerId);

        TestCase.assertEquals(summonerId, masteries.get(Long.toString(summonerId)).summonerId);
    }

    @Test
    public void testGetRunes(){
        Map<String, RunePages> runes = client.getRunes(getSummonerId());

        TestCase.assertEquals(getSummonerId(), runes.get(Long.toString(getSummonerId())).summonerId);
    }

    @Test
    public void testGetSummoner(){
        Map<String, Summoner> summoners = client.getSummoner(getSummonerName());
        Summoner summoner = summoners.get(getSummonerName());

        TestCase.assertEquals(summoner.id, client.getSummoner(summoner.id).get(Long.toString(summoner.id)).id);

        boolean exceptionThrown = false;
        try {
            client.getSummoner(getSummonerName() + "oiwefaoiwefaioefowef");
        }
        catch (ApiException e){
            exceptionThrown = true;
        }
        TestCase.assertTrue(exceptionThrown);
    }

    @Test
    public void testGetSummonerNames(){
        Map<String, String> summonerNames = client.getSummonerNames(getSummonerId(), 1, 3);

        boolean summonerFound = false;
        for(String id : summonerNames.keySet()){
            if(id.equals(String.valueOf(getSummonerId()))){
                summonerFound = true;
            }
        }
        TestCase.assertTrue(summonerFound);
    }
}
