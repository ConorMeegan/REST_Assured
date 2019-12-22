package service.soccer;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import service.core.ClientSoccerRequest;
import service.core.soccer.SoccerDateRequest;
import service.core.soccer.SoccerMatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

@RestController
public class SoccerService {

    public static SoccerDateRequest getSoccerDateRequest(String urlTarget) {
        Gson gson = new Gson();
        String json = null;
        SoccerDateRequest result = null;

        json = getJsonFromUrl(urlTarget);

        if (json != null) {
            result = gson.fromJson(json, SoccerDateRequest.class);
        }

        return result;
    }

    public static String getJsonFromUrl(String urlTarget) {
        try {
            URL url = new URL(urlTarget);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            http.setRequestMethod("GET");
            http.setRequestProperty("X-Auth-Token", "13a1702cdce3404ba04145de036a39b8");
            http.setUseCaches(false);
            http.setAllowUserInteraction(false);
            http.connect();

            if (http.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }

                br.close();
                return sb.toString();

            }else {
                return http.getResponseMessage();
            }

        } catch (ProtocolException e) {
            e.printStackTrace();
            return "Error";

        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @RequestMapping(value="/{league}/{date}", method=RequestMethod.GET)
    public ClientSoccerRequest getMatches(@PathVariable("league") String league, @PathVariable("date") String date) {
        String url = "https://api.football-data.org/v2/competitions/" + league +"/matches?dateFrom="+ date +"&dateTo=" + date;
        List<SoccerMatch> soccerMatches = getSoccerDateRequest(url).getSoccerMatches();
        return new ClientSoccerRequest(league, date, soccerMatches);
    }

}
