package net.joelinn.riot.test.league;

import junit.framework.TestCase;
import net.joelinn.riot.league.dto.League;
import net.joelinn.riot.league.LeagueClient;
import net.joelinn.riot.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Joe Linn
 * 12/14/13
 */
public class LeagueClientTest extends BaseTest{
    protected LeagueClient client;

    @Before
    public void setUp(){
        client = new LeagueClient(getApiKey(), getRegion());
    }

    @Test
    public void testGetLeagueBySummoner(){
        long summonerId = getSummonerId();
        List<League> leagueList = client.getLeaguesBySummoner(summonerId);

        boolean summonerFound = false;
        for(League league : leagueList){
            if(Long.valueOf(league.participantId) == summonerId){
                summonerFound = true;
            }
        }
        TestCase.assertTrue(summonerFound);
    }
}
