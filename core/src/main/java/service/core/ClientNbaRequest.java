package service.core;

import service.core.nba.NBAGame;
import service.core.soccer.SoccerMatch;

import java.util.ArrayList;
import java.util.List;

public class ClientNbaRequest {

    public static final String TYPE = "NBA";
    public String date;
    public ArrayList<MatchDetails> matches = new ArrayList<>();

    public ClientNbaRequest(){}

    public ClientNbaRequest(String date, List<NBAGame> nbaGamesList){
        this.date = date;
        for (NBAGame nbaGame: nbaGamesList) {
            String hometeam = nbaGame.getHomeTeam().getFullName();
            String awayteam = nbaGame.getAwayTeam().getFullName();
            String hometeamscore = nbaGame.getHomeTeam().getNBAScore().getPoints();
            String awayteamscore = nbaGame.getAwayTeam().getNBAScore().getPoints();
            String status = nbaGame.getStatusGame();

            MatchDetails matchDetails = new MatchDetails(nbaGame.getHomeTeam().getFullName(), nbaGame.getAwayTeam().getFullName(), nbaGame.getHomeTeam().getNBAScore().getPoints(), nbaGame.getAwayTeam().getNBAScore().getPoints(), nbaGame.getStatusGame());
            matches.add(matchDetails);
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<MatchDetails> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<MatchDetails> matches) {
        this.matches = matches;
    }
}
