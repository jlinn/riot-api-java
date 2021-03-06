riot-api-java
=============

A Java client for the [Riot Games API](https://developer.riotgames.com/api/methods).

## Supported API Versions
|API|Version|
|---|-------|
|champion|1.2|
|game|1.3|
|league|2.4|
|stats|1.3|
|summoner|1.4|
|team|2.3|

## Usage
### Maven dependency:
```xml
<dependency>
  <groupId>net.joelinn</groupId>
  <artifactId>riot</artifactId>
  <version>0.2.1</version>
</dependency>
```

### Instantiating the client object:
```java
Riot client = new Riot("your-api-key", Region.NA);
```

### Champion calls
```java
// Retrieving all champions
ChampionList champions = client.champion().getChampions();
```

### Summoner calls
```java
// Retrieving a summoner by name
Map<String, Summoner> summoners = client.summoner().getSummoner("SummonerName");
Summoner summoner = summoners.get("SummonerName");
```

### Game calls
```java
// Retrieving a summoner's recent games
RecentGames games = client.game().getRecentGamesBySummoner(summonerId);
```

### League calls
```java
// Retrieving league data by summoner id
List<League> leagues = client.league().getLeaguesBySummoner(summonerId);
```

### Static data calls
```java
// Retrieving items data, including all optionally returned data
ItemList items = client.staticData().getItems(ItemListData.all);
```

## Legal Jibber Jabber
This library isn’t endorsed by Riot Games and doesn’t reflect the views or opinions of Riot Games or anyone officially involved in producing or managing League of Legends. League of Legends and Riot Games are trademarks or registered trademarks of Riot Games, Inc. League of Legends © Riot Games, Inc.
