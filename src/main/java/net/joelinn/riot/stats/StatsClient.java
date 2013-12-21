package net.joelinn.riot.stats;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.riot.AbstractClient;
import net.joelinn.riot.Region;
import net.joelinn.riot.stats.dto.PlayerStatsSummaryList;
import net.joelinn.riot.stats.dto.RankedStats;

/**
 * Joe Linn
 * 12/14/13
 */
public class StatsClient extends AbstractClient{

    public StatsClient(String apiKey, Region region) {
        super(apiKey, region);
    }

    @Override
    protected String getVersion() {
        return "1.2";
    }

    public PlayerStatsSummaryList getSummaryBySummoner(long summonerId){
        return get(String.format("by-summoner/%s/summary", summonerId)).getEntity(PlayerStatsSummaryList.class);
    }

    public RankedStats getRankedStatsBySummoner(long summonerId){
        return get(String.format("by-summoner/%s/ranked", summonerId)).getEntity(RankedStats.class);
    }

    @Override
    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams, MultivaluedMapImpl data) {
        return super.request(method, "stats/" + url, queryParams, data);
    }
}
