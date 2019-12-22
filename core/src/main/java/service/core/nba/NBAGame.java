
package service.core.nba;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class NBAGame {

    @SerializedName("seasonYear")
    @Expose
    private String seasonYear;
    @SerializedName("league")
    @Expose
    private String league;
    @SerializedName("gameId")
    @Expose
    private String gameId;
    @SerializedName("startTimeUTC")
    @Expose
    private String startTimeUTC;
    @SerializedName("endTimeUTC")
    @Expose
    private String endTimeUTC;
    @SerializedName("arena")
    @Expose
    private String arena;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("clock")
    @Expose
    private String clock;
    @SerializedName("gameDuration")
    @Expose
    private String gameDuration;
    @SerializedName("currentPeriod")
    @Expose
    private String currentPeriod;
    @SerializedName("halftime")
    @Expose
    private String halftime;
    @SerializedName("EndOfPeriod")
    @Expose
    private String endOfPeriod;
    @SerializedName("seasonStage")
    @Expose
    private String seasonStage;
    @SerializedName("statusShortGame")
    @Expose
    private String statusShortGame;
    @SerializedName("statusGame")
    @Expose
    private String statusGame;
    @SerializedName("NBAAwayTeam")
    @Expose
    private NBAAwayTeam NBAAwayTeam;
    @SerializedName("NBAHomeTeam")
    @Expose
    private NBAHomeTeam NBAHomeTeam;

    public String getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(String seasonYear) {
        this.seasonYear = seasonYear;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getStartTimeUTC() {
        return startTimeUTC;
    }

    public void setStartTimeUTC(String startTimeUTC) {
        this.startTimeUTC = startTimeUTC;
    }

    public String getEndTimeUTC() {
        return endTimeUTC;
    }

    public void setEndTimeUTC(String endTimeUTC) {
        this.endTimeUTC = endTimeUTC;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(String gameDuration) {
        this.gameDuration = gameDuration;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public String getHalftime() {
        return halftime;
    }

    public void setHalftime(String halftime) {
        this.halftime = halftime;
    }

    public String getEndOfPeriod() {
        return endOfPeriod;
    }

    public void setEndOfPeriod(String endOfPeriod) {
        this.endOfPeriod = endOfPeriod;
    }

    public String getSeasonStage() {
        return seasonStage;
    }

    public void setSeasonStage(String seasonStage) {
        this.seasonStage = seasonStage;
    }

    public String getStatusShortGame() {
        return statusShortGame;
    }

    public void setStatusShortGame(String statusShortGame) {
        this.statusShortGame = statusShortGame;
    }

    public String getStatusGame() {
        return statusGame;
    }

    public void setStatusGame(String statusGame) {
        this.statusGame = statusGame;
    }

    public NBAAwayTeam getAwayTeam() {
        return NBAAwayTeam;
    }

    public void setAwayTeam(NBAAwayTeam NBAAwayTeam) {
        this.NBAAwayTeam = NBAAwayTeam;
    }

    public NBAHomeTeam getHomeTeam() {
        return NBAHomeTeam;
    }

    public void setHomeTeam(NBAHomeTeam NBAHomeTeam) {
        this.NBAHomeTeam = NBAHomeTeam;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("seasonYear", seasonYear).append("league", league).append("gameId", gameId).append("startTimeUTC", startTimeUTC).append("endTimeUTC", endTimeUTC).append("arena", arena).append("city", city).append("country", country).append("clock", clock).append("gameDuration", gameDuration).append("currentPeriod", currentPeriod).append("halftime", halftime).append("endOfPeriod", endOfPeriod).append("seasonStage", seasonStage).append("statusShortGame", statusShortGame).append("statusGame", statusGame).append("NBAAwayTeam", NBAAwayTeam).append("NBAHomeTeam", NBAHomeTeam).toString();
    }

}
