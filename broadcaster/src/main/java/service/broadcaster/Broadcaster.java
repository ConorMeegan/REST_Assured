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


    @RequestMapping(value="/{sport}/{league}/{date}",method=RequestMethod.GET)
    public String getMatch(@PathVariable("sport") String sport, @PathVariable("league") String league, @PathVariable("date") String date) {
        return "test";
    }

    @RequestMapping(value="/{sport}/{league}",method=RequestMethod.GET)
    public String getDates(@PathVariable("sport") String sport, @PathVariable("league")String league) {
        return "test";
    }

    @RequestMapping(value="/{sport}",method=RequestMethod.GET)
    public String getLeague(@PathVariable("sport") String sport) {
        return "test";
    }

    @RequestMapping(value="/information",method=RequestMethod.GET)
    public String getSport() {
        return "Test";
    }

}
