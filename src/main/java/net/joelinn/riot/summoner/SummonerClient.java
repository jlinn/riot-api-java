package net.joelinn.riot.summoner;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.riot.AbstractClient;
import net.joelinn.riot.Region;
import net.joelinn.riot.summoner.dto.MasteryPages;
import net.joelinn.riot.summoner.dto.RunePages;
import net.joelinn.riot.summoner.dto.Summoner;
import net.joelinn.riot.summoner.dto.SummonerNameList;


/**
 * Joe Linn
 * 12/14/13
 * @see <a href="https://developer.riotgames.com/api/methods#!/293">https://developer.riotgames.com/api/methods#!/293</a>
 */
public class SummonerClient extends AbstractClient{

    public SummonerClient(String apiKey, Region region) {
        super(apiKey, region);
    }

    @Override
    protected String getVersion() {
        return "1.2";
    }

    public MasteryPages getMasteries(long summonerId){
        return get(String.format("%s/masteries", summonerId)).getEntity(MasteryPages.class);
    }

    public RunePages getRunes(long summonerId){
        return get(String.format("%s/runes", summonerId)).getEntity(RunePages.class);
    }

    public Summoner getSummoner(String name){
        return get(String.format("by-name/%s", name)).getEntity(Summoner.class);
    }

    public Summoner getSummoner(long summonerId){
        return get(Long.toString(summonerId)).getEntity(Summoner.class);
    }

    public SummonerNameList getSummonerNames(long... summonerIds){
        String joined = "";
        String comma = "";
        for(long id : summonerIds){
            joined += comma + Long.toString(id);
            comma = ",";
        }
        return get(String.format("%s/name", joined)).getEntity(SummonerNameList.class);
    }

    @Override
    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams, MultivaluedMapImpl data) {
        return super.request(method, "summoner/" + url, queryParams, data);
    }
}
