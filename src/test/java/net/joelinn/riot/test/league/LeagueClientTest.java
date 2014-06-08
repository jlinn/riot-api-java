package net.joelinn.riot.test.league;

import junit.framework.TestCase;
import net.joelinn.riot.constants.SubType;
import net.joelinn.riot.league.LeagueClient;
import net.joelinn.riot.league.dto.League;
import net.joelinn.riot.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

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
        Map<String, List<League>> leaguesBySummoner = client.getLeaguesBySummoner(summonerId, XPECIAL);

        assertThat(leaguesBySummoner.keySet(), hasSize(2));
        assertThat(leaguesBySummoner.keySet(), contains(String.valueOf(summonerId), String.valueOf(XPECIAL)));
    }

    @Test
    public void testGetLeagueEntryBySummoner(){
        long summonerId = getSummonerId();
        Map<String, List<League>> leagueEntryBySummoner = client.getLeagueEntryBySummoner(summonerId, XPECIAL);

        assertThat(leagueEntryBySummoner.keySet(), hasSize(2));
        assertThat(leagueEntryBySummoner.keySet(), contains(String.valueOf(summonerId), String.valueOf(XPECIAL)));
    }

    @Test
    public void testGetChallengerLeague(){
        SubType type = SubType.RANKED_SOLO_5x5;
        League league = client.getChallengerLeague(type);

        TestCase.assertEquals(type.toString(), league.queue);
    }

    @Test
    public void testGetLeaguesByTeam(){
        final String team1 = "TEAM-251a4050-e7ae-11e3-bff4-782bcb4d1861";
        final String team2 = "TEAM-b9f72bb0-7658-11e3-9091-782bcb4d1861";

        Map<String, List<League>> leaguesByTeam = client.getLeaguesByTeam(team1, team2);

        assertThat(leaguesByTeam.keySet(), hasSize(2));
        assertThat(leaguesByTeam.keySet(), contains(team2, team1));
    }

    @Test
    public void testGetLeagueEntriesByTeam(){
        final String team1 = "TEAM-251a4050-e7ae-11e3-bff4-782bcb4d1861";
        final String team2 = "TEAM-b9f72bb0-7658-11e3-9091-782bcb4d1861";

        Map<String, List<League>> leagueEntriesByTeam = client.getLeagueEntriesByTeam(team1, team2);

        assertThat(leagueEntriesByTeam.keySet(), hasSize(2));
        assertThat(leagueEntriesByTeam.keySet(), contains(team2, team1));
    }
}
