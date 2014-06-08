package net.joelinn.riot.team;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.riot.AbstractClient;
import net.joelinn.riot.Region;
import net.joelinn.riot.team.dto.Team;

import java.util.List;
import java.util.Map;

/**
 * Joe Linn
 * 12/14/13
 */
public class TeamClient extends AbstractClient{

    public TeamClient(String apiKey, Region region) {
        super(apiKey, region);
    }

    @Override
    protected String getVersion() {
        return "2.3";
    }

    /**
     * Retrieve teams for one or more summoners
     * @param summonerIds one or more summoner ids
     * @return a map of lists of {@link Team} objects, with the map's keys being the requested summoner ids
     */
    public Map<String, List<Team>> getTeamBySummoner(long... summonerIds){
        return get(String.format("by-summoner/%s", commaDelimit(summonerIds))).getEntity(new GenericType<Map<String, List<Team>>>(){});
    }

    @Override
    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams, MultivaluedMapImpl data) {
        return super.request(method, "team/" + url, queryParams, data);
    }
}
