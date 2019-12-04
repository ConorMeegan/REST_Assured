import java.util.Date;
import java.util.List;

public class ClientRequest {
    public enum Leagues{
        CHAMPIONS_LEAGUE,
        PRIMEIRA_LIGA,
        PREMIER_LEAGUE,
        EREDIVISIE,
        BUNDESLIGA,
        LIGUE_1,
        SERIE_A_IT,
        LA_LIGA,
        CHAMPIONSHIP,
        SERIE_A_BR,
        WORLDCUP,
        EUROPE
    }

    private Leagues league;
    private Date startDate;
    private Date endDate;
    private List<String> teams;

    public ClientRequest(){ }

    public Leagues getLeague(){ return league; }
    public Date getStartDate(){ return startDate; }
    public Date getEndDate(){ return endDate; }
    public List<String> getTeams(){ return teams; }

    public void setLeague(Leagues league) { this.league = league; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public void setTeams(List<String> teams) { this.teams = teams; }
}
