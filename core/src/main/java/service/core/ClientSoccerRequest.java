package service.core;

import service.core.soccer.SoccerMatch;
import java.util.ArrayList;
import java.util.List;


/**
 * Model class to handle client request for Soccer matches
 * Returns the league, date chosen and list of MatchDetails
 *
 * @author Alen Thomas 16333003*/
public class ClientSoccerRequest {

    public static final String TYPE = "Soccer";
    public String league;
    public String date;
    public ArrayList<MatchDetails> matches = new ArrayList<>();

    public ClientSoccerRequest(){}

    public ClientSoccerRequest(String league, String date, List<SoccerMatch> soccerMatchList){
        this.league = league;
        this.date = date;
        for (SoccerMatch soccermatch: soccerMatchList) {
            matches.add(new MatchDetails(soccermatch.getSoccerHomeTeam().getName(), soccermatch.getSoccerAwayTeam().getName(), soccermatch.getSoccerScore().getSoccerFullTime().getHomeTeam().toString(), soccermatch.getSoccerScore().getSoccerFullTime().getAwayTeam().toString(), soccermatch.getStatus()));
        }
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
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
