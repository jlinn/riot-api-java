package net.joelinn.riot.league;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.riot.AbstractClient;
import net.joelinn.riot.Region;
import net.joelinn.riot.league.dto.League;

import java.util.HashMap;
import java.util.Map;

/**
 * Joe Linn
 * 12/14/13
 * @see <a href="https://developer.riotgames.com/api/methods#!/307">https://developer.riotgames.com/api/methods#!/307</a>
 */
public class LeagueClient extends AbstractClient{

    public LeagueClient(String apiKey, Region region) {
        super(apiKey, region);
    }

    @Override
    protected String getVersion() {
        return "2.2";
    }

    /**
     * Retrieve leagues data for a summoner
     * @param summonerId the id of the desired summoner
     * @return a League object
     * @see <a href="https://developer.riotgames.com/api/methods#!/307/1055">https://developer.riotgames.com/api/methods#!/307/1055</a>
     */
    public Map<String, League> getLeagueBySummoner(long summonerId){
        return get(String.format("by-summoner/%s", summonerId)).getEntity(new GenericType<HashMap<String, League>>(){});
    }

    @Override
    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams, MultivaluedMapImpl data) {
        return super.request(method, "league/" + url, queryParams, data);
    }
}
