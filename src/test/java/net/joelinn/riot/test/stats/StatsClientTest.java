package net.joelinn.riot.test.stats;

import junit.framework.TestCase;
import net.joelinn.riot.stats.dto.PlayerStatsSummaryList;
import net.joelinn.riot.stats.dto.RankedStats;
import net.joelinn.riot.stats.StatsClient;
import net.joelinn.riot.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * Joe Linn
 * 12/14/13
 */
public class StatsClientTest extends BaseTest{
    protected StatsClient client;

    @Before
    public void setUp(){
        client = new StatsClient(getApiKey(), getRegion());
    }

    @Test
    public void testGetSummaryBySummoner(){
        long summonerId = getSummonerId();
        PlayerStatsSummaryList summaryList = client.getSummaryBySummoner(summonerId);

        TestCase.assertEquals(summonerId, summaryList.summonerId);
    }

    @Test
    public void testGetRankedStatsBySummonerId(){
        long summonerId = getSummonerId();
        RankedStats rankedStats = client.getRankedStatsBySummoner(summonerId);

        TestCase.assertEquals(summonerId, rankedStats.summonerId);
    }
}
