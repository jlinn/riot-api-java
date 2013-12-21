package net.joelinn.riot.team;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.riot.AbstractClient;
import net.joelinn.riot.Region;
import net.joelinn.riot.team.dto.Team;

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
        return "2.2";
    }

    public Team[] getTeamBySummoner(long summonerId){
        return get(String.format("by-summoner/%s", summonerId)).getEntity(Team[].class);
    }

    @Override
    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams, MultivaluedMapImpl data) {
        return super.request(method, "team/" + url, queryParams, data);
    }
}
