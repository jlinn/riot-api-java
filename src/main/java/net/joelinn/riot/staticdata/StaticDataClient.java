package net.joelinn.riot.staticdata;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.riot.AbstractClient;
import net.joelinn.riot.Region;
import net.joelinn.riot.staticdata.dto.*;

import java.util.Arrays;

/**
 * Joe Linn
 * 1/29/14
 * @see <a href="https://developer.riotgames.com/api/methods#!/374">https://developer.riotgames.com/api/methods#!/374</a>
 */
public class StaticDataClient extends AbstractClient{
    /**
     * @param apiKey your Riot API key
     * @param region {@link net.joelinn.riot.Region}
     */
    public StaticDataClient(String apiKey, Region region) {
        super(apiKey, region);
    }

    /**
     * @return the version number of the API ("1.1", "2.3", for example)
     */
    @Override
    protected String getVersion() {
        return "1";
    }

    @Override
    protected String getBaseUrl() {
        return super.getBaseUrl() + "static-data/";
    }

    public ChampionList getChampions(){
        return getChampions(new ChampData[]{});
    }

    public ChampionList getChampions(ChampData... champData){
        return getChampions(null, null, champData);
    }

    /**
     * Retrieve champion list
     * @see <a href="https://developer.riotgames.com/api/methods#!/374/1303">https://developer.riotgames.com/api/methods#!/374/1303</a>
     * @param locale locale code for returned data (en_US, es_ES, etc.)
     * @param version data dragon version for returned data
     * @param champData tags to return additional data
     * @return a list of champion data
     */
    public ChampionList getChampions(String locale, String version, ChampData... champData){
        return get(ChampionList.class, "champion", locale, version, champData);
    }

    public Champion getChampion(int championId){
        return getChampion(championId, new ChampData[]{});
    }

    public Champion getChampion(int championId, ChampData... champData){
        return getChampion(championId, null, null, champData);
    }

    /**
     * Retrieve data for a single champion
     * @see <a href="https://developer.riotgames.com/api/methods#!/374/1304">https://developer.riotgames.com/api/methods#!/374/1304</a>
     * @param championId the id of the desired champion
     * @param locale locale code for returned data (en_US, es_ES, etc.)
     * @param version data dragon version for returned data
     * @param champData tags to return additional data
     * @return data for a single champion
     */
    public Champion getChampion(int championId, String locale, String version, ChampData... champData){
        return get(Champion.class, String.format("champion/%s", championId), locale, version, champData);
    }

    public ItemList getItems(){
        return getItems(new ItemListData[]{});
    }

    public ItemList getItems(ItemListData... itemListData){
        return getItems(null, null, itemListData);
    }

    /**
     * Retrieve an item list
     * <a href="https://developer.riotgames.com/api/methods#!/374/1306">https://developer.riotgames.com/api/methods#!/374/1306</a>
     * @param locale locale code for returned data (en_US, es_ES, etc.)
     * @param version data dragon version for returned data
     * @param itemListData tags to return additional data
     * @return a list of item data
     */
    public ItemList getItems(String locale, String version, ItemListData... itemListData){
        return get(ItemList.class, "item", locale, version, itemListData);
    }

    public Item getItem(int itemId){
        return getItem(itemId, new ItemData[]{});
    }

    public Item getItem(int itemId, ItemData... itemData){
        return getItem(itemId, null, null, itemData);
    }

    /**
     * Retrieve a specific item
     * @see <a href="https://developer.riotgames.com/api/methods#!/374/1302>https://developer.riotgames.com/api/methods#!/374/1302</a>
     * @param itemId the id of the desired item
     * @param locale locale code for returned data (en_US, es_ES, etc.)
     * @param version data dragon version for returned data
     * @param itemData tags to return additional data
     * @return data for a single item
     */
    public Item getItem(int itemId, String locale, String version, ItemData... itemData){
        return get(Item.class, String.format("item/%s", itemId), locale, version, itemData);
    }

    public MasteryList getMasteries(){
        return getMasteries(new MasteryListData[]{});
    }

    public MasteryList getMasteries(MasteryListData... masteryListData){
        return getMasteries(null, null, masteryListData);
    }

    /**
     * Retrieve a list of items
     * @see <a href="https://developer.riotgames.com/api/methods#!/374/1297">https://developer.riotgames.com/api/methods#!/374/1297</a>
     * @param locale locale code for returned data (en_US, es_ES, etc.)
     * @param version data dragon version for returned data
     * @param masteryListData tags to return additional data
     * @return data for all masteries
     */
    public MasteryList getMasteries(String locale, String version, MasteryListData... masteryListData){
        return get(MasteryList.class, "mastery", locale, version, masteryListData);
    }

    public Mastery getMastery(int masteryId){
        return getMastery(masteryId, new MasteryData[]{});
    }

    public Mastery getMastery(int masteryId, MasteryData... masteryData){
        return getMastery(masteryId, null, null, masteryData);
    }

    /**
     * @see <a href="https://developer.riotgames.com/api/methods#!/378/1346">https://developer.riotgames.com/api/methods#!/378/1346</a>
     * @param masteryId the id of the desired mastery
     * @param locale locale code for returned data (en_US, es_ES, etc.)
     * @param version data dragon version for returned data
     * @param masteryData tags to return additional data
     * @return data for a single mastery
     */
    public Mastery getMastery(int masteryId, String locale, String version, MasteryData... masteryData){
        return get(Mastery.class, String.format("mastery/%s", masteryId), version, locale, masteryData);
    }

    /**
     * Retrieve realm data
     * @return dragon magic realm data
     */
    public Realm getRealm(){
        return get("realm").getEntity(Realm.class);
    }

    public RuneList getRunes(){
        return getRunes(new RuneListData[]{});
    }

    public RuneList getRunes(RuneListData... runeListData){
        return getRunes(null, null, runeListData);
    }

    /**
     * Retrieve rune list
     * @see <a href="https://developer.riotgames.com/api/methods#!/378/1340">https://developer.riotgames.com/api/methods#!/378/1340</a>
     * @param locale locale code for returned data (en_US, es_ES, etc.)
     * @param version data dragon version for returned data
     * @param runeListData tags to return additional data
     * @return data for all runes
     */
    public RuneList getRunes(String locale, String version, RuneListData... runeListData){
        return get(RuneList.class, "rune", locale, version, runeListData);
    }

    public Rune getRune(int runeId){
        return getRune(runeId, new RuneData[]{});
    }

    public Rune getRune(int runeId, RuneData... runeData){
        return getRune(runeId, null, null, runeData);
    }

    /**
     * @see <a href="https://developer.riotgames.com/api/methods#!/378/1347">https://developer.riotgames.com/api/methods#!/378/1347</a>
     * @param runeId the id of the desired rune
     * @param locale locale code for returned data (en_US, es_ES, etc.)
     * @param version data dragon version for returned data
     * @param runeData tags to return additional data
     * @return data for a specific rune
     */
    public Rune getRune(int runeId, String locale, String version, RuneData... runeData){
        return get(Rune.class, String.format("rune/%s", runeId), locale, version, runeData);
    }

    public SummonerSpellList getSummonerSpells(){
        return getSummonerSpells(new SpellData[]{});
    }

    public SummonerSpellList getSummonerSpells(SpellData... spellData){
        return getSummonerSpells(null, null, spellData);
    }

    /**
     * Retrieve all summoner spells
     * @see <a href="https://developer.riotgames.com/api/methods#!/378/1348">https://developer.riotgames.com/api/methods#!/378/1348</a>
     * @param locale locale code for returned data (en_US, es_ES, etc.)
     * @param version data dragon version for returned data
     * @param spellData tags to return additional data
     * @return data for all summoner spells
     */
    public SummonerSpellList getSummonerSpells(String locale, String version, SpellData... spellData){
        return get(SummonerSpellList.class, "summoner-spell", locale, version, spellData);
    }

    public SummonerSpell getSummonerSpell(String spellId){
        return getSummonerSpell(spellId, new SpellData[]{});
    }

    public SummonerSpell getSummonerSpell(String spellId, SpellData... spellData){
        return getSummonerSpell(spellId, null, null, spellData);
    }

    /**
     * Retrieve a specific summoner spell
     * @see <a href="https://developer.riotgames.com/api/methods#!/378/1341">https://developer.riotgames.com/api/methods#!/378/1341</a>
     * @param spellId the id (name) of the desired spell
     * @param locale locale code for returned data (en_US, es_ES, etc.)
     * @param version data dragon version for returned data
     * @param spellData tags to return additional data
     * @return a single summoner spell
     */
    public SummonerSpell getSummonerSpell(String spellId, String locale, String version, SpellData... spellData){
        return get(SummonerSpell.class, String.format("summoner-spell/%s", spellId), locale, version, spellData);
    }

    protected <T> T get(Class<T> clazz, String url, String locale, String version, Enum... data){
        return get(url, getParams(locale, version, data)).getEntity(clazz);
    }

    protected MultivaluedMapImpl getParams(String locale, String version, Enum... data){
        MultivaluedMapImpl params = new MultivaluedMapImpl();
        if(data.length > 0){
            String enumName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, data.getClass().getSimpleName());
            enumName = enumName.substring(0, enumName.length() - 2);
            params.add(enumName, Joiner.on(',').skipNulls().join(Arrays.asList(data)));
        }
        if(locale != null){
            params.add("locale", locale);
        }
        if(version != null){
            params.add("version", version);
        }
        return params;
    }
}
