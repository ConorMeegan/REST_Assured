package service.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

public class SoccerMatch {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("season")
    @Expose
    private SoccerSeason soccerSeason;
    @SerializedName("utcDate")
    @Expose
    private String utcDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("matchday")
    @Expose
    private Integer matchday;
    @SerializedName("stage")
    @Expose
    private String stage;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    @SerializedName("score")
    @Expose
    private SoccerScore soccerScore;
    @SerializedName("homeTeam")
    @Expose
    private SoccerHomeTeam soccerHomeTeam;
    @SerializedName("awayTeam")
    @Expose
    private SoccerAwayTeam soccerAwayTeam;
    @SerializedName("referees")
    @Expose
    private List<SoccerReferee> soccerReferees = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SoccerSeason getSoccerSeason() {
        return soccerSeason;
    }

    public void setSoccerSeason(SoccerSeason soccerSeason) {
        this.soccerSeason = soccerSeason;
    }

    public String getUtcDate() {
        return utcDate;
    }

    public void setUtcDate(String utcDate) {
        this.utcDate = utcDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public SoccerScore getSoccerScore() {
        return soccerScore;
    }

    public void setSoccerScore(SoccerScore soccerScore) {
        this.soccerScore = soccerScore;
    }

    public SoccerHomeTeam getSoccerHomeTeam() {
        return soccerHomeTeam;
    }

    public void setSoccerHomeTeam(SoccerHomeTeam soccerHomeTeam) {
        this.soccerHomeTeam = soccerHomeTeam;
    }

    public SoccerAwayTeam getSoccerAwayTeam() {
        return soccerAwayTeam;
    }

    public void setSoccerAwayTeam(SoccerAwayTeam soccerAwayTeam) {
        this.soccerAwayTeam = soccerAwayTeam;
    }

    public List<SoccerReferee> getSoccerReferees() {
        return soccerReferees;
    }

    public void setSoccerReferees(List<SoccerReferee> soccerReferees) {
        this.soccerReferees = soccerReferees;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("season", soccerSeason).append("utcDate", utcDate).append("status", status).append("matchday", matchday).append("stage", stage).append("group", group).append("lastUpdated", lastUpdated).append("score", soccerScore).append("homeTeam", soccerHomeTeam).append("awayTeam", soccerAwayTeam).append("referees", soccerReferees).toString();
    }

}
