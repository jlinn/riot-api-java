package net.joelinn.riot.team.dto;

import java.util.Date;

/**
 * Joe Linn
 * 12/14/13
 */
public class Team {
    public Date createDate;
    public String fullId;
    public Date lastGameDate;
    public Date lastJoinDate;
    public Date lastJoinedRankedTeamQueueDate;
    public MatchHistorySummary[] matchHistory;
    public MessageOfDay messageOfDay;
    public Date modifyDate;
    public String name;
    public Roster roster;
    public Date secondLastJoinDate;
    public String status;
    public String tag;
    public TeamStatsSummary teamStatSummary;
    public Date thirdLastJoinDate;
}
