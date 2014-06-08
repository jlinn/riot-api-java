package net.joelinn.riot.test.team;

import net.joelinn.riot.team.TeamClient;
import net.joelinn.riot.team.dto.Team;
import net.joelinn.riot.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.contains;

/**
 * Joe Linn
 * 12/14/13
 */
public class TeamClientTest extends BaseTest{
    protected TeamClient client;

    @Before
    public void setUp(){
        client = new TeamClient(getApiKey(), getRegion());
    }

    @Test
    public void testGetTeamBySummoner(){
        Map<String, List<Team>> teamBySummoner = client.getTeamBySummoner(getSummonerId(), C9_METEOS);

        assertThat(teamBySummoner.keySet(), hasSize(2));
        assertThat(teamBySummoner.keySet(), contains(String.valueOf(getSummonerId()), String.valueOf(C9_METEOS)));
    }
}
