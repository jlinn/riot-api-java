package net.joelinn.riot;

import net.joelinn.riot.champion.ChampionClient;
import net.joelinn.riot.game.GameClient;
import net.joelinn.riot.league.LeagueClient;
import net.joelinn.riot.staticdata.StaticDataClient;
import net.joelinn.riot.stats.StatsClient;
import net.joelinn.riot.summoner.SummonerClient;
import net.joelinn.riot.team.TeamClient;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Joe Linn
 * 12/17/13
 */
public class Riot {
    protected String apiKey;

    protected Region region;

    protected Map<Class<? extends AbstractClient>, AbstractClient> clients = new HashMap<>();

    public Riot(String apiKey){
        this.apiKey = apiKey;
    }

    public Riot(String apiKey, Region region){
        this(apiKey);
        setRegion(region);
    }

    public Riot setRegion(Region region){
        this.region = region;
        for(AbstractClient client : clients.values()){
            client.setRegion(region);
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    protected <T> T getClient(Class<? extends AbstractClient> clazz){
        if(!clients.containsKey(clazz)){
            try {
                clients.put(clazz, clazz.getConstructor(String.class, Region.class).newInstance(apiKey, region));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                // Since the constructor in the try clause is guaranteed to exist, this should never happen.
                e.printStackTrace();
            }
        }
        return (T) clients.get(clazz);
    }

    public ChampionClient champion(){
        return getClient(ChampionClient.class);
    }

    public GameClient game(){
        return getClient(GameClient.class);
    }

    public LeagueClient league(){
        return getClient(LeagueClient.class);
    }

    public StatsClient stats(){
        return getClient(StatsClient.class);
    }

    public SummonerClient summoner(){
        return getClient(SummonerClient.class);
    }

    public TeamClient team(){
        return getClient(TeamClient.class);
    }

    public StaticDataClient staticData(){
        return getClient(StaticDataClient.class);
    }
}
