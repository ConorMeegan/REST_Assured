
package service.core.nba;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class NBAHomeTeam {

    @SerializedName("teamId")
    @Expose
    private String teamId;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("nickName")
    @Expose
    private String nickName;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("score")
    @Expose
    private NBAScore NBAScore;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public NBAScore getNBAScore() {
        return NBAScore;
    }

    public void setNBAScore(NBAScore NBAScore) {
        this.NBAScore = NBAScore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("teamId", teamId).append("shortName", shortName).append("fullName", fullName).append("nickName", nickName).append("logo", logo).append("NBAScore", NBAScore).toString();
    }

}
