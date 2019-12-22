package service.broadcaster;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import service.core.ClientNbaRequest;
import service.core.ClientSoccerRequest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private static final String SOCCER = "soccer";
    private static final String SOCCERSERVICE = "http://localhost:8083/";
    //NBA field
    private static final String NBA = "nba";
    private static final String NBASERVICE = "http://localhost:8082/";

    //list of leagues for soccer
    private static final String[] leagues = new String[]{"CL", "PPL", "PL", "DED", "BL1", "FL1", "SA", "PD", "ELC","BSA", "WC", "EC"};

    /**
     * Soccer Matches caller
     */
    @RequestMapping(value="/soccer/{league}/{date}",method=RequestMethod.GET)
    public ClientSoccerRequest getSoccerMatches(@PathVariable("league") String league, @PathVariable("date") String date) {

        //List to check if item is in it
        List<String> leaguesList = Arrays.asList(leagues);

        //check to see if leagues input is correct
        if(leaguesList.contains(league)){

            //create Rest Template
            RestTemplate restTemplate = new RestTemplate();

            //build REST URL to call
            String url = SOCCERSERVICE + league + "/" + date;

            //Return URL for the ClientSoccerRequest
            return restTemplate.getForObject(url, ClientSoccerRequest.class);
        }
        else{
            return new ClientSoccerRequest();
        }
    }

    /**
     * NBA Matches caller
     */
    @RequestMapping(value="/nba/{date}",method=RequestMethod.GET)
    public ClientNbaRequest getNbaMatches(@PathVariable("date")String date) {

        //create Rest Template
        RestTemplate restTemplate = new RestTemplate();

        //build REST URL to call
        String url = NBASERVICE + date;

        //Return URL for the ClientNbaRequest
        return restTemplate.getForObject(url, ClientNbaRequest.class);
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
