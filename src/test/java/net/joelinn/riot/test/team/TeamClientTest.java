package net.joelinn.riot.test.team;

import junit.framework.TestCase;
import net.joelinn.riot.team.TeamClient;
import net.joelinn.riot.team.dto.Team;
import net.joelinn.riot.team.dto.TeamMemberInfo;
import net.joelinn.riot.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

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
        Team[] teams = client.getTeamBySummoner(getSummonerId());

        boolean summonerFound = false;
        for (Team team : teams){
            for(TeamMemberInfo member : team.roster.memberList){
                if(member.playerId == getSummonerId()){
                    summonerFound = true;
                }
            }
        }
        TestCase.assertTrue(summonerFound);
    }
}
