package service.core.soccer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SoccerScore {

    @SerializedName("winner")
    @Expose
    private String winner;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("fullTime")
    @Expose
    private SoccerFullTime soccerFullTime;
    @SerializedName("halfTime")
    @Expose
    private SoccerHalfTime soccerHalfTime;
    @SerializedName("extraTime")
    @Expose
    private SoccerExtraTime soccerExtraTime;
    @SerializedName("penalties")
    @Expose
    private SoccerPenalties soccerPenalties;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public SoccerFullTime getSoccerFullTime() {
        return soccerFullTime;
    }

    public void setSoccerFullTime(SoccerFullTime soccerFullTime) {
        this.soccerFullTime = soccerFullTime;
    }

    public SoccerHalfTime getSoccerHalfTime() {
        return soccerHalfTime;
    }

    public void setSoccerHalfTime(SoccerHalfTime soccerHalfTime) {
        this.soccerHalfTime = soccerHalfTime;
    }

    public SoccerExtraTime getSoccerExtraTime() {
        return soccerExtraTime;
    }

    public void setSoccerExtraTime(SoccerExtraTime soccerExtraTime) {
        this.soccerExtraTime = soccerExtraTime;
    }

    public SoccerPenalties getSoccerPenalties() {
        return soccerPenalties;
    }

    public void setSoccerPenalties(SoccerPenalties soccerPenalties) {
        this.soccerPenalties = soccerPenalties;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("winner", winner).append("duration", duration).append("fullTime", soccerFullTime).append("halfTime", soccerHalfTime).append("extraTime", soccerExtraTime).append("penalties", soccerPenalties).toString();
    }

}
