package net.joelinn.riot.champion;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.riot.AbstractClient;
import net.joelinn.riot.Region;
import net.joelinn.riot.champion.dto.Champion;
import net.joelinn.riot.champion.dto.ChampionList;

/**
 * Joe Linn
 * 12/10/13
 * @see <a href="https://developer.riotgames.com/api/methods#!/291">https://developer.riotgames.com/api/methods#!/291</a>
 */
public class ChampionClient extends AbstractClient{

    public ChampionClient(String apiKey, Region region) {
        super(apiKey, region);
    }

    @Override
    protected String getVersion() {
        return "1.2";
    }

    /**
     * @see <a href="https://developer.riotgames.com/api/methods#!/291/1028">https://developer.riotgames.com/api/methods#!/291/1028</a>
     * @return a list of all champions
     */
    public ChampionList getChampions(){
        return get("champion").getEntity(ChampionList.class);
    }

    /**
     * @see <a href="https://developer.riotgames.com/api/methods#!/617/1922">https://developer.riotgames.com/api/methods#!/617/1922</a>
     * @param championId the id of the desired champion
     * @return data for the requested champion
     */
    public Champion getChampion(long championId){
        return get(String.format("champion/%s", championId)).getEntity(Champion.class);
    }

    @Override
    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams, MultivaluedMapImpl data) {
        return super.request(method, url, queryParams, data);
    }
}
