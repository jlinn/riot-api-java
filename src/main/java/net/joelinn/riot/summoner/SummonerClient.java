package net.joelinn.riot.summoner;

import com.google.common.base.Joiner;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.riot.AbstractClient;
import net.joelinn.riot.Region;
import net.joelinn.riot.summoner.dto.MasteryPages;
import net.joelinn.riot.summoner.dto.RunePages;
import net.joelinn.riot.summoner.dto.Summoner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


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
        return "1.4";
    }

    /**
     * Retrieve mastery pages mapped by summoner id
     * @see <a href="https://developer.riotgames.com/api/methods#!/355/1197">https://developer.riotgames.com/api/methods#!/355/1197</a>
     * @param summonerIds one or more summoner ids
     * @return a map of summoner mastery page data
     */
    public Map<String, MasteryPages> getMasteries(long... summonerIds){
        return get(String.format("%s/masteries", concatenateSummonerIds(summonerIds)))
                .getEntity(new GenericType<Map<String, MasteryPages>>() {});
    }


    /**
     * Retrieve rune pages mapped by summoner id
     * @see <a href="https://developer.riotgames.com/api/methods#!/355/1198">https://developer.riotgames.com/api/methods#!/355/1198</a>
     * @param summonerIds one or more summoner ids
     * @return a map of summoner rune page data
     */
    public Map<String, RunePages> getRunes(long... summonerIds){
        return get(String.format("%s/runes", concatenateSummonerIds(summonerIds)))
                .getEntity(new GenericType<Map<String, RunePages>>(){});
    }

    /**
     * Get summoner objects mapped by standardized summoner name
     * @see <a href="https://developer.riotgames.com/api/methods#!/355/1196">https://developer.riotgames.com/api/methods#!/355/1196</a>
     * @param names one or more summoner names
     * @return a map of summoner data
     */
    public Map<String, Summoner> getSummoner(String... names){
        return get(String.format("by-name/%s", Joiner.on(',').skipNulls().join(Arrays.asList(names))))
                .getEntity(new GenericType<Map<String, Summoner>>(){});
    }

    /**
     * Retrieve summoner objects mapped by summoner id
     * @see <a href="https://developer.riotgames.com/api/methods#!/355/1195">https://developer.riotgames.com/api/methods#!/355/1195</a>
     * @param summonerIds one or more summoner ids
     * @return a map of summoner data
     */
    public Map<String, Summoner> getSummoner(long... summonerIds){
        return get(concatenateSummonerIds(summonerIds)).getEntity(new GenericType<Map<String, Summoner>>(){});
    }

    /**
     * Get summoner names mapped by summoner id
     * @see <a href="https://developer.riotgames.com/api/methods#!/355/1194">https://developer.riotgames.com/api/methods#!/355/1194</a>
     * @param summonerIds one or more summoner ids
     * @return a map of summoner ids to summoner names
     */
    public Map<String, String> getSummonerNames(long... summonerIds){
        return get(String.format("%s/name", concatenateSummonerIds(summonerIds)))
                .getEntity(new GenericType<Map<String, String>>(){});
    }

    @Override
    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams, MultivaluedMapImpl data) {
        return super.request(method, "summoner/" + url, queryParams, data);
    }

    /**
     * @param summonerIds an array of summoner ids
     * @return a comma-delimited string comprised of the given summoner ids
     */
    protected String concatenateSummonerIds(long... summonerIds){
        List<String> summonerIdStrings = new ArrayList<>(summonerIds.length);
        for(long summonerId : summonerIds){
            summonerIdStrings.add(String.valueOf(summonerId));
        }
        return Joiner.on(',').skipNulls().join(summonerIdStrings);
    }
}
