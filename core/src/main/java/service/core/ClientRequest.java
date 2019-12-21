package service.core;

import java.util.ArrayList;

public class ClientRequest {
    public String league;
    public String date;
    public ArrayList<MatchDetails> matches;

    public ClientRequest(){}

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
