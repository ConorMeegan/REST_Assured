package service.broadcaster;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import service.core.ClientNbaRequest;
import service.core.ClientSoccerRequest;

import java.util.Arrays;
import java.util.List;

/**
 *This is the main service to which other services connect to
 * IT access the other services based on user choosing soccer or nba
 * Due to soccer's leagues the values were split
 * Return is the body stored in core
 *
 * @author Alen Thomas 16333003
 *
 * */

@RestController
public class Broadcaster {

    //Soccer Field
    private static final String SOCCER = "soccer";
    private static final String SOCCERSERVICE = "http://soccer:8083/";
    //NBA field
    private static final String NBA = "nba";
    private static final String NBASERVICE = "http://nba:8082/";

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
            return (ClientSoccerRequest) restTemplate.getForObject(url, ClientSoccerRequest.class);
        }
        else{
            //return empty if invalid input
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
        return (ClientNbaRequest) restTemplate.getForObject(url, ClientNbaRequest.class);
    }

    /**
     * Details about sport
     */
    @RequestMapping(value="/{sport}",method=RequestMethod.GET)
    public String getLeague(@PathVariable("sport") String sport) {
        switch (sport) {
            case SOCCER:
                //print out method to call API and its leagues
                return SOCCERINFORMATION;
            case NBA:
                //print out correct call to NBA
                return NBAINFORMATION;
            default:
                //return information about sport
                return INFORMATION;
        }
    }

    /**
     * Details about broadcaster and how to call it
     */

    @RequestMapping(value="/information",method=RequestMethod.GET)
    public String getSport() {
        return BASICINFORMATION;
    }


    private static final String SOCCERINFORMATION = "This is the soccer service, \nPlease insert the method call as follows: /league/date"
            + "\nList of leagues:\n" + Arrays.toString(leagues);

    private static final String NBAINFORMATION = "This is the soccer service, \nPlease insert the method call as follows: /date";

    private static final String INFORMATION = "Please choose between two sport services with valid inputs: 1.soccer/league/date 2.nba/date. Date format = yyyy-mm-dd";

    private static final String BASICINFORMATION = "Welcome to REST ASSURED sports score service. Currently we have 2 services, soccer(nomal football) and nba(Basketball)." + INFORMATION;


}
