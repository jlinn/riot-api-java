package net.joelinn.riot.league;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.riot.AbstractClient;
import net.joelinn.riot.Region;
import net.joelinn.riot.constants.SubType;
import net.joelinn.riot.league.dto.League;
import net.joelinn.riot.league.dto.LeagueItem;

import java.util.List;

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
        return "2.3";
    }

    /**
     * Retrieve challenger tier leagues
     * @param type valid options are RANKED_SOLO_5x5, RANKED_TEAM_3x3, and RANKED_TEAM_5x5
     * @return the desired challenger tier league
     * @see <a href="https://developer.riotgames.com/api/methods#!/476/1578">https://developer.riotgames.com/api/methods#!/476/1578</a>
     */
    public League getChallengerLeague(SubType type){
        MultivaluedMapImpl params = new MultivaluedMapImpl();
        params.add("type", type);
        return get("challenger", params).getEntity(League.class);
    }

    /**
     * Retrieve leagues entry data for a summoner, including league entries for all of the summoner's teams
     * @param summonerId the id of the desired summoner
     * @return a list of LeagueItem objects
     * @see <a href="https://developer.riotgames.com/api/methods#!/476/1579">https://developer.riotgames.com/api/methods#!/476/1579</a>
     */
    public List<LeagueItem> getLeagueEntryBySummoner(long summonerId){
        return get(String.format("by-summoner/%s/entry", summonerId)).getEntity(new GenericType<List<LeagueItem>>(){});
    }

    /**
     * Retrieve leagues data for a summoner
     * @param summonerId the id of the desired summoner
     * @return a list of League objects
     * @see <a href="https://developer.riotgames.com/api/methods#!/369/1261">https://developer.riotgames.com/api/methods#!/307/1055</a>
     */
    public List<League> getLeaguesBySummoner(long summonerId){
        return get(String.format("by-summoner/%s", summonerId)).getEntity(new GenericType<List<League>>(){});
    }

    @Override
    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams, MultivaluedMapImpl data) {
        return super.request(method, "league/" + url, queryParams, data);
    }
}
