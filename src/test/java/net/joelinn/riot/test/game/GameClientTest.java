package net.joelinn.riot.test.game;

import junit.framework.TestCase;
import net.joelinn.riot.game.GameClient;
import net.joelinn.riot.game.dto.RecentGames;
import net.joelinn.riot.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * Joe Linn
 * 12/10/13
 */
public class GameClientTest extends BaseTest{
    public GameClient client;

    @Before
    public void setUp(){
        client = new GameClient(getApiKey(), getRegion());
    }

    @Test
    public void testGetRecentGamesBySummoner(){
        long summonerId = getSummonerId();
        RecentGames games = client.getRecentGamesBySummoner(summonerId);

        TestCase.assertEquals(summonerId, games.summonerId);
    }
}
