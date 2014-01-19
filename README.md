riot-api-java
=============

A Java client for the [Riot Games API](https://developer.riotgames.com/api/methods).

## Supported API Versions
|API|Version|
|---|-------|
|champion|1.1|
|game|1.3|
|league|2.2|
|stats|1.2|
|summoner|1.3|
|team|2.2|

## Usage
### Maven dependency:
```xml
<dependency>
  <groupId>net.joelinn</groupId>
  <artifactId>riot</artifactId>
  <version>0.1.5</version>
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

## Legal Jibber Jabber
This library isn’t endorsed by Riot Games and doesn’t reflect the views or opinions of Riot Games or anyone officially involved in producing or managing League of Legends. League of Legends and Riot Games are trademarks or registered trademarks of Riot Games, Inc. League of Legends © Riot Games, Inc.
