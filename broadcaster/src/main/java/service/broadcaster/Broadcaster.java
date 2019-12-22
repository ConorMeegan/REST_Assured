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

    /**
     * Details about sport
     */
    @RequestMapping(value="/{sport}",method=RequestMethod.GET)
    public String getLeague(@PathVariable("sport") String sport) {
        if(sport.equals(SOCCER)){
            //print out method to call API and its leagues
            return SOCCERINFORMATION;
        }
        else if(sport.equals(NBA)){
            //print out correct call to NBA
            return NBAINFORMATION;
        }
        else{
            //return information about sport
            return INFORMATION;
        }
    }

    @RequestMapping(value="/information",method=RequestMethod.GET)
    public String getSport() {
        return BASICINFORMATION;
    }

    public static final String SOCCERINFORMATION = "This is the soccer service, \nPlease insert the method call as follows: /league/date"
            + "\nList of leagues:\n" + Arrays.toString(leagues);

    public static final String NBAINFORMATION = "This is the soccer service, \nPlease insert the method call as follows: /date";

    public static final String INFORMATION = "Please choose between two sport services with valid inputs: 1.soccer/league/date 2.nba/date";

    public static final String BASICINFORMATION = "Welcome to REST ASSURED sports score service. Currently we have 2 services, soccer(nomal football) and nba(Basketball)." + INFORMATION;


}
