package service.broadcaster;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import service.core.ClientRequest;

import java.util.ArrayList;

/**
 *
 * @author Alen Thomas 16333003
 *
 * */

    // TODO: When user calls just the API
    // TODO: Just a sport
    // TODO: JUST LEAGUE & DATE

@RestController
public class Broadcaster {

    //variable to store url of each sport services
    private static final String[] hosts = new String[]{"Sample Host"};

    //Soccer Field
    public static final String SOCCER = "soccer";

    public static final String NBA = "nba";

    /**
     * Soccer Matches caller
     */
    @RequestMapping(value="/soccer/{league}/{date}",method=RequestMethod.GET)
    public ClientRequest getSoccerMatches(@PathVariable("league") String league, @PathVariable("date") String date) {
        if(!league.equals("Sample league list")){
            //retun wrong league inputted
        }

        //TODO:return data after calling soccer service
        return new ClientRequest();
    }

    /**
     * NBA Matches caller
     */
    @RequestMapping(value="/nba/{date}",method=RequestMethod.GET)
    public ClientRequest getNbaMatches(@PathVariable("date")String date) {
        //TODO:return data after calling nba service
        return new ClientRequest();
    }

    // TODO: Add remaning sports
/*
    @RequestMapping(value="/{sport}/{league}/{date}",method=RequestMethod.GET)
    public String getMatch(@PathVariable("sport") String sport, @PathVariable("league") String league, @PathVariable("date") String date) {
        return "test";
    }

    @RequestMapping(value="/{sport}/{league}",method=RequestMethod.GET)
    public String getDates(@PathVariable("sport") String sport, @PathVariable("league") String league) {
        //Return details about the sport and its leagues
        return "test";
    }*/

    /**
     * Details about sport
     */
    @RequestMapping(value="/{sport}",method=RequestMethod.GET)
    public String getLeague(@PathVariable("sport") String sport) {
        if(sport.equals(SOCCER)){
            //TODO:print out method to call API and its leagues
        }
        else if(sport.equals(NBA)){
            //TODO:print out correct call to NBA
        }
        else{
            //TODO:Return invalid sport service
        }
        return "test";
    }

    @RequestMapping(value="/information",method=RequestMethod.GET)
    public String getSport() {
        return "Test";
    }

}
