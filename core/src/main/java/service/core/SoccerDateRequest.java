package service.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

public class SoccerDateRequest {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("filters")
    @Expose
    private SoccerFilters soccerFilters;
    @SerializedName("competition")
    @Expose
    private SoccerCompetition soccerCompetition;
    @SerializedName("matches")
    @Expose
    private List<SoccerMatch> soccerMatches = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public SoccerFilters getSoccerFilters() {
        return soccerFilters;
    }

    public void setSoccerFilters(SoccerFilters soccerFilters) {
        this.soccerFilters = soccerFilters;
    }

    public SoccerCompetition getSoccerCompetition() {
        return soccerCompetition;
    }

    public void setSoccerCompetition(SoccerCompetition soccerCompetition) {
        this.soccerCompetition = soccerCompetition;
    }

    public List<SoccerMatch> getSoccerMatches() {
        return soccerMatches;
    }

    public void setSoccerMatches(List<SoccerMatch> soccerMatches) {
        this.soccerMatches = soccerMatches;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("count", count).append("filters", soccerFilters).append("competition", soccerCompetition).append("matches", soccerMatches).toString();
    }

}
