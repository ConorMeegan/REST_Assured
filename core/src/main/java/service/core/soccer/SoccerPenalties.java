package service.core.soccer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SoccerPenalties {

    @SerializedName("homeTeam")
    @Expose
    private Object homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private Object awayTeam;

    public Object getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Object homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Object getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Object awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("homeTeam", homeTeam).append("awayTeam", awayTeam).toString();
    }

}
