package service.core;

import service.core.nba.NBAGame;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class to handle client request for Nba matches
 * Returns the date chosen and list of MatchDetails
 *
 * @author Alen Thomas 16333003*/

public class ClientNbaRequest {

    public static final String TYPE = "NBA";
    public String date;
    public ArrayList<MatchDetails> matches = new ArrayList<>();

    public ClientNbaRequest(){}

    public ClientNbaRequest(String date, List<NBAGame> nbaGamesList){
        this.date = date;
        for (NBAGame nbaGame: nbaGamesList) {
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
