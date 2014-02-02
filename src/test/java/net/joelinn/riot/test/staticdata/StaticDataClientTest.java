package net.joelinn.riot.test.staticdata;

import junit.framework.TestCase;
import net.joelinn.riot.staticdata.*;
import net.joelinn.riot.staticdata.dto.*;
import net.joelinn.riot.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * Joe Linn
 * 1/29/14
 */
public class StaticDataClientTest extends BaseTest{
    protected StaticDataClient client;

    @Before
    public void setUp(){
        client = new StaticDataClient(getApiKey(), getRegion());
    }

    @Test
    public void testGetChampions(){
        ChampionList champions = client.getChampions(ChampData.all);

        TestCase.assertEquals("champion", champions.type);
        TestCase.assertTrue(champions.data.size() > 100);
    }

    @Test
    public void testGetChampion(){
        int championId = 1;
        Champion champion = client.getChampion(championId, ChampData.all);

        TestCase.assertEquals(championId, Integer.parseInt(champion.key));
    }

    @Test
    public void testGetItems(){
        ItemList items = client.getItems(ItemListData.all);

        TestCase.assertEquals("item", items.type);
        TestCase.assertTrue(items.data.size() > 100);
    }

    @Test
    public void testGetItem(){
        int itemId = 3089;
        String itemName = "Rabadon's Deathcap";
        Item item = client.getItem(itemId, ItemData.all);

        TestCase.assertEquals(itemName, item.name);
    }

    @Test
    public void testGetMasteries(){
        MasteryList masteries = client.getMasteries(MasteryListData.all);

        TestCase.assertEquals("mastery", masteries.type);
        TestCase.assertTrue(masteries.data.size() > 30);
    }

    @Test
    public void testGetMastery(){
        int masteryId = 4353;
        Mastery mastery = client.getMastery(masteryId, MasteryData.all);

        TestCase.assertEquals(masteryId, mastery.id);
    }

    @Test
    public void testGetRealm(){
        Realm realm = client.getRealm();

        TestCase.assertEquals("en_US", realm.l);
    }

    @Test
    public void testGetRunes(){
        RuneList runes = client.getRunes(RuneListData.all);

        TestCase.assertEquals("rune", runes.type);
    }

    @Test
    public void testGetRune(){
        int runeId = 5297;
        Rune rune = client.getRune(runeId, RuneData.all);

        TestCase.assertEquals("Greater Glyph of Ability Power", rune.name);
    }

    @Test
    public void testGetSummonerSpells(){
        SummonerSpellList spells = client.getSummonerSpells(SpellData.all);

        TestCase.assertEquals("summoner", spells.type);
        TestCase.assertTrue(spells.data.size() > 10);
    }

    @Test
    public void testGetSummonerSpell(){
        String spellId = "SummonerBoost";
        SummonerSpell spell = client.getSummonerSpell(spellId, SpellData.all);

        TestCase.assertEquals(spellId, spell.id);
    }
}
