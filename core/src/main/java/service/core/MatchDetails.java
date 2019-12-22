package service.core;

public class MatchDetails {

    public String homeTeam;
    public String awayTeam;
    public String homeTeamScore;
    public String awayTeamScore;
    public String status;

    public MatchDetails(){}

    public MatchDetails(String homeTeam, String awayTeam, String homeTeamScore, String awayTeamScore, String status){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.status = status;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(String homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public String getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(String awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }




}
