
package service.nba;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class HTeam {

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
    private Score_ score;

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

    public Score_ getScore() {
        return score;
    }

    public void setScore(Score_ score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("teamId", teamId).append("shortName", shortName).append("fullName", fullName).append("nickName", nickName).append("logo", logo).append("score", score).toString();
    }

}
