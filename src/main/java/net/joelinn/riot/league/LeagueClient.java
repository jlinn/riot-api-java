package net.joelinn.riot.league;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.riot.AbstractClient;
import net.joelinn.riot.Region;
import net.joelinn.riot.constants.SubType;
import net.joelinn.riot.league.dto.League;

import java.util.List;
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
        return "2.4";
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
     * Retrieve leagues entry data for one or more summoners, including league entries for all of the summoners' teams
     * @param summonerIds one or more summoner ids
     * @return a map of lists of {@link League} objects, with the map's keys being the requested summoner ids
     * @see <a href="https://developer.riotgames.com/api/methods#!/476/1579">https://developer.riotgames.com/api/methods#!/476/1579</a>
     */
    public Map<String, List<League>> getLeagueEntryBySummoner(long... summonerIds){
        return get(String.format("by-summoner/%s/entry", commaDelimit(summonerIds))).getEntity(new GenericType<Map<String, List<League>>>() {});
    }

    /**
     * Retrieve leagues data for one or more summoners
     * @param summonerIds one or more summoner ids
     * @return a map of lists of League objects, with the map's keys being the requested summoner ids
     * @see <a href="https://developer.riotgames.com/api/methods#!/741/2640">https://developer.riotgames.com/api/methods#!/741/2640</a>
     */
    public Map<String, List<League>> getLeaguesBySummoner(long... summonerIds){
        return get(String.format("by-summoner/%s", commaDelimit(summonerIds))).getEntity(new GenericType<Map<String, List<League>>>(){});
    }

    /**
     * Retrieve leagues data for one or more teams
     * @param teamIds one or more team ids
     * @return a map of lists of {@link League} objects, with the keys of the map being the requested team ids
     * <a href="https://developer.riotgames.com/api/methods#!/741/2639">https://developer.riotgames.com/api/methods#!/741/2639</a>
     */
    public Map<String, List<League>> getLeaguesByTeam(String... teamIds){
        return get("by-team/" + commaDelimit(teamIds)).getEntity(new GenericType<Map<String, List<League>>>(){});
    }

    /**
     * Retrieve league entries for one or more teams
     * @param teamIds one or more team ids
     * @return a map of lists of {@link League} objects, with the keys of the map being the requested team ids
     * <a href="https://developer.riotgames.com/api/methods#!/741/2638">https://developer.riotgames.com/api/methods#!/741/2638</a>
     */
    public Map<String, List<League>> getLeagueEntriesByTeam(String... teamIds){
        return get(String.format("by-team/%s/entry", commaDelimit(teamIds))).getEntity(new GenericType<Map<String, List<League>>>(){});
    }

    @Override
    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams, MultivaluedMapImpl data) {
        return super.request(method, "league/" + url, queryParams, data);
    }
}
