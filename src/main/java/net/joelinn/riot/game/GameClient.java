package net.joelinn.riot.game;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.riot.AbstractClient;
import net.joelinn.riot.Region;
import net.joelinn.riot.game.dto.RecentGames;

/**
 * Joe Linn
 * 12/10/13
 * @see <a href="https://developer.riotgames.com/api/methods#!/292">https://developer.riotgames.com/api/methods#!/292</a>
 */
public class GameClient extends AbstractClient{

    public GameClient(String apiKey, Region region) {
        super(apiKey, region);
    }

    @Override
    protected String getVersion() {
        return "1.2";
    }

    /**
     * @param summonerId id of the desired summoner
     * @return an object containing a list of the given summoner's most recent games
     * @see <a href="https://developer.riotgames.com/api/methods#!/292/1029">https://developer.riotgames.com/api/methods#!/292/1029</a>
     */
    public RecentGames getRecentGamesBySummoner(long summonerId){
        return get(String.format("by-summoner/%s/recent", summonerId)).getEntity(RecentGames.class);
    }

    @Override
    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams, MultivaluedMapImpl data) {
        return super.request(method, "game/" + url, queryParams, data);
    }
}
